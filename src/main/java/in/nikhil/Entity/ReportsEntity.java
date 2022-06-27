package in.nikhil.Entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "REPORTS_TABLE")
public class ReportsEntity {
	
	
	@Column(name = "PLAN_ID")
	Integer planId;
	
	@Id
	@Column(name = "CASE_NUM")
	String caseNum;
	
	@Column(name = "PLAN_NAME")
	String planName;
	
	@Column(name = "HOLDER_NAME")
	String holderName;
	
	@Column(name = "HOLDER_SSN")
	String holderSsn;
	
	@Column(name = "GENDER")
	String gender;
	
	@Column(name = "PLAN_STATUS")
	String planStatus;
	
	@Column(name = "BENEFIT_AMT")
	Double benefitAmt;
	
	@Column(name = "START_DATE")
	LocalDate startDate;
	
	@Column(name = "END_DATE")
	LocalDate endDate;
	
	@Column(name = "DENIAL_REASON")
	String denialReason;

}
