package mortgateCalculator;

import java.util.Scanner;

public class MortgageCalculator {
	
	public static double calculator(double principal, double interestRate, int period) {
		double mortgage=0;
		final byte months=12;
		final byte percentRate=100;
		//convert interest into percentage
		interestRate/=months*percentRate;
		
		//convert period to months
		period*=months;
		
		//formula for calculating mortgage
		double numerator=interestRate*Math.pow(1+interestRate, period);
		double denominator=Math.pow(1+interestRate, period)-1;
		mortgage=principal*(numerator/denominator);
		
		return mortgage;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		try {
			System.out.print("Principal:");
			double principal = input.nextDouble();
			
			System.out.print("Annual Interest Rate:");
			double interestRate = input.nextDouble();

			
			System.out.print("Period(Years):");
			int period = input.nextInt();

			
			//close input
			input.close();
			
			//print mortgage
			System.out.printf("Mortgage: $ %.2f", calculator(principal,interestRate,period));
		}catch(Exception e) {
			System.out.println("Something went wrong.");
		}
	}

}
