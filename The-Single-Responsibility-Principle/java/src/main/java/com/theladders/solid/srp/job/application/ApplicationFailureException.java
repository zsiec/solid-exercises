package com.theladders.solid.srp.job.application;

public class ApplicationFailureException extends RuntimeException
{
  public ApplicationFailureException(String reason)
  {
    super(reason);
  }
}
