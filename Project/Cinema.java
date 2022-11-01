import java.util.ArrayList;

public class Cinema {
	int CinemaID;
	String location;
	int NumOfRoom = 3;
	private ArrayList<Room> Room=new ArrayList<Room>();//Creating arraylist
	
	Cinema(int CinemaID){
		this.CinemaID = CinemaID;
		for (int i=0; i<NumOfRoom; i++) {
			Room.add(new Room(i));	//Create Room with its ID
		}
	}
	
	int getCinemaID() {
		return this.CinemaID;
	}
	
	int getNumOfRoom() {
		return this.NumOfRoom;
	}
	
	void setLocation(String location) {
		this.location = location;
	}
	
	/*void setNumOfRoom(int NumOfRoom) {
		this.NumOfRoom = NumOfRoom;
		this.Room = new Room[NumOfRoom];
		for(int i=0;i<NumOfRoom;i++) {
			this.Room[i] = new Room(i);
		}
	}*/
	
	String getLocation() {
		return this.location;
	}

	public ArrayList<Room> getRoom() {
		return Room;
	}

	public void setRoom(ArrayList<Room> room) {
		Room = room;
	}

	public void setCinemaID(int cinemaID) {
		CinemaID = cinemaID;
	}

	public void setNumOfRoom(int numOfRoom) {
		NumOfRoom = numOfRoom;
	}

}
