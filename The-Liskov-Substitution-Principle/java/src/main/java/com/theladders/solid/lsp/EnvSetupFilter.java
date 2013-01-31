package com.theladders.solid.lsp;

import java.util.HashMap;
import java.util.Map;

/**
 * This filter puts an Environment object in the request and session. The environment is determined
 * by the host part of the request URL: if the host corresponds to a specific ladder, that ladder's
 * environment is selected; if the host is anything else -- including 'www', a default 'TheLadder'
 * environment is used. This filter also populates the AdminUpdater thread-local var.
 *
 * @author Zhi-Da Zhong &lt;zz@theladders.com&gt;
 */

public class EnvSetupFilter
{
  public static final String               SECURE_HOST = "secure";

  // insecure, auto -> secure
  private static final Map<String, String> securePropMap = new HashMap<>();
  // auto -> insecure
  private static final Map<String, String> insecurePropMap = new HashMap<>();
  // secure -> insecure
  private static final Map<String, String> noSSLPropMap = new HashMap<>();

  private static final String              AUTO_HOME   = "autoProtoHome";
  private static final String              MEMBER_HOME = "memberHome";
  private static final String              GUEST_HOME  = "guestHome";

  static
  {
    securePropMap.put("flash", "secureFlash");
    securePropMap.put("images", "secureImages");
    securePropMap.put("css", "secureCss");
    securePropMap.put("js", "secureJs");
    securePropMap.put("widgets", "secureWidgets");

    securePropMap.put("landingFlash", "secureLandingFlash");
    securePropMap.put("landingImages", "secureLandingImages");
    securePropMap.put("landingCss", "secureLandingCss");

    securePropMap.put("opalImages", "secureOpalImages");
    securePropMap.put("opalCss", "secureOpalCss");

    securePropMap.put("seoImages", "secureSeoImages");
    securePropMap.put("seoCss", "secureSeoCss");
    securePropMap.put("staticBase", "secureStaticBase");

    securePropMap.put(AUTO_HOME, "secureHome");
    securePropMap.put(MEMBER_HOME, "secureMemberHome");
    securePropMap.put(GUEST_HOME, "secureGuestHome");

    insecurePropMap.put(AUTO_HOME, "home");
    insecurePropMap.put(MEMBER_HOME, "insecureMemberHome");
    insecurePropMap.put(GUEST_HOME, "insecureGuestHome");

    noSSLPropMap.put("secureHome", "home");
    noSSLPropMap.put(AUTO_HOME, "home");

    noSSLPropMap.put("secureGuestHome", "insecureGuestHome");
    noSSLPropMap.put("secureMemberHome", "insecureMemberHome");
    noSSLPropMap.put("secureStaticBase", "staticBase");
    noSSLPropMap.put(MEMBER_HOME, "insecureMemberHome");
    noSSLPropMap.put(GUEST_HOME, "insecureGuestHome");
  }

  private final String hostName;

  public EnvSetupFilter(String hostName)
  {
    this.hostName = hostName;
  }

  public Environment getEnvironment(boolean isSecure, boolean loggedInUser)
  {
    Environment baseEnv = EnvironmentFactory.getEnvironmentFor(hostName);

    boolean sslIsSupported = Boolean.parseBoolean((String) baseEnv.get("isSSL"));

    Map<String, String> keyMap;
    if (!sslIsSupported)
    {
      keyMap = new HashMap<>(noSSLPropMap);
    }
    else if (isSecure)
    {
      keyMap = new HashMap<>(securePropMap);
    }
    else
    {
      keyMap = new HashMap<>(insecurePropMap);
    }

    Environment dynamicEnv = new DynamicEnvironment(baseEnv, keyMap);

    new SiteConfiguration().seedEnvironment(dynamicEnv);

    // Adds /member to site URLs if the user is logged in.
    if (loggedInUser)
    {
      /* Ensure site.home is member home */
      dynamicEnv.put("home", dynamicEnv.get("home") + SiteConfiguration.MEMBER_PATH_PREFIX);
      dynamicEnv.put("secureHome", dynamicEnv.get("secureHome") + SiteConfiguration.MEMBER_PATH_PREFIX);
    }

    return dynamicEnv;
  }
}
