package com.theladders.solid.ocp.resume;

import com.theladders.solid.ocp.user.User;

public class JobseekerProfileManager
{
  public JobseekerProfile getJobSeekerProfile(User user)
  {
    return new JobseekerProfile(user.getId());
  }
}
