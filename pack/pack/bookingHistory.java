package pack;
import java.util.*;
/*
 * @author SE1 Group 4
 * @version 13/11/2022
 * 
 */
public class bookingHistory {
    //bookingHistory
    private String MovieTitle;
    private String MovieSchedule;
    private String Seat;
    private double Date;
    private double Time;
    private String UserID;
    private String Type;
    private Double Price;
    private String Room;
    private String MovieID;
    
    /** 
	* @param MovieTitle 
    * @param MovieSchedule 
    * @param Seat 
    * @param Date 
    * @param Time 
    * @param UserID 
    * @param Type 
    * @param Price 
    * @param Room 
    * @param MovieID
	*/

    public bookingHistory(String MovieTitle, String MovieSchedule, String Seat, Double Date, Double Time, String UserID, String Type, Double Price, String Room, String MovieID) {
        this.MovieTitle = MovieTitle;
        this.MovieSchedule = MovieSchedule;
        this.Seat = Seat;
        this.Date = Date;
        this.Time = Time;
        this.UserID = UserID;
        this.Type = Type;
        this.Price = Price;
        this.Room = Room;
        this.MovieID = MovieID;
    }
    
    /** 
     * @return String
     */
    //getters
    public String getMovieTitle() {
        return MovieTitle;
    }
    
    /** 
     * @return String
     */
    public String getMovieSchedule() {
        return MovieSchedule;
    }
    
    /** 
     * @return String
     */
    public String getSeat() {
        return Seat;
    }
    
    /** 
     * @return double
     */
    public double getDate() {
        return Date;
    }
    
    /** 
     * @return double
     */
    public double getTime() {
        return Time;
    }
    
    /** 
     * @return String
     */
    public String getUserID() {
        return UserID;
    }
    
    /** 
     * @return String
     */
    public String getType() {
        return Type;
    }
    
    /** 
     * @return double
     */
    public double getPrice() {
        return Price;
    }
    
    /** 
     * @return String
     */
    public String getRoom() {
        return Room;
    }
    
    /** 
     * @return String
     */
    public String getMovieID() {
        return MovieID;
    }

}