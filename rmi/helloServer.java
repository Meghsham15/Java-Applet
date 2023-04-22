import java.rmi.*;
import java.net.*;
import java.io.*;

public class helloServer {
    public static void main(String args[]){
        try{
            helloImp localObj = new helloImp();
            Naming.rebind("rmi:///helloWorld", localObj);
        }catch(RemoteException re){
            re.printStackTrace();
        }catch(MalformedURLException mfe){
            mfe.printStackTrace();
        }
    }
}
