package ro.cerner.envdashboard.businesslogic.checkers;

import static ro.cerner.envdashboard.businesslogic.CheckStatus.SUCCESS;

import ro.cerner.envdashboard.businesslogic.CheckResult;
import ro.cerner.envdashboard.businesslogic.CheckStatus;
import ro.cerner.envdashboard.businesslogic.Checker;

/**
 * @author ID041663
 *
 */
public class DummyChecker implements Checker {

	private String name;
	
	private int checkerId;
	
	private boolean mokedResult =false;

	@Override
	public CheckResult check() { 
		
		if(mokedResult)
		{
			return new CheckResult(SUCCESS);
		} else {
			return new CheckResult(CheckStatus.FAILURE, "Checker " + checkerId +  ", " +  name + " failed because of an unknown reason");
		}
		
	}
	
	
	public DummyChecker(String name, int checkerId, boolean mokedResult) {
		super();
		this.name = name;
		this.checkerId = checkerId;
		this.mokedResult = mokedResult;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCheckerId() {
		return checkerId;
	}

	public void setCheckerId(int checkerId) {
		this.checkerId = checkerId;
	}

	public boolean isMokedResult() {
		return mokedResult;
	}

	public void setMokedResult(boolean mokedResult) {
		this.mokedResult = mokedResult;
	}

	

}
