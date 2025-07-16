/**
 * Abstraction means hiding complex implementation details and showing only relevant information to the user. Java achieves abstraction using:
 * - Abstract classes
 * - Interfaces
 */
public class Abstraction {

    public abstract static class Payment{
        public abstract void pay(double amount);
    }

    public static class CreditCardPayment extends Payment{

        @Override
        public void pay(double amount) {
            System.out.println("Paying " + amount + " using Credit Card.");
        }
    }

    public static class PayPalPayment extends Payment{

        @Override
        public void pay(double amount) {
            System.out.println("Paying " + amount + " using PayPal.");
        }
    }

    public static class PaymentProcessor{
        public static void main(String[] args){
            Payment creditCardPayment = new CreditCardPayment();
            creditCardPayment.pay(1000.0);
            Payment payPalPayment = new PayPalPayment();
            payPalPayment.pay(500.0);
        }
    }
}
