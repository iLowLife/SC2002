package pack;
import java.util.*;
import java.io.Console;
import java.io.Serializable;
/*
 * @author SE1 Group 4
 * @version 13/11/2022
 * 
 */
public class User implements Serializable{

	private String Name;
	private String Email;
	private String Password;
	//private static boolean Role;

	/** 
	 * @param Name 
	 * @param Email
	 * @param Password
	 */
	public User(String Name, String Email, String Password) {
		this.Name=Name;
		this.Email=Email;
		this.Password=Password;
	}
	/** 
	 * @return String
	 */
	public String getName() {
		return this.Name;
	}
	/** 
	 * @param String
	 */
	public void setName(String Name) {
		this.Name=Name;
	}
	/** 
	 * @return String
	 */
	public String getEmail() {
		return this.Email;
	}
	/** 
	 * @param String
	 */
	public void setEmail(String Email) {
		this.Email=Email;
	}
	/** 
	 * @return String
	 */
	public String getPassword() {
		return this.Password;
	}
	/** 
	 * @param String
	 */
	public void setPassword(String Password) {
		this.Password=Password;
	}
	
}
