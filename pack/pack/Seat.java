package pack;
//package MovieBooking;
/*
 * @author SE1 Group 4
 * @version 13/11/2022
 * 
 */
public class Seat {
	private boolean assigned;
	private int SeatID;

	/** 
    * @param SeatID
	*/

	Seat(int SeatID){
		this.SeatID = SeatID;
		this.assigned = false;
	}

	
	/** 
	 * @return int
	 */
	int getSeatID() {
		return this.SeatID;
	}
	
	/** 
	 * @return boolean
	 */
	boolean getAssigned() {
		return this.assigned;
	}
	
	/** 
	 * @param assigned
	 */
	void setAssigned(boolean assigned) {
		this.assigned = assigned;
	}
	
}
