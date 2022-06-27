package in.nikhil.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.nikhil.Entity.ReportsEntity;

public interface ReportsRepository extends JpaRepository<ReportsEntity, Integer>{

	@Query("select distinct(planName) from ReportsEntity")
	public List<String> getUniquePlanNames();
	
	@Query("select distinct(planStatus) from ReportsEntity")
	public List<String> getUniquePlanStatuses();
	
	
}
