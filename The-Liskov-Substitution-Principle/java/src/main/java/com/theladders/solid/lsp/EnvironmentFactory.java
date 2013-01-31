package com.theladders.solid.lsp;

// Just a stub. Nothing to see here.

public class EnvironmentFactory
{
  public static Environment getEnvironmentFor(String hostName)
  {
    Environment env = new Environment();

    env.put("isSSL", "true");
    env.put("home", "http://" + hostName);
    env.put("secureHome", "https://" + hostName);

    return env;
  }
}
