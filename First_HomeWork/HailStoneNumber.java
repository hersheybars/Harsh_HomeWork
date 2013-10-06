 import java.util.Scanner;

 class HailStoneNumber {
	 public static void main(String[] args) {
	Scanner scan = new Scanner( System.in );
	int num, remainder;
		System.out.println("Enter the number:");
		num = scan.nextInt();
		System.out.println("You Entered:" + num);

		while ( num  > 1 )
		{ 
		  remainder = num % 2 ;
		  if ( remainder == 0 )
		  {
			   num = num / 2;
		           System.out.println("Number was even now:" + num);
		  }     
	          else
		  { 
			   num = num * 3 + 1;
		           System.out.println("Number was odd now:" + num);
	           }

		           System.out.println("Fianlly number is:" + num);


                 }
 }
 }
