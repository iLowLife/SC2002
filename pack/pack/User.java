package pack;
import java.util.*;
import java.io.Console;
import java.io.Serializable;
public class User implements Serializable{

	private String Name;
	private String Email;
	private String Password;
	//private static boolean Role;

	public User(String Name, String Email, String Password) {
		this.Name=Name;
		this.Email=Email;
		this.Password=Password;
	}
	
	public String getName() {
		return this.Name;
	}
	
	public void setName(String Name) {
		this.Name=Name;
	}
	
	public String getEmail() {
		return this.Email;
	}
	
	public void setEmail(String Email) {
		this.Email=Email;
	}
	
	public String getPassword() {
		return this.Password;
	}
	
	public void setPassword(String Password) {
		this.Password=Password;
	}
	
}
