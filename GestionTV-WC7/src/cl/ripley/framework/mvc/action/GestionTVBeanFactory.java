package cl.ripley.framework.mvc.action;

import java.util.ArrayList;

public class GestionTVBeanFactory
{
  private static ArrayList myBeanArray = new ArrayList();

  public static ArrayList getBeanArray()
  {
    return myBeanArray;
  }
}