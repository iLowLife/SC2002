//package MovieBooking;

public class Cineplex {
	String name;
	private int NumOfCinema = 3;
	private Cinema[] Cinema = new Cinema[NumOfCinema];
	
	Cineplex(String name){
		this.name = name;
		for (int i=0; i<NumOfCinema; i++) {
			this.getCinema()[i] = new Cinema(i);
		}
	}
	
	int getNumOfCinema() {
		return this.NumOfCinema;
	}
	String getName() {
		return this.name;
	}
	
	void setName(String name) {
		this.name = name;
	}

	public Cinema[] getCinema() {
		return Cinema;
	}

	public void setCinema(Cinema[] cinema) {
		Cinema = cinema;
	}
}
