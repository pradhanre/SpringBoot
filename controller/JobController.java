package com.tcs.rakesh.controller;
import java.nio.file.FileAlreadyExistsException;
import java.util.List;
import java.util.UUID;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.uuid.Generators;
import com.tcs.rakesh.entity.JobDao;
import com.tcs.rakesh.service.JobService;
import org.json.JSONObject;


@RestController
public class JobController {

	@Autowired
	private JobService service;
	
	@PostMapping("/v1/job/{jobname}")
	@Produces(MediaType.APPLICATION_JSON)
	 @ResponseStatus(HttpStatus.CREATED)
	public String addJob(@Valid@PathVariable("jobname") String jobname,@RequestBody JobDao job) throws FileAlreadyExistsException {
		JSONObject json= new JSONObject();
		UUID uuid=Generators.timeBasedGenerator().generate();		 
		job.setJobkey(uuid.toString());
		
		JobDao jd=service.getJobByName(jobname);
		if(jd!= null && job.getJobname()==jobname) {
			throw new FileAlreadyExistsException(jobname);
		}
		else {
			job.setJobname(jobname);
			service.saveJob(job);
			
			json.put("jobid", job.getJobid());
			json.put("jobkey", job.getJobkey());
					}
		return json.toString();	

	} 
	@GetMapping("/match/job/{jobid}")
	public String authenication(@PathVariable("jobid") int jobid)  {
		String result=null;
		int a=jobid;
		JobDao jd= service.getJobById(jobid);
		
		if(jd!= null && jd.getJobid()==a) {
			result="Job exists";	
			
		}			
		else {
			result="Job doesn't exists";
			throw new NotFoundException("Data Not Found");
		}	
		return result;
	}
	
	@GetMapping("/jobs")
	public List<JobDao> findAllJobs(){
		return service.getJobs();
	}
	 	
	@GetMapping("/job/{jobid}")
	public JobDao findJobByJobid(@PathVariable int jobid){
		return service.getJobById(jobid);
	}
	
		
//	@GetMapping("/v1/job/{jobid}/auth/{authkey}")
//	public String authenication(@PathVariable("jobid") String jobid,@PathVariable("authkey") String authkey){
//		
//		return "job-id is: "+jobid +" and "+" auth-key is: "+ authkey;
//	}
}


@ControllerAdvice
class GlobalControllerExceptionHandler {
    @ResponseStatus(HttpStatus.FORBIDDEN)  // 409
    @ExceptionHandler(ConstraintViolationException.class)
    public void handleConflict() {
        // Nothing to do
    }
    
    @ResponseStatus(HttpStatus.NOT_FOUND)  
    @ExceptionHandler(NotFoundException.class)
    public void notFound() {
		
        // Nothing to do
    }
  
    @ResponseStatus(HttpStatus.FOUND)  
    @ExceptionHandler(FileAlreadyExistsException.class)
    public void fileExists() {
		
        // Nothing to do
    }

}