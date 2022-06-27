package in.nikhil.Reports;



import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import in.nikhil.Response.SearchResponse;

public class PdfReportGeneration {
	
	public void generatePdf(List<SearchResponse> searchResponses, HttpServletResponse response ) throws Exception {
		
		
		Document document = new Document();
		PdfWriter writer = PdfWriter.getInstance(document, response.getOutputStream());
		document.open();
		//font and color setting
		Font font = new Font(Font.HELVETICA, 16, Font.BOLDITALIC);
		Paragraph paragraph = new Paragraph("Insurance Details", font );
		document.add(paragraph);
		
		PdfPTable pdfPTable = new PdfPTable(9);
		pdfPTable.addCell("SNO.");
		pdfPTable.addCell("HOLDER NAME");
		pdfPTable.addCell("HOLDER SSN");
		pdfPTable.addCell("PLAN NAME");
		pdfPTable.addCell("PLAN STATUS");
		pdfPTable.addCell("BENEFIT AMOUNT");
		pdfPTable.addCell("START DATE");
		pdfPTable.addCell("END_DATE");
		pdfPTable.addCell("DENIAL REASON");
		
		int sno = 1;
		
		for(SearchResponse eachResponse : searchResponses) {
			pdfPTable.addCell(String.valueOf(sno));
			pdfPTable.addCell(eachResponse.getHolderName());
			pdfPTable.addCell( String.valueOf(eachResponse.getHolderSsn() ));
			pdfPTable.addCell(eachResponse.getPlanName());
			pdfPTable.addCell(eachResponse.getPlanStatus());
			pdfPTable.addCell(String.valueOf(eachResponse.getBenefitAmt()));
			pdfPTable.addCell(String.valueOf(eachResponse.getStartDate() ));
			pdfPTable.addCell(String.valueOf(eachResponse.getEndDate() ));
			pdfPTable.addCell(eachResponse.getDenialReason());
			sno++;
			}
			document.add(pdfPTable);
			document.close();
			writer.close();
	}

}
