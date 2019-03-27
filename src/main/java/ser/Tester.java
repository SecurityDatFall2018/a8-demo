package ser;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;

public class Tester {
  public static void main(String[] args) {
    String fileIn = "compromisedLog.ser"; //"compromised file made with the  ysoserial tool 
   //The next three lines are just to ensure that org.apache.commons.collections.CollectionUtils is added to the classpath
    List<String> dummy = new ArrayList();
    int size = CollectionUtils.maxSize(dummy);
    System.out.println("Size" + size);
    //Observer what happens here
    Object o =  Utils.DeserializeFromFile(fileIn);
  }
  
}
