package in.nikhil.controller;


import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.nikhil.Reports.ExcelReportGeneration;
import in.nikhil.Reports.PdfReportGeneration;
import in.nikhil.Request.SearchRequest;
import in.nikhil.Response.SearchResponse;
import in.nikhil.service.ReportsService;

@RestController
public class ReportRestController {
	
	@Autowired
	private ReportsService service;
	
	
	@PostMapping("/report")
	public List<SearchResponse> search(@RequestBody SearchRequest reqForm){
		return service.search(reqForm);	
	}
	
	@GetMapping("/planNames")
	public List<String> getPlanNames(){
		return service.planNames();
	}
	
	@GetMapping("/planStatuses")
	public List<String> getPlanStatuses(){
		return service.planStatus();
	}
	
	@GetMapping("reports/pdf")
	public void downloadPdfReport(HttpServletResponse response) throws Exception{
		response.setContentType("application/pdf");
		String headerKey = "Content-Disposition";
		String headervalue = "attachment; filename=Plans.pdf";
		response.setHeader(headerKey, headervalue);
		
		List<SearchResponse> records = service.search(null);
		PdfReportGeneration pdf = new PdfReportGeneration();
		pdf.generatePdf(records, response);
	}
	
	@GetMapping("reports/excel")
	public void downloadExcelReport(HttpServletResponse response) throws Exception {
		response.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		String headervalue = "attachment; filename=Plans.xls";
		response.setHeader(headerKey, headervalue);

		List<SearchResponse> records = service.search(null);
		ExcelReportGeneration  excel = new ExcelReportGeneration();
		excel.generateExcel(records, response);
	}
	
}
