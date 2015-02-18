package framework.bd;

import java.sql.*;

import static framework.utils.Globals.DIR_DB;
import static framework.utils.Globals.USER_DB;
import static framework.utils.Globals.PASSWORD_DB;
import static framework.utils.Globals.DB_CLASS;

/**
 * 
 * @author Asael Calizaya
 *
 */
public class ConnectionBD {
	private static Connection con = null;
	private static Statement statement;

	/**
	 * This constructor initialize the connection with data base
	 */
	public ConnectionBD() {
		try {
			String dbClass = DB_CLASS;
			Class.forName(dbClass).newInstance();
			Connection con = DriverManager.getConnection(DIR_DB, USER_DB, PASSWORD_DB);
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
	public void CreateProgram(String name, String title, String description) throws SQLException {
		try {
			String id = getNextID("program");
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
	public void CreatePeriod(String initDate, String name, String periodState) throws SQLException {
		try {
			String id = getNextID("jp_period");
			String programID = getfirstID("program");
			String query = "INSERT INTO jp_period(`ID`, `INITIALDATE`, `NAME`, `PERIODSTATE`, `PROGRAM_ID`) "
					+ "VALUES (" + id + ", '" + initDate + "', '" + name + "', '" + periodState + "', " + programID + ")";
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
	 * This method get the name of program
	 * @param name: name of program to get
	 * @return: String program name
	 * @throws SQLException
	 */
	public String getProgramName(String name) throws SQLException {
		return getAnyName("program", "NAME = '" + name + "'");
	}
	
	/**
	 * This method get the name of period
	 * @param name: name of period to get
	 * @return: String period name
	 * @throws SQLException
	 */
	public String getPeriodName(String name) throws SQLException {
		return getAnyName("jp_period", "NAME = '" + name + "'");
	}
	
	/**
	 * This method get the name of applicant
	 * @param ci: ci of applicant to get name
	 * @return: String applicant name
	 * @throws SQLException
	 */
	public String getPersonName(String ci) throws SQLException {
		return getAnyName("jp_user", "CI = " + ci);
	}
	
	/**
	 * This method is to get the next usable Id
	 * @return
	 * @throws SQLException
	 */
 	private String getNextID(String table) throws SQLException {
		String query = "SELECT id FROM " + table + " ORDER BY id DESC LIMIT 1";
		String value = "1";
		ResultSet res = statement.executeQuery(query);
		while(res.next()) {
			value = res.getString(1);
			if (value == "") {
				value = "1";
			}
			value = (Integer.parseInt(value) + 1) + "";
		}
		return value;
	}

	/**
	 * This method is to get the first id 
	 * @param table
	 * @return
	 * @throws SQLException
	 */
	private String getfirstID(String table) throws SQLException {
		String query = "SELECT id FROM " + table + " ORDER BY id asc LIMIT 1";
		String value = "";
		ResultSet res = statement.executeQuery(query);
		while(res.next()) {
			value = res.getString(1);
			if (value == null) {
				value = "1";
			}
		}
		return value;
	}
	
	/**
	 * This method get data of any table
	 * @param table: table name
	 * @param condition: condition to execute query
	 * @return: String name
	 * @throws SQLException
	 */
	private String getAnyName(String table, String condition) throws SQLException {
		String value = "null";
		try {
			String query = "SELECT NAME FROM " + table + " WHERE " + condition + "";
			ResultSet res = statement.executeQuery(query);
			while(res.next()){
				value = res.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				con.close();
			}
		}
		return value;
	}
}