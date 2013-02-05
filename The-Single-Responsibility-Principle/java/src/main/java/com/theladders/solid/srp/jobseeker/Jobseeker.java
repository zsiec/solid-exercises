package com.theladders.solid.srp.jobseeker;

public class Jobseeker
{
  private final int id;
  private final boolean hasPremiumAccount;

  public Jobseeker(int id, boolean hasPremiumAccount)
  {
    this.id = id;
    this.hasPremiumAccount = hasPremiumAccount;
  }

  public boolean isPremium()
  {
    return hasPremiumAccount;
  }

  public int getId()
  {
    return id;
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
    Jobseeker other = (Jobseeker) obj;
    if (id != other.id)
      return false;
    return true;
  }
}
