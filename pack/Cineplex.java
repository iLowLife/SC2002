package pack;
import java.util.ArrayList;

//package MovieBooking;

public class Cineplex {
	String name;
	String CineplexCode;
	private int NumOfCinema = 3;	//Each Cineplex will have 3 Cinema (Fix Number)
	private ArrayList<Cinema> Cinema=new ArrayList<Cinema>();//Creating arraylist

	Cineplex(String name, String CineplexCode){
		this.name = name;
		this.CineplexCode = CineplexCode;
		for (int i=0; i<NumOfCinema; i++) {
			Cinema.add(new Cinema(i));	//Create Cinema with its ID
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

	public void setCinema(Cinema[] Cinema) {
		Cinema = Cinema;
	}

	public ArrayList<Cinema> getCinema() {
		return Cinema;
	}

	public void setCineplexCode(String cineplexCode) {
		CineplexCode = cineplexCode;
	}

	public String getCineplexCode() {
		return CineplexCode;
	}

	public void setNumOfCinema(int numOfCinema) {
		NumOfCinema = numOfCinema;
	}

	public void setCinema(ArrayList<Cinema> cinema) {
		Cinema = cinema;
	}


}
