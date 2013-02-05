package com.theladders.solid.srp.job.application;


public class FailedApplication implements JobApplicationResult
{
  @Override
  public boolean failure()
  {
    return true;
  }
}
