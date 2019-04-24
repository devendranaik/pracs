import java.util.*;
import java.math.*;
public class Diff_HMn {

	public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
      double alpha,p,pua,pub,pra,prb,Ka,Kb;
      
      System.out.println("Enter value of q");
      p=sc.nextDouble();
      
      System.out.println("Enter value of alpha");
      alpha=sc.nextDouble();
      
      System.out.println("Enter public key of a");
      pua=sc.nextDouble();
      
      System.out.println("Enter public key of b");
      pub=sc.nextDouble();
      
      //Calculating  private for A
      pra=Math.pow(alpha, pua)%p;
    
      //Calculating   private for B
      prb=Math.pow(alpha, pub)%p;
      
      System.out.println("Private key of A is"+pra);
      System.out.println("Private key of B is"+prb);
      
      //Calculating secret key at A
          Ka=Math.pow(prb, pua)%p;                     
      //Calculating secret key at B
          Kb=Math.pow(pra, pub)%p;
          System.out.println("Ka and Kb is"+Ka+" "+Kb);
          if(Ka==Kb) {
        	  System.out.println("Key is exchanged sucessfully");
          }
          else System.out.println("not same");
	}

}
