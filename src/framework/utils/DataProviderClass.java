package framework.utils;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

	private static String filePath = "C:\\Users\\Asael Calizaya\\workspace\\jagdPanther\\src\\framework\\dataSource";
	private static String fileName = "ExcelSource.xlsx";
	private static ReadDataFromExcelFile objExcelFile;
	
	@DataProvider(name = "ProgramsDataXlsx")
	public static Object[][] programData() throws IOException {
		objExcelFile = new ReadDataFromExcelFile();
		return objExcelFile.readExcel(filePath,fileName,"Programs");
	}
	@DataProvider(name = "PeriodDataXlsx")
	public static Object[][] periodData() throws IOException {
		objExcelFile = new ReadDataFromExcelFile();
		return objExcelFile.readExcel(filePath,fileName,"Periods");
	}
	@DataProvider(name = "ApplicantDataXlsx")
	public static Object[][] applicantData(){
		return new Object[][]{
				{"10001","NameApplicant","LastNameApplicant","Name1@LastName.com","777777771"},
				{"10002","NameApplicante","LastNameApplicant","Name1@LastName2.com","777777772"}
		};
	}
	@DataProvider(name = "StagesDataXlsx")
	public static Object[][] stageData() throws IOException {
		objExcelFile = new ReadDataFromExcelFile();
		return objExcelFile.readExcel(filePath,fileName,"Stages");
	}
	@DataProvider(name = "UsersDataXlsx")
	public static Object[][] userData(){
		return new Object[][] {
				{"1234","userName1","userLastName1","user@lastName1.com"},
				{"1235","userName2","userLastName2","user@lastName2.com"}
		};
	}
} 
