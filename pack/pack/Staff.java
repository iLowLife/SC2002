package pack;
/*
 * @author SE1 Group 4
 * @version 13/11/2022
 * 
 */
public class Staff extends User {

	private String Title;
	private int StaffID;
	private boolean Shift;
	private int count=0;
	
	/** 
	 * @param Title 
	 * @param Shift
	 * @param Name
	 * @param Email
	 * @param Password
	 */
	public Staff(String Title, boolean Shift, String Name, String Email, String Password) {
		super(Name,Email,Password);
		this.Title=Title;
		this.StaffID= count++;
		this.Shift=Shift;
	}
	/** 
	 * @return String
	 */
	public String getEmail() {
		return super.getEmail();
	}
	/** 
	 * @return String
	 */
	public String getName() {
		return super.getName();
	}
	/** 
	 * @return String
	 */
	public String getPassword() {
		return super.getPassword();
	}
	/** 
	 * @return String
	 */
	public String getTitle() {
		return this.Title;
	}

	
	/** 
	 * @param Title
	 */
	public void setTitle(String Title) {
		this.Title=Title;
	}
	/** 
	 * @return int
	 */
	public int getStaffID() {
		return this.StaffID;
	}

	
	/** 
	 * @param StaffID
	 */
	public void setStaffID(int StaffID) {
		this.StaffID=StaffID;
	}
	/** 
	 * @return boolean
	 */
	public boolean getShift() {
		return this.Shift;
	}

	
	/** 
	 * @param Shift
	 */
	public void setShift(boolean Shift) {
		this.Shift=Shift;
	}
}
