package com.theladders.solid.srp.job;


public class JobSearchService
{
  private final JobRepository repository;

  public JobSearchService(JobRepository repository)
  {
    this.repository = repository;
  }

  public Job getJob(int jobId)
  {
    return repository.getJob(jobId);
  }
}
