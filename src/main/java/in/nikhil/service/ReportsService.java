package in.nikhil.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import in.nikhil.Entity.ReportsEntity;
import in.nikhil.Repository.ReportsRepository;
import in.nikhil.Request.SearchRequest;
import in.nikhil.Response.SearchResponse;

@Service
public class ReportsService {
	
	@Autowired
	private ReportsRepository repo;

	public List<SearchResponse> search(SearchRequest request){
		
		List<ReportsEntity> entityList = null;
		
		if(isSearchRequestEmpty(request)) {
			entityList = repo.findAll();
		}
		
		else { 
			String planName = request.getPlanName();
			String planStatus = request.getPlanStatus();
			LocalDate startDate = request.getStartDate();
			LocalDate endDate = request.getEndDate();
			
			ReportsEntity reportsEntity = new ReportsEntity();
			
			
			if(planName != null && !planName.equals("") ) {
				reportsEntity.setPlanName(planName);
			}
			if(planStatus != null && !planStatus.equals("") ) {
				reportsEntity.setPlanStatus(planStatus);
			}
			if(startDate != null && endDate != null ) {
				reportsEntity.setStartDate(startDate);
				reportsEntity.setEndDate(endDate);
			}
			
			Example<ReportsEntity> of = Example.of(reportsEntity);
			entityList = repo.findAll(of);	
		}
		
		List<SearchResponse> searchResponses = new ArrayList<>();
		for(ReportsEntity eachEntity : entityList ) {
			SearchResponse resp = new SearchResponse();
			BeanUtils.copyProperties(eachEntity, resp);
			searchResponses.add(resp);
		}
		
		return searchResponses;
	}
	
	public List<String> planStatus(){
		return repo.getUniquePlanStatuses();
	}
	
	public List<String> planNames(){
		return repo.getUniquePlanNames();
	}
	
	//method to check if request is empty
	public boolean isSearchRequestEmpty(SearchRequest request) {
		boolean isEmpty = true;
		
		if((request.getPlanName() != null) && (!request.getPlanName().equals("")) ) {
			isEmpty = false;
		}
		
		return isEmpty;
	}
	
}
