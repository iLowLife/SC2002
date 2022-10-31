//package MovieBooking;

public class Cinema {
	int CinemaID;
	String location;
	int NumOfRoom = 3;
	private Room[] Room = new Room[NumOfRoom];
	
	Cinema(int CinemaID){
		this.CinemaID = CinemaID;
		//this.NumOfRoom = NumOfRoom;
		/*for (int i=0; i<NumOfRoom; i++) {
			this.getRoom()[i] = new Room(i);
		}*/

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
	
	void setNumOfRoom(int NumOfRoom) {
		this.NumOfRoom = NumOfRoom;
		this.Room = new Room[NumOfRoom];
		for(int i=0;i<NumOfRoom;i++) {
			this.Room[i] = new Room(i);
		}
	}
	
	String getLocation() {
		return this.location;
	}

	public Room[] getRoom() {
		// TODO Auto-generated method stub
		return Room;
	}
}
