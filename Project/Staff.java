public class Staff extends User {

	private String Title;
	private int StaffID;
	private boolean Shift;

	//String eMail[]= {"abc@outlook.com","qwer@hotmail.com", "xyz@gmail.com","pork@outlook.com", "qaz@gmail.com"};
	//String pAss[]= {"1234abc","dbzy23","qwe345","tajey10985","prke1956"};
	
	public Staff(String Title, int StaffID, boolean Shift, String Name, String Email, String Password) {
		super(Name,Email,Password);
		this.Title=Title;
		this.StaffID=StaffID;
		this.Shift=Shift;
	}
	
	
	
	
	
	public void addMovieSchedule() {
		
	}
	
	
	
}
