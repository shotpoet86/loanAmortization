/*Programmer: Austin Parker
 * Assignment: PE 5.22 // Ch.5 // Loan Amortization
 * Date: June 14, 2020
 * Description: Displays the schedule of loan amortization for given loan*/

import java.util.Scanner;


public class loanAmortization {
    public static void main(String[] args) {
        //Declared variables
        int numOfYears;
        double annualInterest;
        double monthlyInterest;
        double loanAmount;
        double balance;
        double interest;
        double principal;
        double monthlyPayment;

        //scanner function
        Scanner input = new Scanner(System.in);

        //user input for loan amount
        System.out.print("Loan Amount: ");

        //read user loan input
        loanAmount = input.nextDouble();

        //input user info for num of years
        System.out.print("Number of years: ");

        //read user loan input for years
        numOfYears = input.nextInt();

        //user input for loan interest rate annual
        System.out.print("Loan annual interest rate: ");

        //read user loan input for rate
        annualInterest = input.nextDouble();

        //calculate monthly interest rate
        monthlyInterest = annualInterest / 1200;

        //calculate monthly payment
        monthlyPayment = loanAmount * monthlyInterest /
                (1 - (Math.pow(1 / (1 + monthlyInterest), numOfYears * 12)));
        balance = loanAmount;

        //display monthly and total payment
        System.out.println();
        System.out.println("Monthly payment: " + (int) (monthlyPayment * 100) / 100.0);
        System.out.println("Total payment: " + (int) (monthlyPayment * 12 * numOfYears * 100) / 100.0 + "\n");

        //display for divided columns
        System.out.println("Payment#\tInterest\tPrincipal\tBalance");

        //loop for calculating information after each payment is displayed
        int i;
        for (i = 1; i <= numOfYears * 12; i++) {
            interest = (int) (monthlyInterest * balance * 100) / 100.0;
            principal = (int) ((monthlyPayment - interest) * 100) / 100.0;
            balance = (int) ((balance - principal) * 100) / 100.0;

            //Prevents negative balance
            if (balance < 0) {
                balance = 0.00;
            }

            //prints out the results of loan amortization
            System.out.println("\t" + i + "\t\t" + String.format("%.2f", interest) + "\t\t" + String.format("%.2f", principal) + "\t\t" + String.format("%.2f", balance));
        }

    }
}
