//Implementing the remote interface 
public class ImplExample implements Hello {

    // Implementing the interface method 
    public void printMsg(int n) {
  
    int temp,r,sum=0;
  temp=n;
    while(n>0){
     r=n%10;  //getting remainder
     sum=(sum*10)+r;
     n=n/10;
    }
  System.out.println("Meghsham Jade");
    if(temp==sum)
     System.out.println("NUMBER IS PALINDROME"); 
    else
     System.out.println("NUMBER IS NOT PALINDROME");
  //System.out.println("This is an example MI program");
   }
  }
  