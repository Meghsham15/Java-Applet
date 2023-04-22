import java.rmi.Remote;
import java.rmi.RemoteException;

//Creating Remote Interface for our application 
public interface Hello extends Remote {
   void printMsg(int n) throws RemoteException;
}
