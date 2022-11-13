package pack;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/*
 * @author SE1 Group 4
 * @version 13/11/2022
 * 
 */
public class MovieSchedule {
		//XXXYYYYMMDDhhmm (Y : year, M : month, D : day, h : hour, m : minutes, XXX : cinema code in letters)
	private String Movie;
	private int RoomID;
	private String ShowTime; //YYYYMMDDhhmm
	private String CinemaID;
	private Room Room; //1 movie schedule object will creates 1 new room object

	/** 
	 * @param Movie 
	 * @param RoomID
	 * @param CinemaID
	 * @param ShowTime
	 */
	public MovieSchedule(String Movie, int RoomID,String CinemaID, String ShowTime) {
		this.Movie = Movie;		  // CineplexID + CinemaID + ShowTime
		this.RoomID = RoomID;	  // " 
		this.ShowTime = ShowTime; //"YYYYMMDDhhmm"
		this.CinemaID = CinemaID; //"XXX"
		this.Room = new Room(RoomID);	//create a new room object
	}

	
	/** 
	 * @return String
	 */
	//Getter
	public String getMovie() {
		return this.Movie;
	}

	
	/** 
	 * @return int
	 */
	public int getRoomID() {
		return this.RoomID;
	}

	
	/** 
	 * @return String
	 */
	public String getShowTime() {
		return this.ShowTime;
	}

	
	/** 
	 * @return String
	 */
	public String getCinemaID() {
		return this.CinemaID;
	}

	
	/** 
	 * @return String
	 */
	public String getCineplex() {
		//decode CineplexID to get location
		String a = this.CinemaID.substring(0, 2);
		if (a.equals("GV")) 
			return "Golden Village";
		else if (a.equals("SW")) 
			return "Shaws";
		else if (a.equals("CT")) 
			return "Cathay";
		else
			return "NA";
	}

	
	/** 
	 * @return int
	 */
	public int getCineplexID() {
		//decode CineplexID to get location
		String a = this.CinemaID.substring(0, 2);
		if (a.equals("GV")) 
			return 0;
		else if (a.equals("SW")) 
			return 1;
		else if (a.equals("CT")) 
			return 2;
		else
			return -1;
	}

	
	/** 
	 * @return int
	 */
	public int getLocation(){
		return Integer.valueOf(this.CinemaID.substring(2, 3));
	}

	
	/** 
	 * @return Room
	 */
	public Room getRoom() {
		return this.Room;
	}

	
	/** 
	 * @return Date
	 */
	public Date getDateTime(){
		String sDate1 = this.ShowTime;
		Date date1 = null;
		try {
			date1 = new SimpleDateFormat("YYYYMMDDhhmm").parse(sDate1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date1;
	}

	
	/** 
	 * @param this.ShowTime.substring(0
	 * @param this.ShowTime.substring(4
	 * @param this.ShowTime.substring(6
	 * @param getDate2(
	 * @return String
	 * @throws ParseExceptionString Year = this.ShowTime.substring(0
	 * @throws 4);String Month = this.ShowTime.substring(4
	 * @throws 6);String Day = this.ShowTime.substring(6
	 * @throws 8);String Date =  Day + "/"+ Month + "/"+ Year;return Date;}public String getDate2()
	 */
	public String getDate() throws ParseException{ //YYYYMMDD
		String Year = this.ShowTime.substring(0, 4);
		String Month = this.ShowTime.substring(4, 6);
		String Day = this.ShowTime.substring(6, 8);
		String Date =  Day + "/"+ Month + "/"+ Year;
		return Date;
	}

	
	/** 
	 * @return String
	 */
	public String getDate2(){
		return this.ShowTime.substring(0, 8);
	}
	
	/** 
	 * @return String
	 */
	public String getTime(){
		return this.ShowTime.substring(8, 12);
	}

	
	/** 
	 * @param Movie
	 */
	//Setter
	public void setMovie(String Movie) {
		this.Movie = Movie;
	}

	
	/** 
	 * @param RoomID
	 */
	public void setRoom(int RoomID) {
		this.RoomID = RoomID;
	}

	
	/** 
	 * @param ShowTime
	 */
	public void setShowTime(String ShowTime) {
		this.ShowTime = ShowTime;
	}

	public void checkConflict(){
		// TODO - implement MovieSchedule.checkConflict

		throw new UnsupportedOperationException();
	}
}