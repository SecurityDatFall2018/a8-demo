
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;


public class Tester {
  public static void main(String[] args) {
    LogFile ob = new LogFile();
    ob.filename = "User_Nytro.log";
    ob.filecontent = "No actions logged";

    String fileOut = "Log.ser";
   
    String fileIn = "compromisedLog.ser"; //This should be the "compromised file made with the  ysoserial tool

    Utils.SerializeToFile(ob, fileOut);
   
   //The next three lines are just to ensure that org.apache.commons.collections.CollectionUtils is added to the classpath
    List<String> dummy = new ArrayList();
    int size = CollectionUtils.maxSize(dummy);
    System.out.println("Size" + size);
    ob = (LogFile) Utils.DeserializeFromFile(fileIn);
  }
  
}
