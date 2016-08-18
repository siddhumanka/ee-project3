import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by user-2 on 14/8/16.
 */
public class LoanPayment {

    private static final Scanner CONSOLE = new Scanner(System.in);

    public static void main(String argv[]) throws FileNotFoundException {
        System.out.println("Project 3 written by Siddhartha ");
        //LoanPayment loanPayment = new LoanPayment();
        LoanPayment.printDetailedLoanTable(LoanPayment.printSimpleLoanTable());
    }

    private static void printDetailedLoanTable(PrintWriter printWriter) {
        System.out.println("\nDetailed Loan Table");
        System.out.println("Enter the initial Balance : ");
        double initialBalance = CONSOLE.nextDouble();
        System.out.println("Enter annual interest rate : ");
        double annualInterestRate = CONSOLE.nextDouble();
        System.out.println("Enter monthly payment : ");
        double monthlyPayment = CONSOLE.nextDouble();
        System.out.println("Enter number of months : ");
        int noOfMonths = CONSOLE.nextInt();
        printWriter.print("The initial loan is $"+initialBalance);
        printWriter.print("\n");
        printWriter.print("The monthly payment is $"+monthlyPayment);
        printWriter.print("\n");
        printWriter.print("The annual rate of interest is "+annualInterestRate+"%");
        printWriter.print("\n");
        printWriter.print("\n");
        printWriter.print("Month\t\tBalance\t\tPayment\t\tRemaining");
        printWriter.print("\n");
        for(int i=1;i<=noOfMonths;i++){
            initialBalance = (initialBalance + initialBalance*(annualInterestRate/1200));
            printWriter.print(i+"\t\t\t"+initialBalance+"\t\t\t"+monthlyPayment+"\t\t\t"+(initialBalance-monthlyPayment));
            initialBalance = initialBalance-monthlyPayment;
            printWriter.print("\n");
        }
        printWriter.close();
    }


    public static PrintWriter printSimpleLoanTable() throws FileNotFoundException {
        System.out.println("One Year Loan Table ");
        System.out.println("Enter the annual interest rate: ");
        PrintWriter printWriter = new PrintWriter(new File("LoanPaymentOutput.txt"));
        double interestRate = (CONSOLE.nextDouble())/100;
        printWriter.print("The initial loan is $1000.0\n");
        printWriter.print("The monthly payment is $50.0\n");
        printWriter.print("The annual interest rate is "+interestRate+"\n\n");
        printWriter.print("Simple Loan Payment Table For One Year\n\n");
        printWriter.print("Month\tBalance");
        printWriter.print("\n");
        double balance = 1000,payment = 50;

        for(int i=1;i<=12;i++){
            balance = (balance + balance*(interestRate/12))-payment;
            printWriter.print(i+"\t    "+balance);
            printWriter.print("\n");
        }
        return  printWriter;
    }
}
