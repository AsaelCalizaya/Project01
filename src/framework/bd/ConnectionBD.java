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
      private static String DIR_DB = "jdbc:mysql://localhost/jagdpanther";   
      private static String USER_DB = "panther";
      private static String PASS_DB = "panther11";
      
      /**
       * This constructor initialize the connection with data base
       */
      public ConnectionBD() {
    	  try {
    		  String dbClass = "com.mysql.jdbc.Driver";
    		  Class.forName(dbClass).newInstance();
    		  Connection con = DriverManager.getConnection(DIR_DB, USER_DB, PASS_DB);
    		  statement = con.createStatement();
    	  } catch (Exception e) {
    		  e.printStackTrace();
    	  }
      }
      
      /**
       * This method is to delete all periods from data base
       * @throws SQLException
       */
      public void DeletePeriod() throws SQLException {
    	  DeleteData("jp_period","ID > 0");
      }
      
      /**
       * This method is to delete all applicants and users from data base 
       * except the admin user
       * @throws SQLException
       */
      public void DeletePerson() throws SQLException {
    	  DeleteData("login_register","ID > 0");
    	  DeleteData("user_period","APPLICANT_ID > 0");
    	  DeleteData("message","ID > 0");
    	  DeleteData("jp_user","CI != 123");
      }
      
      /**
       * This method is to delete all programs from data base 
       * @throws SQLException
       */
      public void DeleteProgram() throws SQLException{
    	  DeletePeriod();
    	  DeleteData("program","ID > 0");
      }
      
      /**
       * This method is to delete all Stages from data base 
       * @throws SQLException
       */
      public void DeleteStage() throws SQLException{
      	  DeleteData("stage","ID > 0");
      }
      
      /**
       * This method is to delete data from data base
       * @param table: Table Name
       * @param condition: Query Condition
       * @throws SQLException
       */
      private void DeleteData(String table, String condition) throws SQLException {
    	  try {
      		  String query = "DELETE FROM " + table + " WHERE " + condition + "";
      		  statement.execute(query);    
      	  } catch (Exception e) {
      		  e.printStackTrace();
      	  } finally {
      		  if (con != null) {
      			  con.close();
      		  }
      	  }
      }

      /**
       *  This method is to create a new program
       * @param id: program ID
       * @param name: program Name
       * @param title: program Title
       * @param description: program Description
       * @throws SQLException
       */
      public void CreateProgram(String id, String name, String title, String description) throws SQLException {
    	  try {
      		  String query = "INSERT INTO program VALUES ('" + id + "', '" + description + "', '" + name + "', '" + title + "')";
      		  statement.execute(query);    
      	  } catch (Exception e) {
      		  e.printStackTrace();
      	  } finally {
      		  if (con != null) {
      			  con.close();
      		  }
      	  }
      }
      
      /**
       *  This method is to create a new period
       * @param id: period ID
       * @param initDate: initial date to period
       * @param name: period name
       * @param periodState: period state
       * @param programID: program Id where the period will be created
       * @throws SQLException
       */
      public void CreatePeriod(String id, String initDate, String name, String periodState, String programID) throws SQLException {
    	  try {
      		  String query = "INSERT INTO jp_period(`ID`, `INITIALDATE`, `NAME`, `PERIODSTATE`, `PROGRAM_ID`) VALUES (" + id + ", '" + initDate + "', '" + name + "', '" + periodState + "', " + programID + ");";
      		  statement.execute(query);    
      	  } catch (Exception e) {
      		  e.printStackTrace();
      	  } finally {
      		  if (con != null) {
      			  con.close();
      		  }
      	  }
      }
}