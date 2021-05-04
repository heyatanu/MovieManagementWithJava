import java.sql.*;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
class movielist {
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
   static final String DB_URL = "jdbc:mysql://localhost/moviemanagementsystem";
   //  Database credentials
   static final String USER = "root";
   static final String PASS = "";

   Boolean CheckAvalability(int passid, int noOfTickets) {
      int seatavlable = 0;
      // JDBC driver name and database URL
      Connection conn = null;
      Statement stmt = null;
      try {

         Class.forName("com.mysql.jdbc.Driver");

         System.out.println("\n\tConnecting to database...");
         conn = DriverManager.getConnection(DB_URL, USER, PASS);
         //STEP 4: Execute a query
         System.out.println("\n\tChecking avalibility of the movie...");
         stmt = conn.createStatement();
         String sql;
         sql = "SELECT * FROM movielist WHERE movieid=" + passid;
         ResultSet rs = stmt.executeQuery(sql);
         int count = 0;

         while (rs.next()) {
            ++count;
            int moviehallcapacity = rs.getInt("moviehallcapacity");
            seatavlable = moviehallcapacity;
            // Get data from the current row and use it
         }
         if (count == 0 || seatavlable < noOfTickets) {
            return false;
         }

         System.out.println("\n\tChecking successfull");
         rs.close();
         stmt.close();
         conn.close();
      } catch (SQLException se) {

         System.out.println("\n\tSQL ERROR");
      } catch (Exception e) {
         //Handle errors for Class.forName
         System.out.println("\n\tERROR OCCERS");
      } finally {
         //finally block used to close resources
         try {
            if (stmt != null)
               stmt.close();
         } catch (SQLException se2) {} // nothing we can do
         try {
            if (conn != null)
               conn.close();
         } catch (SQLException se) {
            System.out.println("\n\tSQL ERROR");
         }
      }
      return true;
   }
   void CustomerDisplay() {
      // JDBC driver name and database URL
      Connection conn = null;
      Statement stmt = null;
      try {

         Class.forName("com.mysql.jdbc.Driver");

         System.out.println("\n\tConnecting to database...");
         conn = DriverManager.getConnection(DB_URL, USER, PASS);
         //STEP 4: Execute a query
         System.out.println("\n\tFetching data from database...");
         stmt = conn.createStatement();
         String sql;
         sql = "SELECT * FROM movielist";
         ResultSet rs = stmt.executeQuery(sql);

         //		      System.out.println("\n\tID\tNAME\tRATTING\tDISCRIPTION\tDURATION\tSTART TIME\tEND TIME\tDATE\tTICKET PRICE\tHALL NO\n");
         while (rs.next()) {
            //Retrieve by column name
            int movieid = rs.getInt("movieid");
            String moviename = rs.getString("moviename");
            int movieratting = rs.getInt("movieratting");
            String moviediscription = rs.getString("moviediscription");
            String movieduration = rs.getString("movieduration");
            String moviestarttime = rs.getString("moviestarttime");
            String movieendtime = rs.getString("movieendtime");
            String moviedate = rs.getString("moviedate");
            int movieprice = rs.getInt("movieprice");
            int moviehallno = rs.getInt("moviehallno");
            int moviehallcapacity = rs.getInt("moviehallcapacity");
            System.out.print("ID: " + movieid);
            System.out.print(", Name: " + moviename);
            System.out.print(", Ratting: " + movieratting);
            System.out.print(", Discription: " + moviediscription);
            System.out.print(", Duration: " + movieduration);
            System.out.print(", Stat Time: " + moviestarttime);
            System.out.print(", End Time: " + movieendtime);
            System.out.print(", Date: " + moviedate);
            System.out.print(", Ticket Price: " + movieprice);
            System.out.print(", Hall No: " + moviehallno);
            if (moviehallcapacity <= 0) {
               System.out.print(", HOUSE FULL TRY LATER \n");
            } else {
               System.out.print(", Seat Left: " + moviehallcapacity + "\n");
            }
         }
         rs.close();
         stmt.close();
         conn.close();
         System.out.println("\n\tData fetch successfull...");
      } catch (SQLException se) {

         System.out.println("\n\tSQL ERROR");
      } catch (Exception e) {
         //Handle errors for Class.forName
         System.out.println("\n\tERROR OCCERS");
      } finally {
         //finally block used to close resources
         try {
            if (stmt != null)
               stmt.close();
         } catch (SQLException se2) {} // nothing we can do
         try {
            if (conn != null)
               conn.close();
         } catch (SQLException se) {
            System.out.println("\n\tSQL ERROR");
         }
      }
   }

   void DisplayCustomerListDetails(Integer[] myMovieList, Integer[] myNoOfTickets) {
      //		System.out.println(Arrays.toString(myMovieList));
      for (int i = 0; i < myMovieList.length; i++) {
         if (myNoOfTickets[i] == -9999) {
            continue;
         }
         // JDBC driver name and database URL
         Connection conn = null;
         Statement stmt = null;
         try {

            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("\n\tConnecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            //STEP 4: Execute a query
            System.out.println("\n\tFetching data from database....");

            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM movielist WHERE movieid =" + myMovieList[i];
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
               //Retrieve by column name
               int movieid = rs.getInt("movieid");
               String moviename = rs.getString("moviename");
               int movieratting = rs.getInt("movieratting");
               String moviediscription = rs.getString("moviediscription");
               String movieduration = rs.getString("movieduration");
               String moviestarttime = rs.getString("moviestarttime");
               String movieendtime = rs.getString("movieendtime");
               String moviedate = rs.getString("moviedate");
               int movieprice = rs.getInt("movieprice");
               int moviehallno = rs.getInt("moviehallno");
               int moviehallcapacity = rs.getInt("moviehallcapacity");
               System.out.print("ID: " + movieid);
               System.out.print(", Name: " + moviename);
               System.out.print(", Ratting: " + movieratting);
               System.out.print(", Discription: " + moviediscription);
               System.out.print(", Duration: " + movieduration);
               System.out.print(", Stat Time: " + moviestarttime);
               System.out.print(", End Time: " + movieendtime);
               System.out.print(", Date: " + moviedate);
               System.out.print(", Ticket Price: " + movieprice);
               System.out.print(", Hall No: " + moviehallno);
               System.out.print(", No of Tickets: " + myNoOfTickets[i] + "\n");
               if (moviehallcapacity <= 0) {
                  System.out.print(", HOUSE FULL TRY LATER \n");
               } else {
                  System.out.print(", Seat Left: " + moviehallcapacity + "\n");
               }
            }

            rs.close();
            stmt.close();
            conn.close();
         } catch (SQLException se) {

            System.out.println("\n\tSQL ERROR");
         } catch (Exception e) {
            //Handle errors for Class.forName
            System.out.println("\n\tERROR OCCERS");
         } finally {
            //finally block used to close resources
            try {
               if (stmt != null)
                  stmt.close();
            } catch (SQLException se2) {} // nothing we can do
            try {
               if (conn != null)
                  conn.close();
            } catch (SQLException se) {
               System.out.println("\n\tSQL ERROR");
            }
         }
      }
      System.out.println("\n\tData fetch successfull...");
   }

   void CustomerCheckOut(Integer[] myMovieList, Integer[] myNoOfTickets) {
      int finalprice = 0;
      for (int i = 0; i < myMovieList.length; i++) {
         if (myNoOfTickets[i] == -9999) {
            continue;
         }
         // JDBC driver name and database URL
         Connection conn = null;
         Statement stmt = null;
         try {

            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("\n\tConnecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            //STEP 4: Execute a query
            System.out.println("\n\tFetching data from database....");

            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM movielist WHERE movieid =" + myMovieList[i];
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
               int movieprice = rs.getInt("movieprice");
               int moviecap = rs.getInt("moviehallcapacity");
               finalprice = finalprice + movieprice;
               finalprice = finalprice * myNoOfTickets[i];
               int moviehallcapacity = moviecap - myNoOfTickets[i];
               stmt = conn.createStatement();
               String updatesql = "UPDATE movielist SET moviehallcapacity=" + moviehallcapacity + " WHERE movieid=" + myMovieList[i];
               stmt.executeUpdate(updatesql);
            }
            rs.close();
            stmt.close();
            conn.close();
         } catch (SQLException se) {

            System.out.println("\n\tSQL ERROR");
         } catch (Exception e) {
            //Handle errors for Class.forName
            System.out.println("\n\tERROR OCCERS");
         } finally {
            //finally block used to close resources
            try {
               if (stmt != null)
                  stmt.close();
            } catch (SQLException se2) {} // nothing we can do
            try {
               if (conn != null)
                  conn.close();
            } catch (SQLException se) {
               System.out.println("\n\tSQL ERROR");
            }
         }
      }
      System.out.println("\n\tYour Final price is " + finalprice);
      System.out.println("\n\t THANK YOU ");
      System.out.println("\n\tData fetch successfull...");
   }

}

class Customer {
   Integer myMovieList[] = {}; //STORE THE CUSTOMER MOVIE IDS
   Integer myNoOfTickets[] = {}; //STORE THE CUSTOMER MOVIE IDS

   void AddToMyList(int myMovieId, int noOfTickets, movielist movies) {
      if (movies.CheckAvalability(myMovieId, noOfTickets)) {
         System.out.println("\n\tMovie Id " + myMovieId + " added to your list. With " + noOfTickets + " tickets.");
         ArrayList < Integer > myList = new ArrayList < Integer > (Arrays.asList(myMovieList));
         myList.add(myMovieId);
         myMovieList = myList.toArray(myMovieList);

         ArrayList < Integer > myList1 = new ArrayList < Integer > (Arrays.asList(myNoOfTickets));
         myList1.add(noOfTickets);
         myNoOfTickets = myList1.toArray(myNoOfTickets);
      } else {
         System.out.println("\n\tNot Avalable Or Movie Is Houefull");
      }
   }

   void RemoveFromList(int myMovieid, int noOfTickets) { // REMOVE PRODUCT FROM THE CART
      int b = 0;
      if (myMovieList.length == 0) {
         System.out.println("\n\tAdd some movies in your list first");
      } else {

         for (int i = 0; i < myMovieList.length; i++) {
            if (myMovieList[i] == myMovieid) {
               b = 1;
               if (myNoOfTickets[i] < noOfTickets) {
                  b = 2;
                  myMovieList[i] = -9999;
                  myNoOfTickets[i] = -9999;
                  break;
               }
               myNoOfTickets[i] = myNoOfTickets[i] - noOfTickets;
               if (myNoOfTickets[i] <= 0) {
                  myMovieList[i] = -9999;
                  myNoOfTickets[i] = -9999;
               }
               break;
            }
         }
         if (b == 1) {
            System.out.println("\n\t" + noOfTickets + " tickets of movie id " + myMovieid + " remove from list");
         } else if (b == 2) {
            System.out.println("\n\tAll tickets of movie id " + myMovieid + " remove from list");
         } else {
            System.out.println("\n\tMovie id " + myMovieid + " No found in list");
         }
      }
   }

   boolean DisplayFinalList(movielist movies) {
      if (myMovieList.length == 0) {
         System.out.println("\n\tYou have nothing in the list!");
         return false;
      }
      movies.DisplayCustomerListDetails(myMovieList, myNoOfTickets);
      return true;
   }

   void CheckOut(movielist movies) {
      movies.CustomerCheckOut(myMovieList, myNoOfTickets);
   }
}

class Admin {
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
   static final String DB_URL = "jdbc:mysql://localhost/moviemanagementsystem";
   //  Database credentials
   static final String USER = "root";
   static final String PASS = "";

   void AddMovie(int movieid, String moviename, int movieratting, String moviediscription, String movieduration, String moviestarttime, String movieendtime, String moviedate, int movieprice, int moviehallno, int moviehallcapacity) {
      Connection conn = null;
      Statement stmt = null;
      try {

         Class.forName("com.mysql.jdbc.Driver");

         System.out.println("\n\tConnecting to database...");
         conn = DriverManager.getConnection(DB_URL, USER, PASS);
         System.out.println("\n\tTry to add this to database...");

         //STEP 4: Execute a query
         stmt = conn.createStatement();

         String sql = "INSERT INTO movielist " +
            "VALUES (" + movieid + ",'" + moviename + "'," + movieratting + ",'" + moviediscription + "','" + movieduration + "','" + moviestarttime + "','" + movieendtime + "','" + moviedate + "'," + movieprice + "," + moviehallno + "," + moviehallcapacity + ")";

         stmt.executeUpdate(sql);
         System.out.println("\n\tInserted records into the table successfull..");

      } catch (SQLException se) {

         //		      System.out.println("\n\tSQL ERROR");
         System.out.println("\n\tMovie Id is already present or you pass wrong input please check------Insert Failed");
      } catch (Exception e) {
         //Handle errors for Class.forName
         System.out.println("\n\tERROR OCCERS");
         //		      System.out.println("2");
      } finally {
         //finally block used to close resources
         try {
            if (stmt != null)
               conn.close();
         } catch (SQLException se) {} // do nothing
         try {
            if (conn != null)
               conn.close();
         } catch (SQLException se) {
            System.out.println("\n\tSQL ERROR");
         }
      }
   }

   void DeleteMovie(int passid) {
      Connection conn = null;
      Statement stmt = null;
      try {

         Class.forName("com.mysql.jdbc.Driver");

         System.out.println("\n\tConnecting to database...");
         conn = DriverManager.getConnection(DB_URL, USER, PASS);
         System.out.println("\n\tTry to delete this from database.....");

         //STEP 4: Execute a query
         System.out.println("Creating statement...");
         stmt = conn.createStatement();
         String sql = "DELETE FROM movielist " +
            "WHERE movieid = " + passid;
         stmt.executeUpdate(sql);
         System.out.println("\n\tDelete from database successfull.....");
         // Now you can extract all the records
         // to see the remaining records
      } catch (SQLException se) {

         System.out.println("\n\tSQL ERROR");
      } catch (Exception e) {
         //Handle errors for Class.forName
         System.out.println("\n\tERROR OCCERS");
      } finally {
         //finally block used to close resources
         try {
            if (stmt != null)
               conn.close();
         } catch (SQLException se) {} // do nothing
         try {
            if (conn != null)
               conn.close();
         } catch (SQLException se) {
            System.out.println("\n\tSQL ERROR");
         }
      }
   }

   void UpdateMovieDetails(int passid) {
      @SuppressWarnings("resource")
      Scanner in = new Scanner(System.in);
      Connection conn = null;
      Statement stmt = null;
      try {

         Class.forName("com.mysql.jdbc.Driver");

         System.out.println("\n\tConnecting to database...");
         conn = DriverManager.getConnection(DB_URL, USER, PASS);
         System.out.println("\n\tTry to update this from database.....");
         try {
            //STEP 4: Execute a query
        	 System.out.print("\n\t1.Update the movie name\n\t2.Update the movie ratting\n\t3.Update the movie discription"
        	 		+ "\n\t4.Update the movie duration\n\t5.Update the movie start time\n\t6.Update the movie end time"
        	 		+ "\n\t7.Update the movie date\n\t8.Update the movie ticket price"
        	 		+ "\n\t9.Update the movie hall no\n\t10.Update the movie hall capacity\n\t0.Exit");
            System.out.print("\nUpdate records into the table...\nEnter the upate value no-");
            int ch = in .nextInt();
            if (ch == 1) {
               System.out.print("Enter the new movie name-");
               String moviename = in .next();
               stmt = conn.createStatement();
               String sql = "UPDATE movielist SET moviename = '" + moviename + "' WHERE movieid=" + passid;
               stmt.executeUpdate(sql);
               System.out.println("\n\tMovie name for movie id " + passid + " updated to " + moviename + "   Successfull...");
            } else if (ch == 2) {
               System.out.print("Enter the movie new ratting -");
               int movieratting = in .nextInt();
               stmt = conn.createStatement();
               String sql = "UPDATE movielist SET movieratting=" + movieratting + " WHERE movieid=" + passid;
               stmt.executeUpdate(sql);
               System.out.println("\n\tMovie ratting for movie id " + passid + " updated to " + movieratting + "   Successfull...");
            } else if (ch == 3) {
               System.out.print("Enter the movie new discription-");
               String moviediscription = in .next();
               stmt = conn.createStatement();
               String sql = "UPDATE movielist SET moviediscription = '" + moviediscription + "' WHERE movieid=" + passid;
               stmt.executeUpdate(sql);
               System.out.println("\n\tMovie moviediscription for movie id " + passid + " updated to " + moviediscription + "   Successfull...");
            } else if (ch == 4) {
               System.out.print("Enter the movie new duration-");
               String movieduration = in .next();
               stmt = conn.createStatement();
               String sql = "UPDATE movielist SET movieduration = '" + movieduration + "' WHERE movieid=" + passid;
               stmt.executeUpdate(sql);
               System.out.println("\n\tMovie duration for movie id " + passid + " updated to " + movieduration + "   Successfull...");
            } else if (ch == 5) {
               System.out.print("Enter the movie new start time-");
               String moviestarttime = in .next();
               stmt = conn.createStatement();
               String sql = "UPDATE movielist SET moviestarttime = '" + moviestarttime + "' WHERE movieid=" + passid;
               stmt.executeUpdate(sql);
               System.out.println("\n\tMovie start time for movie id " + passid + " updated to " + moviestarttime + "   Successfull...");
            } else if (ch == 6) {
               System.out.print("Enter the movie new end time-");
               String movieendtime = in .next();
               stmt = conn.createStatement();
               String sql = "UPDATE movielist SET movieendtime = '" + movieendtime + "' WHERE movieid=" + passid;
               stmt.executeUpdate(sql);
               System.out.println("\n\tMovie end time for movie id " + passid + " updated to " + movieendtime + "   Successfull...");
            } else if (ch == 7) {
               System.out.print("Enter the movie new date-");
               String moviedate = in .next();
               stmt = conn.createStatement();
               String sql = "UPDATE movielist SET moviedate = '" + moviedate + "' WHERE movieid=" + passid;
               stmt.executeUpdate(sql);
               System.out.println("\n\tMovie date for movie id " + passid + " updated to " + moviedate + "   Successfull...");
            } else if (ch == 8) {
               System.out.print("Enter the movie new ticket price -");
               int movieprice = in .nextInt();
               stmt = conn.createStatement();
               String sql = "UPDATE movielist SET movieprice=" + movieprice + " WHERE movieid=" + passid;
               stmt.executeUpdate(sql);
               System.out.println("\n\tMovie ticket price for movie id " + passid + " updated to " + movieprice + "   Successfull...");
            } else if (ch == 9) {
               System.out.print("Enter the movie new hall no - ");
               int moviehallno = in .nextInt();
               stmt = conn.createStatement();
               String sql = "UPDATE movielist SET moviehallno=" + moviehallno + " WHERE movieid=" + passid;
               stmt.executeUpdate(sql);
               System.out.println("\n\tMovie Hall no for movie id " + passid + " updated to " + moviehallno + "   Successfull...");
            } else if (ch == 10) {
               System.out.print("Enter the movie new hall capacity -");
               int moviehallcapacity = in .nextInt();
               stmt = conn.createStatement();
               String sql = "UPDATE movielist SET moviehallcapacity=" + moviehallcapacity + " WHERE movieid=" + passid;
               stmt.executeUpdate(sql);
               System.out.println("\n\tMovie Hall Capacity for movie id " + passid + " updated to " + moviehallcapacity + "   Successfull...");
            } else {
               System.out.println("\n\tWrong Input Cheak Menu Once");
            }
         } catch (Exception e) {
            System.out.println("\n\tINVALID...");
         }
      } catch (SQLException se) {

         System.out.println("\n\tSQL ERROR");
      } catch (Exception e) {
         //Handle errors for Class.forName
         System.out.println("\n\tERROR OCCERS");
      } finally {
         //finally block used to close resources
         try {
            if (stmt != null)
               conn.close();
         } catch (SQLException se) {} // do nothing
         try {
            if (conn != null)
               conn.close();
         } catch (SQLException se) {
            System.out.println("\n\tSQL ERROR");
         }
      }
   }

   boolean AdminCheck(String username, String UPassword) {
      Connection conn = null;
      Statement stmt = null;
      try {

         Class.forName("com.mysql.jdbc.Driver");

         System.out.println("\n\tConnecting to database...");
         conn = DriverManager.getConnection(DB_URL, USER, PASS);
         System.out.println("\n\tCheck the admin status ...");
         //STEP 4: Execute a query
         stmt = conn.createStatement();
         String sql = "select * from movieadmin where adminname='" + username + "'";
         ResultSet rs = stmt.executeQuery(sql);
         int c = 0;
         while (rs.next()) {
            c = c + 1;
         }
         if (c == 0) {
            System.out.println("\n\t ADMIN NOT FOUND");
            return false;
         } else {
            sql = "select * from movieadmin where adminname='" + username + "'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {

               String adminname = rs.getString("adminname");
               String password = rs.getString("password");
               if (username.equals(adminname)) {
                  if (UPassword.equals(password)) {
                     System.out.println("\nSUCCESSFULL LOGIN");
                     return true;
                  } else {
                     System.out.println("\n\t WRONG PASSWORD");
                     return false;
                  }
               }

            }
         }

      } catch (SQLException se) {

         System.out.println("\n\tSQL ERROR");
      } catch (Exception e) {
         //Handle errors for Class.forName
         System.out.println("\n\tERROR OCCERS");
      } finally {
         //finally block used to close resources
         try {
            if (stmt != null)
               conn.close();
         } catch (SQLException se) {} // do nothing
         try {
            if (conn != null)
               conn.close();
         } catch (SQLException se) {
            System.out.println("\n\tSQL ERROR");
         }
      }
      return false;
   }

}
class Theater {
   void Get() {
      @SuppressWarnings("resource")
      Scanner in = new Scanner(System.in);
      movielist movies = new movielist();
      Customer Customer1 = new Customer();
      Admin Admin1 = new Admin();
      int iniciateadmin = 5656;
      System.out.println("\n\tWELCOME TO ABC MOVIE THEATER");
      //DISPLAY MOVIE LIST
      while (true) {
         movies.CustomerDisplay();
         System.out.print("\n\t1.Add movie in list\n\t2.Remove movie from list\n\t3.Display your list\n\t0.Exit");
         try {
            System.out.print("\n\nEnter your interest -");
            int optionCh = in .nextInt();
            if (optionCh == 1) {
               try {
                  System.out.print("\n Enter movie ID  - ");
                  int movieid = in .nextInt();
                  System.out.print("\n Enter the no of tickets - ");
                  int movieticketq = in .nextInt();
                  Customer1.AddToMyList(movieid, movieticketq, movies);
               } catch (Exception e) {
                  System.out.println("\n\tINVALID...");
                  break;
               }
            } else if (optionCh == 2) {
               try {
                  System.out.print("\n Enter movie ID you want to remove  - ");
                  int movieid = in .nextInt();
                  System.out.print("\n Enter the no of tickets you want to remove - ");
                  int movieticketq = in .nextInt();
                  Customer1.RemoveFromList(movieid, movieticketq);
               } catch (Exception e) {
                  System.out.println("\n\tINVALID...");
                  break;
               }
            } else if (optionCh == 3) {
               try {
                  if (Customer1.DisplayFinalList(movies)) {
                     System.out.print("\nDo you want to check out(1/0) - ");
                     int checksts = in .nextInt();
                     if (checksts == 1) {
                        Customer1.CheckOut(movies);
                        break;
                     } else {
                        System.out.print("\nPlease continue...");
                     }
                  }
               } catch (Exception e) {
                  System.out.println("\n\tINVALID...");
                  break;
               }

            } else if (optionCh == 0) {
               System.out.print("\n \t Thank You for visiting. ");
               break;
            } else if (optionCh == iniciateadmin) {
               try {
                  @SuppressWarnings("resource")
                  Scanner sc = new Scanner(System.in);
                  System.out.print("\nEnter your username - ");
                  String adminusername = sc.nextLine();
                  System.out.print("\n Enter the password- ");
                  String adminpassword = sc.nextLine();
                  if (Admin1.AdminCheck(adminusername, adminpassword)) {
                     System.out.println("\n\t WELCOME TO ADMIN PANAL (Double check before do anything this panal is sensitive)");
                     while (true) {
                        System.out.print("\n\tADMIN\n\t1.Add a new movie \n\t2.Remove movies\n\t3.Display movie list\n\t4.Update movie items\n\t0.Exit");
                        try {
                           System.out.print("\n Enter your interest -");
                           int AoptionCh = in .nextInt();
                           if (AoptionCh == 1) {
                              int randid = (int)(1000 * Math.random());
                              Admin1.AddMovie(randid, "Ali", 8, "Spor", "02.30.00", "02.45PM", "4.44PM", "12-7-12", 55550, 2, 5);
                           } else if (AoptionCh == 2) {
                              try {
                                 System.out.print("\nEnter the id of movie you want to delete - ");
                                 int checksts = in .nextInt();
                                 Admin1.DeleteMovie(checksts);
                              } catch (Exception e) {
                                 System.out.println("\n\tINVALID...");
                                 break;
                              }
                           } else if (AoptionCh == 3) {
                              movies.CustomerDisplay();
                           } else if (AoptionCh == 4) {
                              try {
                                 System.out.print("\nEnter the id of movie you want to update - ");
                                 int checksts = in .nextInt();
                                 Admin1.UpdateMovieDetails(checksts);
                              } catch (Exception e) {
                                 System.out.println("\n\tINVALID...");
                                 break;
                              }
                           } else if (AoptionCh == 0) {
                              System.out.print("\n \tExiting from admin panel. ");
                              break;
                           } else {
                              System.out.print("\nMaybe you enter wrong choice.");
                           }
                        } catch (Exception e) {
                           System.out.println("\n\tINVALID...");
                           break;
                        }

                     }

                  }
               } catch (Exception e) {
                  System.out.println("\n\tINVALID...");
                  break;
               }
            } else {
               System.out.print("\nMaybe you enter wrong choice.");
            }
         } catch (Exception e) {
            System.out.println("\n\tINVALID...");
            break;
         }
      }
   }
}
public class Movie {

   public static void main(String[] args) {

      Theater Theater1 = new Theater();
      Theater1.Get();
   } //end main

}