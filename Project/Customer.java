public class Customer extends User {

	private String UserID;
	private String typeOfCustomer;

	public Customer(String Name, String Email, String Password, String typeOfCustomer) {
		super(Name, Email, Password);
		this.UserID=Email;
		this.typeOfCustomer=typeOfCustomer;
	}

	public String getUserID() {
		return this.UserID;
	}
	
	public String getType() {
		return this.typeOfCustomer;
	}
	
}
