package pack;
import java.io.* ;
import java.util.ArrayList;
import pack.User;
import pack.Movie;

public class FileIO {
    public static void main(String[] args) {

      //read Movie.txt
      ArrayList<Movie> movieList = new ArrayList<Movie>();


      /*
       *  try {
          FileReader     frStream = new FileReader(    "NameList.txt" );
          BufferedReader brStream = new BufferedReader( frStream  );
          String         line     = null;
          //loop each line in file
          while ( ( line = brStream.readLine() ) != null ) {
            //split line into array of String
            String[] tokens = line.split(",");
            //create new User object
            User user = new User(tokens[0], tokens[1], tokens[2]);
            //add User object to UserList
            UserList.add(user);
          }
          brStream.close();
        }
       */


      try {
        FileReader     frStream = new FileReader(    "Movie.txt" );
        BufferedReader brStream = new BufferedReader( frStream  );
        String line = null;
        while ( ( line = brStream.readLine() ) != null ) {
          String[] tokens = line.split("\\|");
          System.out.println(tokens[0] + " " + tokens[1] + " " + tokens[2] + " " + tokens[3] + " ");
          String[] cast = tokens[4].split(",");
          for (int i = 0; i < cast.length; i++) {
            System.out.println(cast[i]);
          }
          //movieList.add(tokens[0], tokens[1], tokens[2], tokens[3], cast);
        }
        brStream.close();
      } catch (IOException e) {
        e.printStackTrace();
      }

      //print movie
      /*for (Movie movie : movieList) {
        System.out.println(movie.getMovieTitle());
        System.out.println(movie.getShowingStatus());
        System.out.println(movie.getSynopsis());
        System.out.println(movie.getDirector());
        for (String cast : movie.getCast()) {
          System.out.println(cast);
        }
      }*/

    }
}



/*
 //create ArrayList of User
        ArrayList<User> UserList = new ArrayList<User>();
        UserList.add(new User("John", "email", "password"));
        UserList.add(new User("Cena", "email", "password"));

        //Export out UserList to text file in  flatfile format
        try {
          FileWriter     fwStream = new FileWriter(    "NameList.txt" );
          BufferedWriter bwStream = new BufferedWriter( fwStream  );
          PrintWriter    pwStream = new PrintWriter(    bwStream  );
          //loop UserList
          for (int i = 0; i < UserList.size(); i++) {
            //write each User object to file
            pwStream.println(UserList.get(i).getName()+"," + UserList.get(i).getEmail()+"," + UserList.get(i).getPassword());
          }
          pwStream.close();
        }
        catch ( IOException e ) {
           System.out.println( "IO Error!" + e.getMessage() );
           e.printStackTrace();
           System.exit( 0 );
        }

        //import NameList.txt
        try {
          FileReader     frStream = new FileReader(    "NameList.txt" );
          BufferedReader brStream = new BufferedReader( frStream  );
          String         line     = null;
          //loop each line in file
          while ( ( line = brStream.readLine() ) != null ) {
            //split line into array of String
            String[] tokens = line.split(",");
            //create new User object
            User user = new User(tokens[0], tokens[1], tokens[2]);
            //add User object to UserList
            UserList.add(user);
          }
          brStream.close();
        }
        catch ( IOException e ) {
           System.out.println( "IO Error!" + e.getMessage() );
           e.printStackTrace();
           System.exit( 0 );
        }

        //print out UserList
        for (int i = 0; i < UserList.size(); i++) {
          System.out.println(UserList.get(i).getName()+"," + UserList.get(i).getEmail()+"," + UserList.get(i).getPassword());
        }

 */

/*    public static void main( String[] args ) {
    try {
      FileReader     frStream = new FileReader(    "name.txt" );
      BufferedReader brStream = new BufferedReader( frStream  );
      int    i         ;
      String str       ;

      //create a dynamic array
      String[] nameBig = new String[100] ;
      String[] nameSmall = new String[100] ;
      int count1 = 0 ;
      int count2 = 0 ;

      System.out.println( "The file contains:" );
      while ((str = brStream.readLine()) != null) {
        System.out.println( str );
        //if name length more than 5, spilt to different array
        if(str.length() > 5){
            nameBig[count1] = str ;
            count1++;
        }
        else{
            nameSmall[count2++] = str ;
        }
      }
      exportFile(nameBig, nameSmall, count1, count2);
      brStream.close();
    }
    catch ( FileNotFoundException e ) {
      System.out.println( "Error opening the input file!"
                          + e.getMessage() );
      System.exit( 0 );
    }

    catch ( IOException e ) {
        System.out.println( "IO Error!" + e.getMessage() );
        e.printStackTrace();
        System.exit( 0 );
      }

      
    }

    //export file to nameBig.txt and nameSmall.txt
    public static void exportFile(String[] nameBig, String[] nameSmall,int c1, int c2){
        try{
            FileWriter fwBig = new FileWriter("nameBig.txt");
            FileWriter fwSmall = new FileWriter("nameSmall.txt");
            BufferedWriter bwBig = new BufferedWriter(fwBig);
            BufferedWriter bwSmall = new BufferedWriter(fwSmall);

            for(int i = 0; i < c1; i++){
                bwBig.write(nameBig[i]);
                bwBig.newLine();
            }
            for(int i = 0; i < c2; i++){
                bwSmall.write(nameSmall[i]);
                bwSmall.newLine();
            }
            bwBig.close();
            bwSmall.close();
        }
        catch ( FileNotFoundException e ) {
            System.out.println( "Error opening the input file!"
                                + e.getMessage() );
            System.exit( 0 );
          }
      
          catch ( IOException e ) {
              System.out.println( "IO Error!" + e.getMessage() );
              e.printStackTrace();
              System.exit( 0 );
            }
    }*/




  

 //while ((str = in.readLine()) != null) {
/*    try {
      FileWriter     fwStream = new FileWriter(    "data.txt" );
      BufferedWriter bwStream = new BufferedWriter( fwStream  );
      PrintWriter    pwStream = new PrintWriter(    bwStream  );
      int num ;
      for ( num = 0 ; num < 5 ; num++ )
        pwStream.println( "Number = " + num * 5 );
      pwStream.close();
    }
    catch ( IOException e ) {
       System.out.println( "IO Error!" + e.getMessage() );
       e.printStackTrace();
       System.exit( 0 );
    } */