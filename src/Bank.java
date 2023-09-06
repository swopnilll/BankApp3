import java.util.Scanner;

class Account {
    private String type;
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean hasAmount(double amount) {
        return !(amount < this.balance);
    }

    public boolean deposit(double amount) {
        if(amount > 0){
            this.balance = this.balance + amount;

            return true;
        }else {
            System.out.println("Deposit Amount Invalid");
            System.out.println("Amount should be greater than 0");

            return false;
        }

    }

    public void withdraw(double amount) {
        if (this.hasAmount(amount)) {
            System.out.println("Insufficient Balance");
            return;
        }

        this.balance = this.balance - amount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "type='" + type + '\'' +
                ", balance=" + balance +
                '}';
    }
}

public class Bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char value;
        float amount;

        Account myAcc = new Account(1000);

        System.out.println("Welcome to Sydney International Bank");
        System.out.println("Start banking (d/w/s/x):");

        do {
            value = sc.next().charAt(0);

            switch (value) {
                case 'd':
                    System.out.println("Enter the amount you want to deposit");
                    amount = sc.nextFloat();
                    System.out.println("Amount to deposit: $" + amount);
                    if(myAcc.deposit(amount)){
                        System.out.println("Amount deposited: $" + amount);
                    }
                    break;

                case 'w':
                    System.out.println("Enter the amount you want to withdraw");
                    amount = sc.nextFloat();
                    myAcc.withdraw(amount);
                    System.out.println("Amount withdrawn: $" + amount);
                    break;

                case 's':
                    System.out.println("Current balance: $" + myAcc.getBalance());
                    break;
            }

            System.out.println("Continue banking (d/w/s/x):");

        } while (value != 'x');

        System.out.println("Thank you for using our service");
    }
}
