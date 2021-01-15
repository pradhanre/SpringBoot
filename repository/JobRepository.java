package com.tcs.rakesh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.rakesh.entity.JobDao;

public interface JobRepository extends JpaRepository<JobDao, Integer>{

	JobDao findByJobName(String jobname);
	

}
