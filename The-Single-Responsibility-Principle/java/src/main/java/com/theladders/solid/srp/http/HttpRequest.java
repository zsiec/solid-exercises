package com.theladders.solid.srp.http;

import java.util.Map;

public class HttpRequest
{
  private final HttpSession session;
  private final Map<String, String> parameters;

  public HttpRequest(HttpSession session,
                     Map<String,String> parameters)
  {
    this.session = session;
    this.parameters = parameters;
  }

  public HttpSession getSession()
  {
    return session;
  }

  public String getParameter(String key)
  {
    return parameters.get(key);
  }
}
