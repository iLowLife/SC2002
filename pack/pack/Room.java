package pack;

//package MovieBooking;
/*
 * @author SE1 Group 4
 * @version 13/11/2022
 * 
 */
public class Room {
	private int roomNum;
	int NumOfSeat = 25;
	private Seat[] Seat = new Seat[NumOfSeat];

	Room(int roomNum){
		this.roomNum = roomNum;
		for (int i=0; i<NumOfSeat; i++) {
			this.getSeat()[i] = new Seat(i);
		}
	}
	
	/** 
	 * @return int
	 */
	int getRoomNum() {
		return this.roomNum;
	}
	
	/** 
	 * @return Seat[]
	 */
	public Seat[] getSeat() {
		// TODO Auto-generated method stub
		return Seat;
	}
}
