import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class helloImp extends UnicastRemoteObject implements helloWorld {
    public helloImp() throws RemoteException{}
    public String display() throws RemoteException{
        return ("Hello Chaitra here from RMI server");
    }
}
