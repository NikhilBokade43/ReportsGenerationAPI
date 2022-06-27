package in.nikhil.Request;

import java.time.LocalDate;

import lombok.Data;

@Data
public class SearchRequest {
	
	String planName;
	String planStatus;
	LocalDate startDate;
	LocalDate endDate; 

}
