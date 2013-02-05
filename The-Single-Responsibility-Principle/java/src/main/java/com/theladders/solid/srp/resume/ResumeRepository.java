package com.theladders.solid.srp.resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResumeRepository
{
  private final Map<Integer, List<Resume>> resumes;

  public ResumeRepository()
  {
    this.resumes = new HashMap<>();
  }

  public Resume saveResume(int jobseekerId, Resume resume)
  {
    addResumeForJobseeker(jobseekerId, resume);

    return resume;
  }

  public boolean contains(Resume aResume)
  {
    for(int key : resumes.keySet())
    {
      for(Resume resume : resumes.get(key))
      {
        if (aResume.equals(resume)) return true;
      }
    }

    return false;
  }

  private void addResumeForJobseeker(int jobseekerId, Resume resume)
  {
    List<Resume> jsResumes = resumes.get(jobseekerId);

    if (jsResumes == null)
    {
      jsResumes = new ArrayList<>();
    }

    jsResumes.add(resume);

    resumes.put(jobseekerId, jsResumes);
  }
}
