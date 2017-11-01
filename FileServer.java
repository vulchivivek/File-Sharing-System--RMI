import java.io.*;

import java.rmi.*;

public class FileServer {
public FileServer(){}

public static void main(String argv[]) {

try {

FileInterface fi = new FileImpl("FileServer");

Naming.rebind("//127.0.0.1/FileServer", fi);

} catch(Exception e) {

System.out.println("FileServer: "+e.getMessage());

e.printStackTrace();      }   }

}