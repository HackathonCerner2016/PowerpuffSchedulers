package ro.cerner.envdashboard;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import ro.cerner.envdashboard.businesslogic.CheckResult;
import ro.cerner.envdashboard.businesslogic.Checker;
import ro.cerner.envdashboard.businesslogic.checkers.DatabaseChecker;
import ro.cerner.envdashboard.businesslogic.checkers.DummyChecker;
import ro.cerner.envdashboard.businesslogic.checkers.LoginSchedulingChecker;
import ro.cerner.envdashboard.businesslogic.checkers.PingChecker;

@Component
public class ScheduledTasks {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        System.out.println("The time is now " + dateFormat.format(new Date()));
    }
    
    @Scheduled(fixedRate = 5000)
    public void runDummyChecker() {
        Random random = new Random();
        
        Checker dummyChecker = new DummyChecker("DummyChecker", random.nextInt(), random.nextBoolean());
        
        CheckResult checkResult = dummyChecker.check();
        
        System.out.println("DummyChecker.check() => " + checkResult);	
    }
    
    @Scheduled(fixedRate = 5000)
    public void runPingChecker() {
        Checker pingChecker = new PingChecker("usmlvv1srn284", "10.175.125.55");
        
        CheckResult checkResult = pingChecker.check();
        
        System.out.println("PingChecker.check() => " + checkResult);	
    }
    
    @Scheduled(fixedRate = 5000)
    public void runDatabaseChecker() {
        Checker databaseChecker = new DatabaseChecker("USMLVV1SRN284", "SD_SCHDATA", "1433", "sa", "TEETIME@PEBBLEBEACH23");
        
        CheckResult checkResult = databaseChecker.check();
        
        System.out.println("DatabaseChecker.check() => " + checkResult);	
    }
    
    @Scheduled(fixedRate = 5000)
    public void runLoginSchedulingChecker() {
        
    	Checker loginSchedulingChecker = null;
		loginSchedulingChecker = new LoginSchedulingChecker("https://usmlvv1srn284.usmlvv1d0a.smshsc.net/sd/scheduling/security/Logon.pba", "test9", "test9");
		CheckResult checkResult = loginSchedulingChecker.check();
        
        System.out.println("LoginSchedulingChecker.check() => " + checkResult);	
    }
}
