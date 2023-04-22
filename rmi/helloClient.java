import java.rmi.*;
import java.net.*;
import java.io.*;


public class helloClient {
    public static void main(String args[]){
        try{
            String host = "localhost";
            helloWorld remoObject = (helloWorld)Naming.lookup("rmi://"+host+"/helloWorld");
            System.out.println(remoObject.display());
        }catch(RemoteException re){
            re.printStackTrace();
        }catch(NotBoundException nbe){
            nbe.printStackTrace();
        }catch(MalformedURLException mfe){
            mfe.printStackTrace();
        }
    }
}
