public class MovieSchedule {
		//XXXYYYYMMDDhhmm (Y : year, M : month, D : day, h : hour, m : minutes, XXX : cinema code in letters)
	private String Movie;
	private int RoomID;
	private String ShowTime;
	private String CinemaID;
	private Room Room; //1 movie schedule object will create 1 new room object

	public MovieSchedule(String Movie, int RoomID,String CinemaID, String ShowTime) {
		this.Movie = Movie;
		this.RoomID = RoomID;
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

	public Room getRoom() {
		return this.Room;
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
