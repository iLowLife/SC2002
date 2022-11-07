package pack;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MovieSchedule {
		//XXXYYYYMMDDhhmm (Y : year, M : month, D : day, h : hour, m : minutes, XXX : cinema code in letters)
	private String Movie;
	private int RoomID;
	private String ShowTime; //YYYYMMDDhhmm
	private String CinemaID;
	private Room Room; //1 movie schedule object will creates 1 new room object

	public MovieSchedule(String Movie, int RoomID,String CinemaID, String ShowTime) {
		this.Movie = Movie;		  // CineplexID + CinemaID + ShowTime
		this.RoomID = RoomID;	  // " 
		this.ShowTime = ShowTime; //"YYYYMMDDhhmm"
		this.CinemaID = CinemaID; //"XXX"
		this.Room = new Room(RoomID);	//create a new room object
	}

	//Getter
	public String getMovie() {
		return this.Movie;
	}

	public int getRoomID() {
		return this.RoomID;
	}

	public String getShowTime() {
		return this.ShowTime;
	}

	public String getCinemaID() {
		return this.CinemaID;
	}

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

	public int getLocation(){
		return Integer.valueOf(this.CinemaID.substring(2, 3));
	}

	public Room getRoom() {
		return this.Room;
	}

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

	public String getDate() throws ParseException{ //YYYYMMDD
		String Year = this.ShowTime.substring(0, 4);
		String Month = this.ShowTime.substring(4, 6);
		String Day = this.ShowTime.substring(6, 8);
		String Date =  Day + "/"+ Month + "/"+ Year;
		return Date;
	}

	public String getDate2(){
		return this.ShowTime.substring(0, 8);
	}
	public String getTime(){
		return this.ShowTime.substring(8, 12);
	}

	//Setter
	public void setMovie(String Movie) {
		this.Movie = Movie;
	}

	public void setRoom(int RoomID) {
		this.RoomID = RoomID;
	}

	public void setShowTime(String ShowTime) {
		this.ShowTime = ShowTime;
	}

	public void checkConflict(){
		// TODO - implement MovieSchedule.checkConflict

		throw new UnsupportedOperationException();
	}
}