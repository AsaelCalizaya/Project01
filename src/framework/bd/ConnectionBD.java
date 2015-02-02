package framework.bd;

import java.sql.*;
/**
 * 
 * @author Asael Calizaya
 *
 */
public class ConnectionBD {

      private static Connection con = null;
      private static Statement statement;
      private static String dirDB = "jdbc:mysql://localhost/jagdpanther";   
      private static String userDB = "panther";
      private static String passDB = "panther11";
      
      /**
       * This constructor initialize the connection with data base
       */
      public ConnectionBD(){
    	  try{
    		  String dbClass = "com.mysql.jdbc.Driver";
    		  Class.forName(dbClass).newInstance();
    		  Connection con = DriverManager.getConnection(dirDB, userDB, passDB);
    		  statement = con.createStatement();
    	  }
    	  catch(Exception e){
    		  e.printStackTrace();
    	  }
      }
      
      /**
       * This method is to delete all periods from data base
       * @throws SQLException
       */
      public void DeletePeriod() throws SQLException{
      	  try{
      		  String query = "DELETE FROM jp_period WHERE ID > 0";
      		  statement.execute(query);
      	  }
      	  catch(Exception e){
      		  e.printStackTrace();
      	  }
      	  finally{
    		  if (con != null){
    			  con.close();
    		  }
    	  }
      }
      /**
       * This method is to delete all applicants and users from data base 
       * except the admin user
       * @throws SQLException
       */
      public void DeletePerson() throws SQLException{
      	  try{
      		  String query0 = "DELETE FROM login_register WHERE ID > 0";
      		  statement.execute(query0);
      		  String query1 = "DELETE FROM user_period WHERE APPLICANT_ID > 0";
      		  statement.execute(query1);    
      		  String query2 = "DELETE FROM message WHERE ID > 0";
      		  statement.execute(query2); 
      		  String query3 = "DELETE FROM jp_user WHERE CI != 123";
      		  statement.execute(query3); 
      	  }
      	  catch(Exception e){
      		  e.printStackTrace();
      	  }
      	  finally{
    		  if (con!= null){
    			  con.close();
    		  }
    	  }
      }
      
      /**
       * This method is to delete all programs from data base 
       * @throws SQLException
       */
      public void DeleteProgram() throws SQLException{
      	  try{
      		  String query1 = "DELETE FROM jp_period WHERE PROGRAM_ID > 0";
      		  statement.execute(query1);    
      		  String query2 = "DELETE FROM program WHERE ID > 0";
      		  statement.execute(query2); 
      	  }
      	  catch(Exception e){
      		  e.printStackTrace();
      	  }
      	  finally{
    		  if (con != null){
    			  con.close();
    		  }
    	  }
      }
      
      /**
       * This method is to delete all Stages from data base 
       * @throws SQLException
       */
      public void DeleteStage() throws SQLException{
      	  try{
      		  String query1 = "DELETE FROM stage WHERE ID > 0";
      		  statement.execute(query1);    
      	  }
      	  catch(Exception e){
      		  e.printStackTrace();
      	  }
      	  finally{
      		  if (con != null){
      			  con.close();
      		  }
      	  }
      }
}


