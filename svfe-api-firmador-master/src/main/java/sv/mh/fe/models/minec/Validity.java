package sv.mh.fe.models.minec;

public class Validity {

	private TempDate notBefore;
	
	private TempDate notAfter;

	public Validity(TempDate notBefore, TempDate notAfter) {
		super();
		this.notBefore = notBefore;
		this.notAfter = notAfter;
	}
	
	public Validity() {
		super();
		this.notBefore = new TempDate();
		this.notAfter = new TempDate();	
	}
		
	public TempDate getNotBefore() {
		return notBefore;
	}

	public void setNotBefore(TempDate notBefore) {
		this.notBefore = notBefore;
	}

	public TempDate getNotAfter() {
		return notAfter;
	}

	public void setNotAfter(TempDate notAfter) {
		this.notAfter = notAfter;
	}
}
