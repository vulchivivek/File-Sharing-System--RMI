 import java.rmi.Remote;

import java.rmi.RemoteException;

public interface FileInterface extends Remote {

public byte[] downloadFile(String fileName) throws   RemoteException ; 
public byte[] uploadFile(String fileName, byte[] filedata) throws   RemoteException ; 
public String getdir(String fileName) throws   RemoteException ; 
public String makedir(String fileName) throws   RemoteException ; 
public String removedir(String fileName) throws   RemoteException ;
public String removefile(String fileName) throws   RemoteException ;
public String servershutdown() throws   RemoteException ;
}