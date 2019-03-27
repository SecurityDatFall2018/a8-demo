package ser;

import java.io.*;
import java.util.Date;

/*
Dummy Classes for the serialization demo
*/
class A implements Serializable{
  public String name;
  public A(String name) {
    this.name = name;
  }
}
class B implements Serializable {
  public String name;
  public B(String name) {
    this.name = name;
  }
}

class Container implements Serializable{
  String info;
  A a;
  B b;
  Date created ;
  
   
  public Container(String info, A a, B b) {
    this.info = info;
    this.a = a;
    this.b = b;
    this.created = new Date();
  }

  @Override
  public String toString() {
    return "Container{" + "Info=" + info + ", a=" + a.name + ", b=" + b.name + ", created=" + created + '}';
  }
}

public class Serial {

  public void serializeSimple(String filename) {  
    Container c = new Container("FCK is Cool", new A("Hello"), new B("Hello hello"));
    try {
      try (FileOutputStream file = new FileOutputStream(filename); 
           ObjectOutputStream out = new ObjectOutputStream(file)) {       
        out.writeObject(c); 
      }
    } catch (IOException e) {
      System.out.println("Exception: " + e.toString());
    }
  }

  public void deSerializeSimple(String filename) {
    try {
      try (FileInputStream file = new FileInputStream(filename); ObjectInputStream out = new ObjectInputStream(file)) { 
        Container cont = (Container) out.readObject();
        System.out.println("Content read from file:" + cont.toString()); 
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
