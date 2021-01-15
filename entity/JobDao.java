package com.tcs.rakesh.entity;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import com.tcs.rakesh.validator.Description;
import com.tcs.rakesh.validator.JobName;

@Entity
public class JobDao{
	@Id
	@GeneratedValue
	private int jobid;
	@Column(name="jobname")
	@JobName
	private String jobName;
	
	@NotNull(message="owner is mandatory")
	private String owner;
	@NotNull(message="description is mandatory")
	@Description
	private String description;
	@NotNull(message="area is mandatory")
	private String area;
	private String jobKey;
	public JobDao() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JobDao(int jobid, String jobname, String owner, String description, String area, String jobkey) {
		super();
		this.jobid = jobid;
		this.jobName = jobname;
		this.owner = owner;
		this.description = description;
		this.area = area;
		this.jobKey = jobkey;
	}
	public int getJobid() {
		return jobid;
	}
	public void setJobid(int jobid) {
		this.jobid = jobid;
	}
	public String getJobname() {
		return jobName;
	}
	public void setJobname(String jobname) {
		this.jobName = jobname;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getJobkey() {
		return jobKey;
	}
	public void setJobkey(String jobkey) {
		this.jobKey = jobkey;
	}
	@Override
	public String toString() {
		return "JobDao [jobid=" + jobid + ", jobname=" + jobName + ", owner=" + owner + ", description=" + description
				+ ", area=" + area + ", jobkey=" + jobKey + "]";
	}
	
}