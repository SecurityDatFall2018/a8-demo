

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

class LogFile implements Serializable
{
   public String filename;
   public String filecontent;

  // Function called during deserialization

  private void readObject(ObjectInputStream in)
  {
     System.out.println("readObject from LogFile");

     try
     {
        // Unserialize data

        in.defaultReadObject();
        System.out.println("File name: " + filename + ", file content: \n" + filecontent);

       try ( // Do something useful with the data
       // Restore LogFile, write file content to file name
               FileWriter file = new FileWriter(filename); 
               BufferedWriter out = new BufferedWriter(file)) {
         
         System.out.println("Restoring log data to file...");
         out.write(filecontent);
         
       }
     }
     catch (IOException | ClassNotFoundException e)
     {
         System.out.println("Exception: " + e.toString());
     }
   }
}