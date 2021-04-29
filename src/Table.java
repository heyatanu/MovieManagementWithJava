
import java.sql.*;

public class Table {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/moviemanagementsystem";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "";
   
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Creating table in given database...");
      stmt = conn.createStatement();
      
      String sql = "CREATE TABLE  movielist" +
                   "(movieid  INTEGER(100) not NULL, " +
                   " moviename VARCHAR(100), " + 
                   " movieratting INTEGER(2), " + 
                   " moviediscription VARCHAR(2000), " + 
                   " movieduration VARCHAR(10), " + 
                   " moviestarttime VARCHAR(7), " + 
                   " movieendtime VARCHAR(7), " + 
                   " moviedate VARCHAR(8), " + 
                   " movieprice INTEGER(200), " +
                   " moviehallno INTEGER(10), " +
                   " moviehallcapacity INTEGER(100), " +
                   " PRIMARY KEY ( movieid ))"; 

      stmt.executeUpdate(sql);
      System.out.println("Created table in given database...");
      
      
      
      stmt = conn.createStatement();
      
      String adminsql = "CREATE TABLE  movieadmin " +
                   "(adminname  VARCHAR(20) , " +
                   " password VARCHAR(20))"; 

      stmt.executeUpdate(adminsql);
      System.out.println("Movie table creation successfull...");
   }catch(SQLException se){
      //Handle errors for JDBC
	   System.out.println("Movie table already have in database... OR SOMETHING WRONG");
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   
   try{
	      //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");

	      //STEP 3: Open a connection
	      System.out.println("Connecting to a selected database...");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);
	      
	      stmt = conn.createStatement();
	      
	      String adminsql = "CREATE TABLE  movieadmin " +
	                   "(adminname  VARCHAR(20) , " +
	                   " password VARCHAR(20))"; 

	      stmt.executeUpdate(adminsql);
	      System.out.println("Admin table creation successfull...");
	   }catch(SQLException se){
	      //Handle errors for JDBC
		   System.out.println("Admin table already have in database... OR SOMETHING WRONG");
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }finally{
	      //finally block used to close resources
	      try{
	         if(stmt!=null)
	            conn.close();
	      }catch(SQLException se){
	      }// do nothing
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	   }//end try
   
   
   try{
	      //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");

	      //STEP 3: Open a connection
	      System.out.println("Connecting to a selected database...");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);
	      System.out.println("Connected database successfully...");
	      
	      //STEP 4: Execute a query
	      System.out.println("Inserting records into the table...");
	      stmt = conn.createStatement();
	      
	      String sql = "INSERT INTO movieadmin VALUES ('root', 'admin')";
	      stmt.executeUpdate(sql);
	      System.out.println("Inserted records into the table... Successfull");

	   }catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }finally{
	      //finally block used to close resources
	      try{
	         if(stmt!=null)
	            conn.close();
	      }catch(SQLException se){
	      }// do nothing
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	   }//end try
	   System.out.println("Goodbye!");
}//end main
}//end JDBCExample