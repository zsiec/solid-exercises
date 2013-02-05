package com.theladders.solid.srp.job;

public class Job
{
  private final int id;
  private final String title;

  public Job(int id)
  {
    this.id = id;
    this.title = "This is a job with id:" + Integer.toString(id);
  }

  public int getJobId()
  {
    return id;
  }

  public String getTitle()
  {
    return title;
  }

  @Override
  public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    result = prime * result + id;
    return result;
  }

  @Override
  public boolean equals(Object obj)
  {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Job other = (Job) obj;
    if (id != other.id)
      return false;
    return true;
  }
}
