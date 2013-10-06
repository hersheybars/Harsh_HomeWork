import java.util.Scanner;
class EX
{
    public static void main ( String[] args)
    {

    double smallValue = 1.0E-12 ; 
    Scanner scan = new Scanner( System.in );
    int count, num  ; 
    int n ;
    double sum, term, x, xx, priv_term, real_term ;
    long nfac;

    System.out.println("Enter the number:");
    x = scan.nextInt();

    n=1; // loop count
    term = 1  ;
    priv_term = 1;
    // n = x-1;
    sum = 1  ;
    while ( term > smallValue ) 
    {  
          nfac = factorial(n);
          System.out.println("priv_term is " + priv_term  );
          xx  = Math.pow(x,n) ;
          // term = priv_term * (xx/nfac);
          term =  xx/nfac ;
          sum  =  sum + term ;
          System.out.println("N is " + n  + " Term is " + term  + " The sum/prog_ex is " + sum + " xx/n is " + x/nfac);
          priv_term = term;
          n = n + 1 ;

    } 
    real_term = Math.exp(x); 
    System.out.println("This is Real from Math Class for comparison      " + real_term);
    } // End of the main

// Calculate Factorial
  
public static long factorial(int num) {
        long result = 1;
        if(num == 0) {
            return 1;
        }
        else {
            for(int i = 2; i <= num; i++) {
                result *= i;
            }
            return result;
        }
  }
} // #End of Ex

