package framework.utils;


public final class Globals {
	private static JsonReadFile value = new JsonReadFile();
	public static final String BROWSER = value.readJsonFile("browser", "navigator");
	public static final String URL = value.readJsonFile("browser", "url");
	public static final String CHROMEDRIVER_PATH = value.readJsonFile("confDriver", "chrome");
	public static final String IEDRIVER_PATH = value.readJsonFile("confDriver", "ie");
	public static final int IMPLICIT_WAIT = Integer.parseInt(value.readJsonFile("confDriver", "implicitWait"));
	public static final int EXPLICIT_WAIT = Integer.parseInt(value.readJsonFile("confDriver", "explicitWait"));
	public static final int WEBDRIVERWAIT_SLEEP = Integer.parseInt(value.readJsonFile("confDriver", "explicitWait"));
	public static final String USER_NAME = value.readJsonFile("login", "user");
	public static final String PASSWORD = value.readJsonFile("login", "password");
	public static final String DB_CLASS = value.readJsonFile("dataBase", "dataBaseClass");
	public static final String DIR_DB = value.readJsonFile("dataBase", "dirDB");
	public static final String USER_DB = value.readJsonFile("dataBase", "userDB");
	public static final String PASSWORD_DB = value.readJsonFile("dataBase", "passwordDB");
}
