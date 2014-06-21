package cl.ripley.framework.util;

import java.io.Serializable;
import java.util.Locale;
import org.apache.log4j.Logger;

public class UserContext
  implements Serializable
{
  private static Logger logger = Logger.getLogger(UserContext.class);

  private Integer idCode = new Integer(0);
  private String idKey = "";
  private Integer countryCode = new Integer(0);
  private Locale myLocale = null;
  private String menuList = "";
  private String sessionId = "";
  private String language = "";
  private String localeName = "";
  private String loginName = "";
  private String orignalHost = "";

  public UserContext(Integer idCode, Integer countryCode, String menuList, String sessionId)
  {
    setIdCode(idCode);
    setSessionId(sessionId);
    setCountryCode(countryCode);
    setMenuList(menuList);
  }

  public void setLocale(String language, String country) {
    this.myLocale = new Locale(language, country);
  }

  public Locale getLocale() {
    return this.myLocale;
  }

  public String getMenuList()
  {
    return this.menuList;
  }

  public void setMenuList(String theMenuList)
  {
    this.menuList = theMenuList;
  }

  public String getLanguage()
  {
    return this.language;
  }

  public String getLocaleName()
  {
    return this.localeName;
  }

  public String getLoginName()
  {
    return this.loginName;
  }

  public String getOrignalHost()
  {
    return this.orignalHost;
  }

  public String getSessionId()
  {
    return this.sessionId;
  }

  public void setLanguage(String string)
  {
    this.language = string;
  }

  public void setLocaleName(String string)
  {
    this.localeName = string;
  }

  public void setLoginName(String string)
  {
    this.loginName = string;
  }

  public void setOrignalHost(String string)
  {
    this.orignalHost = string;
  }

  public void setSessionId(String string)
  {
    this.sessionId = string;
  }

  public String getIdKey()
  {
    return this.idKey;
  }

  public void setIdKey(String string)
  {
    this.idKey = string;
  }

  public Integer getCountryCode()
  {
    return this.countryCode;
  }

  public void setCountryCode(Integer integer)
  {
    this.countryCode = integer;
  }

  public Integer getIdCode()
  {
    return this.idCode;
  }

  public void setIdCode(Integer integer)
  {
    this.idCode = integer;
  }
}