package in.nikhil.Reports;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import in.nikhil.Response.SearchResponse;

public class ExcelReportGeneration {
	
	public void generateExcel(List<SearchResponse> searchResponse , HttpServletResponse servletResponse) throws Exception{
		
		Workbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.createSheet();
		Row headerRow =  sheet.createRow(0);
		
		headerRow.createCell(0).setCellValue("SNO.");
		headerRow.createCell(1).setCellValue("HOLDER NAME");
		headerRow.createCell(2).setCellValue("HOLDER SSN");
		headerRow.createCell(3).setCellValue("PLAN NAME");
		headerRow.createCell(4).setCellValue("PLAN STATUS");
		headerRow.createCell(5).setCellValue("BENEFIT AMOUNT");
		headerRow.createCell(6).setCellValue("START DATE");
		headerRow.createCell(7).setCellValue("END_DATE");
		headerRow.createCell(8).setCellValue("DENIAL REASON");
		
		for(int i = 0; i< searchResponse.size(); i++) {
			Row row = sheet.createRow(i+1);
			SearchResponse record = searchResponse.get(i);
			row.createCell(0).setCellValue(i+1);
			row.createCell(1).setCellValue(record.getHolderName());
			row.createCell(2).setCellValue(String.valueOf(record.getHolderSsn() ));
			row.createCell(3).setCellValue(record.getPlanName());
			row.createCell(4).setCellValue(record.getPlanStatus());
			row.createCell(5).setCellValue(String.valueOf(record.getBenefitAmt() ));
			row.createCell(6).setCellValue(String.valueOf(record.getStartDate() ));
			row.createCell(7).setCellValue(String.valueOf(record.getEndDate() ));
			row.createCell(8).setCellValue(record.getDenialReason());		
			
		}
		
		workbook.write(servletResponse.getOutputStream());
		workbook.close();
		
		
	}

}
