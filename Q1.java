import java.util.Scanner;

class Customer {
    protected double amount;

    public Customer(double amount) {
        this.amount = amount;
    }

    public double calculateAmount() {
        return amount;
    }
}

class Student extends Customer {
    public Student(double amount) {
        super(amount);
    }

    @Override
    public double calculateAmount() {
        return amount * 0.90;
    }
}

class Staff extends Customer {
    public Staff(double amount) {
        super(amount);
    }

    @Override
    public double calculateAmount() {
        return amount * 0.95;
    }
}

class Guest extends Customer {
    public Guest(double amount) {
        super(amount);
    }

    @Override
    public double calculateAmount() {
        return amount + 10;
    }
}

public class Q1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Name: Pritham M");

        int n = sc.nextInt();

        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double amount = sc.nextDouble();

            Customer customer;

            if (type.equals("STUDENT")) {
                customer = new Student(amount);
            } else if (type.equals("STAFF")) {
                customer = new Staff(amount);
            } else {
                customer = new Guest(amount);
            }

            double finalAmount = customer.calculateAmount();

            System.out.printf("%s: %.2f%n", type, finalAmount);

            total = total + finalAmount;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}