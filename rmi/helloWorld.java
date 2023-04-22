import java.rmi.*;

public interface helloWorld extends Remote{
    public String display() throws RemoteException; 
}