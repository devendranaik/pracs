import java.math.*;
import java.util.*;
public class RSA {
    public boolean intchck(double v) {
    	   double value=(double)v;
    	   if (value == Math.round(value)) {
    	       return true;
    	   	
    	   } else {
    		   return false;
    	   }    	
    } 
	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	double n,phin,e,p,q,pt,d,ct;
	RSA rsa=new RSA();
	System.out.println("Enter p");
    p=sc.nextDouble();
    System.out.println("Enter q");
    q=sc.nextDouble();
    
    System.out.println("Select e");
    e=sc.nextDouble();
    
    System.out.println("Enter plaintext");
    pt=sc.nextDouble();
    
    //Calculate n
    n=p*q;
    System.out.println("n is "+n);
    
    //calculate phi(n)
    phin=(p-1)*(q-1);
    System.out.println("phi(n) is"+phin);
    
    //calculate d
    boolean ch=false;
    int i=0;
    double val=0;
    while(!ch) {
    	i=i+1;
    	val=((phin*i)+1)/e;
    	ch=rsa.intchck(val);
    }
    d=val;
    System.out.println("d is"+d);
   
    //encryption
    ct=(Math.pow(pt, e))%n;
    System.out.println("Cipher text is"+ct);
   
    //decryption
    
    pt=(Math.pow(ct, d))%n;
    System.out.println("Plain text is"+pt);
    
  }

}
