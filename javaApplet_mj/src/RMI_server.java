import java.rmi.Naming;

public class RMI_server {
   public static void main(String[] args) {
      try {
         MyRemoteInterface remoteObj = (MyRemoteInterface) Naming.lookup("rmi://localhost/MyRemoteObject");
         String result = remoteObj.sayHello();
         System.out.println(result);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
 