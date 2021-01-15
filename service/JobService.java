package com.tcs.rakesh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.rakesh.entity.JobDao;
import com.tcs.rakesh.repository.JobRepository;

@Service
public class JobService {

	@Autowired
	private JobRepository repo;
	//method for store data
	public JobDao saveJob(JobDao job) {
		 return repo.save(job);
	}	 

	
	//method for get all data
	public List<JobDao> getJobs(){
		return repo.findAll();
	}	
	//method for get data by id
	public JobDao getJobById(int jobid){
		return repo.findById(jobid).orElse(null);
	}
//	public JobDao getJobByName(String jobname) {
//		return repo.findById(jobname);
//	}


	public JobDao getJobByName(String jobname) {
		// TODO Auto-generated method stub
	try {
		return repo.findByJobName(jobname);
	}	
	catch (Exception ex) {
		return null;
	}
		 
	}


	


		
}
