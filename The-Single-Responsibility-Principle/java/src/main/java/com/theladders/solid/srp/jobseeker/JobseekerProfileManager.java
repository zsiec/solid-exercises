package com.theladders.solid.srp.jobseeker;


public class JobseekerProfileManager
{
  private final JobseekerProfileRepository repository;

  public JobseekerProfileManager(JobseekerProfileRepository repository)
  {
    this.repository = repository;
  }

  public JobseekerProfile getJobSeekerProfile(Jobseeker jobseeker)
  {
    return  repository.getProfile(jobseeker.getId());
  }
}
