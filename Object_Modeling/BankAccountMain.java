import java.util.*;

class Bank {
    String bankName;
    ArrayList<Customer> customers = new ArrayList<>();

    Bank(String bankName) {
        this.bankName = bankName;
    }

    void openAccount(Customer c, double amount) {
        c.accountBalance += amount;
        customers.add(c);
    }

    void showCustomers() {
        for (Customer c : customers) {
            System.out.println(c.name + " Balance: " + c.accountBalance);
        }
    }
}

class Customer {
    String name;
    double accountBalance;

    Customer(String name) {
        this.name = name;
        this.accountBalance = 0;
    }

    void viewBalance() {
        System.out.println(name + " Balance: " + accountBalance);
    }
}

public class BankAccountMain {
    public static void main(String[] args) {
        Bank b = new Bank("State Bank of India");

        Customer c1 = new Customer("Shubham");
        Customer c2 = new Customer("Aman");

        b.openAccount(c1, 1000);
        b.openAccount(c2, 2500);

        c1.viewBalance();
        c2.viewBalance();
        b.showCustomers();
    }
}
