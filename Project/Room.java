//package MovieBooking;

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
	int getRoomNum() {
		return this.roomNum;
	}
	public Seat[] getSeat() {
		// TODO Auto-generated method stub
		return Seat;
	}
}
