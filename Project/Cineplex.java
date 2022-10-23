package MovieBooking;

public class Cineplex {
	String name;
	private int NumOfCinema;
	private Cinema[] Cinema = new Cinema[5];
	
	Cineplex(String name, int NumOfCinema){
		this.name = name;
		this.NumOfCinema = NumOfCinema;
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
