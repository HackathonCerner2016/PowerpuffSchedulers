package ro.cerner.envdashboard.businesslogic.checkers;

import static ro.cerner.envdashboard.businesslogic.CheckStatus.FAILURE;
import static ro.cerner.envdashboard.businesslogic.CheckStatus.SUCCESS;
import static ro.cerner.envdashboard.businesslogic.CheckStatus.WARNING;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import ro.cerner.envdashboard.businesslogic.CheckResult;
import ro.cerner.envdashboard.businesslogic.CheckStatus;
import ro.cerner.envdashboard.businesslogic.Checker;
import ro.cerner.envdashboard.persistence.mapper.CheckerPropertiesRecord;
import ro.cerner.envdashboard.persistence.mapper.CheckerRecord;

public class WindowsServiceChecker implements Checker {

    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private String host;
    private String serviceName;

    @Value("${checkers.windowsService.name}")
    private String name;

    public WindowsServiceChecker(CheckerRecord checker) {
        final String hostDb = "Host";
        final String serviceNameDb = "ServiceName";
        
        this.id = checker.getId();
        
        List<CheckerPropertiesRecord> checkerPropertiesRecordList = checker.getCheckerPropertiesRecordList();
        
        
        for (CheckerPropertiesRecord checkerPropertiesRecord : checkerPropertiesRecordList) {
            switch (checkerPropertiesRecord.getFieldName()) {
            case (hostDb):
                host = checkerPropertiesRecord.getFieldValue();
                break;
            case (serviceNameDb):
                serviceName = checkerPropertiesRecord.getFieldValue();
                break;
            }
        }
    }

    @Override
    public CheckResult check() {

        try {
            Process process = createScProcess();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            return getServiceState(reader);

        } catch (IOException e) {
            return new CheckResult(FAILURE, e.getMessage());
        }

    }

    private Process createScProcess() throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder("sc", "\\\\" + host, "query", serviceName);
        Process process = processBuilder.start();
        return process;
    }

    private CheckResult getServiceState(BufferedReader reader) {
        CheckStatus status = FAILURE;
        String message = "";

        try {
            String line = reader.readLine();

            while (line != null) {
                if (line.trim().startsWith("STATE")) {
                    String stateId = line.trim().substring(line.trim().indexOf(":") + 1, line.trim().indexOf(":") + 4)
                        .trim();

                    switch (stateId) {
                        case "1":
                            message = "Stopped";
                            break;
                        case "2":
                            status = WARNING;
                            message = "Startting....";
                            break;
                        case "3":
                            status = WARNING;
                            message = "Stopping....";
                            break;
                        case "4":
                            status = SUCCESS;
                            message = "Running";
                            break;
                    }

                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            status = FAILURE;
            message = e.getMessage();
        }

        return new CheckResult(status, message);
    }

    @Override
    public String getName() {
        return name;
    }

    public String getHost() {
        return host;
    }

    public String getServiceName() {
        return serviceName;
    }

	@Override
	public Integer getId() {
		return this.id;
	}

}
