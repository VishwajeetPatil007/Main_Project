package utilityClasses;

import java.util.Hashtable;

public class testDataProvider {

	public static Object[][] getTestdata(String DataFileName, String SheetName, String Testname) {
		readExcelFile readdata = new readExcelFile(System.getProperty("user.dir") + "\\testData\\" + DataFileName);
		String sheetName = SheetName;
		String testName = Testname;

		int startRowNum = 0;
		while (!readdata.getCellData(sheetName, 0, startRowNum).equalsIgnoreCase(testName)) {
			startRowNum++;
		}
		
		int startTestColumnRow = startRowNum + 1;
		// System.out.println(startTestColumn);
		int startTestRow = startRowNum + 2; // refer Excel sheet

		// Finding number of rows of testcase
		int rows = 0;
		while (!readdata.getCellData(sheetName, 0, startTestRow + rows).equals("")) {
			rows++;
		}
		

		// Finding number of columns of test case

		int columns = 0;
		while (!readdata.getCellData(sheetName, columns, startTestColumnRow).equalsIgnoreCase("")) {
			columns++;
		}


		Object[][] dataset = new Object[rows][1];
		Hashtable<String, String> datatable = null;

		int rowNum = 0;
		for (int rownum = startTestRow; rownum < startTestRow + rows; rownum++) {
			datatable = new Hashtable<String, String>();
			for (int colnum = 0; colnum < columns; colnum++) {
				String key = readdata.getCellData(sheetName, colnum, startTestColumnRow);
				String value = readdata.getCellData(sheetName, colnum, rownum);
				datatable.put(key, value);

			}
			dataset[rowNum][0] = datatable;
			rowNum++;
		}
		return dataset;
	}
}
