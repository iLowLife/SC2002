package pack;
public class Staff extends User {

	private String Title;
	private int StaffID;
	private boolean Shift;
	private int count=0;
	
	public Staff(String Title, boolean Shift, String Name, String Email, String Password) {
		super(Name,Email,Password);
		this.Title=Title;
		this.StaffID= count++;
		this.Shift=Shift;
	}

	public String getEmail() {
		return super.getEmail();
	}

	public String getName() {
		return super.getName();
	}

	public String getPassword() {
		return super.getPassword();
	}
	
	public String getTitle() {
		return this.Title;
	}

	public void setTitle(String Title) {
		this.Title=Title;
	}

	public int getStaffID() {
		return this.StaffID;
	}

	public void setStaffID(int StaffID) {
		this.StaffID=StaffID;
	}

	public boolean getShift() {
		return this.Shift;
	}

	public void setShift(boolean Shift) {
		this.Shift=Shift;
	}

	public void getCustomer() {
		// TODO - implement Staff.getCustomer
		throw new UnsupportedOperationException();
	}

	public void getMovie() {
		// TODO - implement Staff.getMovie
		throw new UnsupportedOperationException();
	}

	public void addMovieSchedule() {
		
	}

}
