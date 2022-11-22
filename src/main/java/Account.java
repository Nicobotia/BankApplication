import java.util.Scanner;

public class Account implements Accountable{

    //Instance variables
    private int balance;
    private int previousTransaction;
    String customerName;
    String customerID;

    //Class constructor
    public Account (String cname, String cid){
        this.customerName = cname;
        this.customerID = cid;
    }

    //Method for Depositing Money
    public void deposit (int amount){
        if (amount != 0){
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    //Method for Withdrawing Money
    public void withdraw(int amount){
        if (amount != 0){
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    //Method showing the previous transaction
    public void getPreviousTransaction(){
        if (previousTransaction > 0){
            System.out.println("Deposited: " + previousTransaction);
        } else if ( previousTransaction < 0 ){
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction occurred");
        }
    }

    //Method to calculate interest of current funds after number of years
    public void calculateInterest (int years){
        double interestRate = 0.0274;
        double newBalance = (balance * interestRate * years) + balance;
        System.out.println("The current interest rate is " + (100 * interestRate) + "%");
        System.out.println("After " + years + " years, your balance will be: " + newBalance);
    }

    //Method for the Main Menu
    public void showMenu() {
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWelcome, " + customerName + "!");
        System.out.println("Your ID is: " + customerID);
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println("A. Check your balance");
        System.out.println("B. Make a deposit");
        System.out.println("C. Make a withdrawal");
        System.out.println("D. View previous transaction");
        System.out.println("E. Calculate interest");
        System.out.println("F. Exit");

        do {
            System.out.println();
            System.out.println("Enter an option: ");
            char optionOne = scanner.next().charAt(0);
            option = Character.toUpperCase(optionOne);
            System.out.println();

            switch (option) {
                //Case 'A' allows the user to check their account balance
                case 'A':
                    System.out.println("==============================");
                    System.out.println("Balance = $" + balance);
                    System.out.println("==============================");
                    System.out.println();
                    break;
                // Case 'B' allows the user to deposit money into their account
                case 'B':
                    System.out.println("Enter amount to deposit: ");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println();
                    break;
                // Case 'C' allows the user to withdraw money from their account
                case 'C':
                    System.out.println("Enter amount to withdraw: ");
                    int amountTwo = scanner.nextInt();
                    withdraw(amountTwo);
                    System.out.println();
                    break;
                // Case 'D' allows the user to view the most recent transaction made
                case 'D':
                    System.out.println("==============================");
                    getPreviousTransaction();
                    System.out.println("==============================");
                    System.out.println();
                    break;
                // Case 'E' allows user to calculate accrued interest when they input years
                case 'E':
                    System.out.println("Enter how many years of accrued interest: ");
                    int years = scanner.nextInt();
                    calculateInterest(years);
                    break;
                // Case 'F' exits the user from their account
                case 'F':
                    System.out.println("==============================");
                    break;
                // The default case lets the user know that they entered an invalid character
                default:
                    System.out.println("Error: invalid option. Please enter A, B, C, D, or E or access services.");
                    break;
            }

        } while (option != 'F');
            System.out.println("Thank you for banking with us!");
        }

    @Override
    public int getBalance() {
        return 0;
    }
}
