//import Room;

package pack;
import java.util.ArrayList;
/*
 * @author SE1 Group 4
 * @version 13/11/2022
 * 
 */
public class Cinema {
	int CinemaID;
	String location;
	int NumOfRoom = 3;
	private ArrayList<Room> Room=new ArrayList<Room>();//Creating arraylist
	
	/** 
    * @param CinemaID
	*/

	Cinema(int CinemaID){
		this.CinemaID = CinemaID;
		for (int i=0; i<NumOfRoom; i++) {
			Room.add(new Room(i));	//Create Room with its ID
		}
	}
	
	
	/** 
	 * @return int
	 */
	int getCinemaID() {
		return this.CinemaID;
	}
	
	
	/** 
	 * @return int
	 */
	int getNumOfRoom() {
		return this.NumOfRoom;
	}
	
	
	/** 
	 * @param location
	 */
	void setLocation(String location) {
		this.location = location;
	}
	
	
	/** 
	 * @return String
	 */
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

	
	/** 
	 * @return ArrayList<Room>
	 */
	public ArrayList<Room> getRoom() {
		return Room;
	}

	
	/** 
	 * @param room
	 */
	public void setRoom(ArrayList<Room> room) {
		Room = room;
	}

	
	/** 
	 * @param cinemaID
	 */
	public void setCinemaID(int cinemaID) {
		CinemaID = cinemaID;
	}

	
	/** 
	 * @param numOfRoom
	 */
	public void setNumOfRoom(int numOfRoom) {
		NumOfRoom = numOfRoom;
	}

}