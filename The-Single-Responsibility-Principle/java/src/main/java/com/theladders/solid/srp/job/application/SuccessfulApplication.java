package com.theladders.solid.srp.job.application;

import com.theladders.solid.srp.job.Job;
import com.theladders.solid.srp.jobseeker.Jobseeker;
import com.theladders.solid.srp.resume.Resume;

public class SuccessfulApplication implements JobApplicationResult
{
  private final Jobseeker jobseeker;
  private final Job job;
  private final Resume resume;

  public SuccessfulApplication(Jobseeker jobseeker,
                               Job job,
                               Resume resume)
  {
    this.jobseeker = jobseeker;
    this.job = job;
    this.resume = resume;
  }

  @Override
  public boolean failure()
  {
    return false;
  }

  public Object getJobseeker()
  {
    return jobseeker;
  }

  public Object getJob()
  {
    return job;
  }
}
