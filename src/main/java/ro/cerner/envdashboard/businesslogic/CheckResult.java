package ro.cerner.envdashboard.businesslogic;

public final class CheckResult {
    public final boolean status;
    public final String message;

    public CheckResult(boolean status, String message) {
        super();
        this.status = status;
        this.message = message;
    }

    @Override
    public String toString() {
        return "CheckResult [status=" + status + ", message=" + message + "]";
    }

}
