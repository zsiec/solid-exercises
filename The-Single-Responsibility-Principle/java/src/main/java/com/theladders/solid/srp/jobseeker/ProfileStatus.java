package com.theladders.solid.srp.jobseeker;

public enum ProfileStatus
{
  INCOMPLETE(17, "Incomplete"),
  APPROVED(18, "Approved"),
  PENDING(22, "Pending"),
  PERMANENT_DECLINE(41, "Permanently Declined"),
  REMOVED(67, "Removed"),
  NO_PROFILE(100, "No Profile"),
  DECLINED(301, "Declined"),
  DELETED(2001, "Deleted"),
  SUSPENDED(2002, "Suspended"),
  PENDING_ESCALATED(2228, "Pending Escalated");

  private int    id;
  private String name;

  ProfileStatus(final int id,
                final String name)
  {
    this.id = id;
    this.name = name;
  }
}
