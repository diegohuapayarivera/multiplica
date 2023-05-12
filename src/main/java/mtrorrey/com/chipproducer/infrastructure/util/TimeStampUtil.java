package mtrorrey.com.chipproducer.infrastructure.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeStampUtil {

  public static String dateLogger(){
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy:HH:mm:ss");
    Date date = new Date();
    String timestamp = dateFormat.format(date);
    return timestamp;
  }

}
