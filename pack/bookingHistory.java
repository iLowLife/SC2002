package pack;
import java.util.*;

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
    //getters
    public String getMovieTitle() {
        return MovieTitle;
    }
    public String getMovieSchedule() {
        return MovieSchedule;
    }
    public String getSeat() {
        return Seat;
    }
    public double getDate() {
        return Date;
    }
    public double getTime() {
        return Time;
    }
    public String getUserID() {
        return UserID;
    }
    public String getType() {
        return Type;
    }
    public double getPrice() {
        return Price;
    }
    public String getRoom() {
        return Room;
    }
    public String getMovieID() {
        return MovieID;
    }

}