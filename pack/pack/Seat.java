package pack;
//package MovieBooking;

public class Seat {
	private boolean assigned;
	private int SeatID;

	Seat(int SeatID){
		this.SeatID = SeatID;
		this.assigned = false;
	}

	int getSeatID() {
		return this.SeatID;
	}
	boolean getAssigned() {
		return this.assigned;
	}
	void setAssigned(boolean assigned) {
		this.assigned = assigned;
	}
	
}
