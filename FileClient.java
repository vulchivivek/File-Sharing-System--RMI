import java.io.*;

import java.rmi.*;

public class FileClient{

public static void main(String argv[]) {



try {
String env = System.getenv("PA1_SERVER");
	//System.out.println(env);
	String[] parts = env.split(":");
	String SERVER = parts[0]; // computername
String name = "//" + SERVER + "/FileServer";
FileInterface fi = (FileInterface) Naming.lookup(name);

//rmi- download
if(argv[0].equals("download")){




byte[] filedata = fi.downloadFile(argv[1]);


String newname = argv[2];

File file = new File(newname);
	//resume download
	File f=new File(argv[2]);
	long fs=0;
	if(f.exists()) fs=f.length();

BufferedOutputStream output = new

BufferedOutputStream(new FileOutputStream(file.getName()));

output.write(filedata,0,filedata.length);

output.flush();
	System.out.print("      downloaded 	...");
for (int m=0;m<=100;m++){ System.out.print("\r"+m+"%");  Thread.sleep(30);}
System.out.println("\nError 00: No problem found");
output.close();
}

//rmi- upload
if(argv[0].equals("upload")){

String fileName = argv[1];
File file = new File(fileName);
byte buffer[] = new byte[(int)file.length()];
BufferedInputStream input = new BufferedInputStream(new FileInputStream(fileName));

input.read(buffer,0,buffer.length);

input.close();
	System.out.print("     uploaded 	...");
	for (int m=0;m<=100;m++){ System.out.print("\r"+m+"%");  Thread.sleep(30);}
	System.out.println();
	     System.out.println("File " + fileName
          + " uploaded");
		System.out.println("Error 0- NO ERROR");

byte[] a=fi.uploadFile(argv[2],buffer);


}

if(argv[0].equals("dir")){


String listOfFiles =fi.getdir(argv[1]);
if(!listOfFiles.equals("Error:003 - Requested directory does not exist")){
	System.out.println("Error 0- NO ERROR");
	File file = new File(argv[1]);
	String parentPath = file.getAbsoluteFile().getParent();
	System.out.print(parentPath+" ");
	System.out.println(listOfFiles);
}
else System.out.println(listOfFiles);
}

	//making a new directory on server file system
	if(argv[0].equals("mkdir")){

	String str = fi.makedir(argv[1]);
	System.out.println(str+" "+"\n");
	}


	//removing a directory on server file system
	if(argv[0].equals("rmdir")){

	String str = fi.removedir(argv[1]);
	System.out.println(str+" "+ "\n");
	}

	//removing a file on server file system
	if(argv[0].equals("rm")){

	String str = fi.removefile(argv[1]);
	System.out.println(str+" "+ argv[1]);
	}


	//shutdown server file system
	if(argv[0].equals("shutdown")){

	String str = fi.servershutdown();
	System.out.println(str);
	}
	

} catch(Exception e) {

System.err.println("FileServer exception: "+ e.getMessage());

e.printStackTrace();      }   }}