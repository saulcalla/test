package cl.ripley.framework.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PageByPage
{
  private boolean hasPrev = true;
  private boolean hasNext = true;

  public String hasPrevRecords()
  {
    if (this.hasPrev) {
      return "true";
    }
    return "false";
  }

  public String hasNextRecords()
  {
    if (this.hasNext) {
      return "true";
    }
    return "false";
  }

  public Collection getCollection(List allRecords, String recNum, int linesPerPage)
  {
    Collection miniSet = null;
    int recordNum = Integer.parseInt(recNum);
    int firstRecord = recordNum - 1;

    if (firstRecord == 0)
      this.hasPrev = false;
    else {
      this.hasPrev = true;
    }

    int lastRecord = firstRecord + linesPerPage;

    if (lastRecord >= allRecords.size()) {
      lastRecord = allRecords.size();
      this.hasNext = false;
    } else {
      this.hasNext = true;
    }

    miniSet = new ArrayList(allRecords.subList(firstRecord, lastRecord));

    return miniSet;
  }

  public Collection getCollection(List allRecords, String recNum, int linesPerPage, boolean extract, int rowCount)
  {
    Collection miniSet = null;
    int recordNum = Integer.parseInt(recNum);
    int firstRecord = recordNum - 1;

    if (firstRecord == 0)
      this.hasPrev = false;
    else {
      this.hasPrev = true;
    }

    int lastRecord = firstRecord + linesPerPage;

    if (extract) {
      if (lastRecord >= allRecords.size()) {
        lastRecord = allRecords.size();
        this.hasNext = false;
      } else {
        this.hasNext = true;
      }
      miniSet = new ArrayList(allRecords.subList(firstRecord, lastRecord));
    } else {
      if (lastRecord >= rowCount) {
        lastRecord = rowCount;
        this.hasNext = false;
      } else {
        this.hasNext = true;
      }
      miniSet = allRecords;
    }
    return miniSet;
  }
}