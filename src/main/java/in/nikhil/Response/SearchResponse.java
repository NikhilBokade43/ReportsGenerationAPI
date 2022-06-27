package in.nikhil.Response;

import java.time.LocalDate;

import lombok.Data;

@Data
public class SearchResponse {
	String planName;
	String holderName;
	long holderSsn;
	String gender;
	String planStatus;
	Double benefitAmt;
	LocalDate startDate;
	LocalDate endDate; 
	String denialReason;
}
