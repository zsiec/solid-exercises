package com.theladders.solid.ocp.resume;

import com.theladders.solid.ocp.jobseeker.JobseekerConfidentialityProfile;
import com.theladders.solid.ocp.jobseeker.JobseekerConfidentialityProfileDao;
import com.theladders.solid.ocp.user.User;

public class ConfidentialResumeHandler
{
  private final JobseekerProfileManager            jobSeekerProfileManager;
  private final JobseekerConfidentialityProfileDao jobseekerConfidentialityProfileDao;

  public ConfidentialResumeHandler(JobseekerProfileManager jobseekerProfileManager,
                                   JobseekerConfidentialityProfileDao jobseekerConfidentialityProfileDao)
  {
    this.jobSeekerProfileManager = jobseekerProfileManager;
    this.jobseekerConfidentialityProfileDao = jobseekerConfidentialityProfileDao;
  }

  public void makeAllCategoriesNonConfidential(User user)
  {
    JobseekerProfile jsp = jobSeekerProfileManager.getJobSeekerProfile(user);
    JobseekerConfidentialityProfile profile = jobseekerConfidentialityProfileDao.fetchJobSeekerConfidentialityProfile(jsp.getId());

    boolean isChanged = false;
    isChanged = profile.resetConfidentialFlagsForCategory(ConfidentialPhraseCategory.Name) || isChanged;
    isChanged = profile.resetConfidentialFlagsForCategory(ConfidentialPhraseCategory.PhoneNumber) || isChanged;
    isChanged = profile.resetConfidentialFlagsForCategory(ConfidentialPhraseCategory.EmailAddress) || isChanged;
    isChanged = profile.resetConfidentialFlagsForCategory(ConfidentialPhraseCategory.MailingAddress) || isChanged;
    isChanged = profile.resetConfidentialFlagsForCategory(ConfidentialPhraseCategory.ContactInfo) || isChanged;
    isChanged = profile.resetConfidentialFlagsForCategory(ConfidentialPhraseCategory.CompanyName) || isChanged;
    isChanged = profile.resetConfidentialFlagsForCategory(ConfidentialPhraseCategory.WorkExperience) || isChanged;

    if (isChanged)
    {
      generatePermanentConfidentialFiles(user, profile);
    }
  }

  public void makeAllContactInfoNonConfidential(User user)
  {
    JobseekerProfile jsp = jobSeekerProfileManager.getJobSeekerProfile(user);
    JobseekerConfidentialityProfile profile = jobseekerConfidentialityProfileDao.fetchJobSeekerConfidentialityProfile(jsp.getId());
    boolean isChanged = false;
    isChanged = profile.resetConfidentialFlagsForCategory(ConfidentialPhraseCategory.PhoneNumber) || isChanged;
    isChanged = profile.resetConfidentialFlagsForCategory(ConfidentialPhraseCategory.EmailAddress) || isChanged;
    isChanged = profile.resetConfidentialFlagsForCategory(ConfidentialPhraseCategory.MailingAddress) || isChanged;
    isChanged = profile.resetConfidentialFlagsForCategory(ConfidentialPhraseCategory.ContactInfo) || isChanged;

    if (isChanged)
    {
      generatePermanentConfidentialFiles(user, profile);
    }
  }

  @SuppressWarnings("unused")
  private void generatePermanentConfidentialFiles(User user,
                                                  JobseekerConfidentialityProfile profile)
  {
    // stub
  }
}
