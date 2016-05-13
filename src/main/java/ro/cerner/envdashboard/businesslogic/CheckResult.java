package ro.cerner.envdashboard.businesslogic;

public final class CheckResult {
    public final CheckStatus status;
    public final String message;
    
	public CheckResult(CheckStatus status, String message) {
		this.status = status;
		this.message = message;
	}
    
	public CheckResult(CheckStatus status) {
		this(status, "");
	}

	@Override
	public String toString() {
		return "CheckResult [status=" + status + ", message=" + message + "]";
	}
	
}
