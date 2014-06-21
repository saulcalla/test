package cl.ripley.framework.mvc.action;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.struts.action.ActionForward;

public class ForwardParameters
{
  private Map params = new HashMap();

  public ForwardParameters add(String paramName, String paramValue) {
    this.params.put(paramName, paramValue);
    return this;
  }

  public ActionForward forward(ActionForward forward)
  {
    StringBuffer path = new StringBuffer(forward.getPath());
    Iterator iter = this.params.entrySet().iterator();
    if (iter.hasNext())
    {
      Map.Entry entry = (Map.Entry)iter.next();
      path.append("?" + entry.getKey() + "=" + entry.getValue());

      while (iter.hasNext()) {
        entry = (Map.Entry)iter.next();
        path.append("&" + entry.getKey() + "=" + entry.getValue());
      }
    }

    return new ActionForward(path.toString());
  }
}