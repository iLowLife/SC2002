package pack;
import java.util.ArrayList;

//package MovieBooking;
/*
 * @author SE1 Group 4
 * @version 13/11/2022
 * 
 */
public class Cineplex {
	String name;
	String CineplexCode;
	private int NumOfCinema = 3;	//Each Cineplex will have 3 Cinema (Fix Number)
	private ArrayList<Cinema> Cinema=new ArrayList<Cinema>();//Creating arraylist

    /** 
    * @param name
    * @param CineplexCode
	*/

	Cineplex(String name, String CineplexCode){
		this.name = name;
		this.CineplexCode = CineplexCode;
		for (int i=0; i<NumOfCinema; i++) {
			Cinema.add(new Cinema(i));	//Create Cinema with its ID
		}
	}
	
	
	/** 
	 * @return int
	 */
	int getNumOfCinema() {
		return this.NumOfCinema;
	}
	
	/** 
	 * @return String
	 */
	String getName() {
		return this.name;
	}
	
	
	/** 
	 * @param name
	 */
	void setName(String name) {
		this.name = name;
	}

	
	/** 
	 * @param Cinema
	 */
	public void setCinema(Cinema[] Cinema) {
		Cinema = Cinema;
	}

	
	/** 
	 * @return ArrayList<Cinema>
	 */
	public ArrayList<Cinema> getCinema() {
		return Cinema;
	}

	
	/** 
	 * @param cineplexCode
	 */
	public void setCineplexCode(String cineplexCode) {
		CineplexCode = cineplexCode;
	}

	
	/** 
	 * @return String
	 */
	public String getCineplexCode() {
		return CineplexCode;
	}

	
	/** 
	 * @param numOfCinema
	 */
	public void setNumOfCinema(int numOfCinema) {
		NumOfCinema = numOfCinema;
	}

	
	/** 
	 * @param cinema
	 */
	public void setCinema(ArrayList<Cinema> cinema) {
		Cinema = cinema;
	}


}
