import java.io.*;

import java.rmi.*;

import java.rmi.server.UnicastRemoteObject;

public class FileImpl extends UnicastRemoteObject

implements FileInterface {

private String name;

public FileImpl(String s) throws RemoteException{

super();

name = s;   }


//dowload
public byte[] downloadFile(String fileName){

try {

File file = new File(fileName);

byte buffer[] = new byte[(int)file.length()];

BufferedInputStream input = new

BufferedInputStream(new FileInputStream(fileName));

input.read(buffer,0,buffer.length);

input.close();

return(buffer);

} catch(Exception e){

System.out.println("FileImpl: "+e.getMessage());

e.printStackTrace();

return(null);      }   
}

//upload
public byte[] uploadFile(String fileName,byte[] filedata){
try{

File file = new File(fileName);

BufferedOutputStream output = new

BufferedOutputStream(new FileOutputStream(file.getName()));

output.write(filedata,0,filedata.length);

output.flush();

output.close();
return(null);
}
catch(Exception e){

System.out.println("FileImpl: "+e.getMessage());

e.printStackTrace();  return(null);   }   
}

//get directories
public String getdir(String name){
try{
File folder = new File(name);
	if(folder.exists()){
	File[] listOfFiles = folder.listFiles();
	String list="";
	

   	 for (int i = 0; i < listOfFiles.length; i++) {
      	if (listOfFiles[i].isFile()) {
       // System.out.println("File " + listOfFiles[i].getName());
	list+=listOfFiles[i].getName()+"  ";
      } else if (listOfFiles[i].isDirectory()) {
        //System.out.println("Directory " + listOfFiles[i].getName());
	list+=listOfFiles[i].getName()+" ";
      }
}
return(list);}
else return("Error:003 - Requested directory does not exist");
}
catch(Exception e){

System.out.println("FileImpl: "+e.getMessage());

e.printStackTrace();  return(null);   } 
}


//create new directory
public String makedir(String part2){
try{
	File file = new File(part2);
        if (!file.exists()) {
            if (file.mkdir()) {
              return("Error 0- Directory is created on server: " + '\n');
            } else {
              return("Error0xxx005:: Directory is not created on server: " + '\n');
            }
        }
	else{
		return("Error0xxx005:: Directory is not created on server: " + '\n');
	}
}
catch(Exception e){

System.out.println("FileImpl: "+e.getMessage());

e.printStackTrace();  return(null);   } 
}

//remove a dirctory
public String removedir(String part2){
try{
	File file = new File(part2);
        if (file.isDirectory()) {
            if (file.delete()) {
               return("Error 0- Directory is removed on server: " + '\n');
            } else {
               return("Error 0xxx007:: unable to remove directory on server: " + '\n');
            }
        }
	else{
		return("Error0xxx006:: Directory is not present on server: " + '\n');
	}
}
catch(Exception e){

System.out.println("FileImpl: "+e.getMessage());

e.printStackTrace();  return(null);   } 
}

// remove a file from server
public String removefile(String part2){
try{
		File file = new File(part2);
            if (file.delete()) {
              return("Error 0- File is removed on server: " + '\n');
            } else {
              return("Error 0xxx008:: unable to remove file on server: " + '\n');
            }
}
catch(Exception e){

System.out.println("FileImpl: "+e.getMessage());

e.printStackTrace();  return(null);   } 
}

//server shutdown
public String servershutdown(){
try{
  UnicastRemoteObject.unexportObject(this, true);

return("Server shutdown successfully"+"\n");
}
catch(Exception e){

System.out.println("FileImpl: "+e.getMessage());

e.printStackTrace();  return(null);   } 
}


}