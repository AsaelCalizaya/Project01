package framework.bd;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import jxl.read.biff.BiffException;
import framework.utils.ExcelReadFile;

public class ManageProgramsSuitSetup {
	private static String filePath = "C:\\Users\\Asael Calizaya\\workspace\\jagdPanther\\src\\framework\\dataSource\\ExcelSource.xls";
	private static ConnectionBD con = new ConnectionBD();

	/**
	 * This method read information of excel file with hashMaps
	 * @throws SQLException
	 * @throws BiffException
	 * @throws IOException
	 */
	public void CreateProgramsBD() throws SQLException, BiffException, IOException {
		List<Map<String, String>> programsXLS;
		ExcelReadFile xlsFile = new ExcelReadFile(filePath);
		programsXLS = xlsFile.getMapValues("Programs");
		createProgramsByBD(programsXLS);
	}
	
	public void CreatePeriodBD() throws BiffException, IOException, SQLException {
		List<Map<String, String>> periodsXLS;
		ExcelReadFile xlsFile = new ExcelReadFile(filePath);
		periodsXLS = xlsFile.getMapValues("PeriodsBD");
		createPeriodsByBD(periodsXLS);
	}
	
	/**
	 * This method create programs into dataBase
	 * @param programsXLS
	 * @throws SQLException
	 */
	private static void createProgramsByBD(List<Map<String, String>> programsXLS) throws SQLException {
		System.out.println("Starting to create Programs......");
		for (Map<String, String> programInfo : programsXLS)	{
			con.CreateProgram(programInfo.get("programName"), programInfo.get("programTitle"), programInfo.get("programDescription"));
		}
		System.out.println("Finishing the creation of Programs......");
	}
	
	private static void createPeriodsByBD(List<Map<String, String>> periodXLS) throws SQLException {
		System.out.println("Starting to create Periods......");
		for (Map<String, String> periodInfo : periodXLS)	{
			con.CreatePeriod(periodInfo.get("PeriodStartDay"), periodInfo.get("PeriodName"), periodInfo.get("PeriodState"));
		}
		System.out.println("Finishing the creation of Periods......");
	}
}
