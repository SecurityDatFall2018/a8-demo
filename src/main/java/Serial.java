

import java.io.*;

public class Serial {

  public void serializeSimple(String filename) {
    String name = "FCK is cool";

    try {
      try (FileOutputStream file = new FileOutputStream(filename); 
           ObjectOutputStream out = new ObjectOutputStream(file)) {
        
        // Serialization of the "name" (String) object
        // Will be written to "file.bin"
        out.writeObject(name);
        
      }
    } catch (IOException e) {
      System.out.println("Exception: " + e.toString());
    }
  }

  public void deSerializeSimple(String filename) {
    String name;
    try {
      try (FileInputStream file = new FileInputStream(filename); ObjectInputStream out = new ObjectInputStream(file)) { 
        // Serialization of the "name" (String) object
        // Will be written to "file.bin"
        name = (String) out.readObject();
        System.out.println("Content read from file:" + name);
        
      }
    } catch (IOException | ClassNotFoundException e) {
      System.out.println("Exception: " + e.toString());
    }
  }

  public static void main(String[] args) {
    Serial serial = new Serial();
    serial.serializeSimple("file.bin");
    serial.deSerializeSimple("file.bin");

   
  }
}
