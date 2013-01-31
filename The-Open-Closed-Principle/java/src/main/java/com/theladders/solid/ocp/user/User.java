package com.theladders.solid.ocp.user;

public class User
{
  private final int id;

  public User(int id)
  {
    this.id = id;
  }

  public int getId()
  {
    return id;
  }
}
