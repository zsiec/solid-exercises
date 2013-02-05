package com.theladders.solid.srp.resume;

import com.theladders.solid.srp.jobseeker.Jobseeker;

public class MyResumeManager
{
  private final ActiveResumeRepository repository;

  public MyResumeManager(ActiveResumeRepository repository)
  {
    this.repository = repository;
  }

  public void saveAsActive(Jobseeker jobseeker,
                           Resume resume)
  {
    repository.makeActive(jobseeker.getId(), resume);
  }

  public Resume getActiveResume(int jobseekerId)
  {
    return repository.activeResumeFor(jobseekerId);
  }
}
