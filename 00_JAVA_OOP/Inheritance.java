/**
 * Inheritance lets one class acquire fields and methods of another class.
 */
class Inheritance {
    public abstract static class Account {
        protected String accountNumber;
        protected double balance;

        public Account(String accountNumber, double balance) {
            this.accountNumber = accountNumber;
            this.balance = balance;
        }

        public void deposit(double amount) {
            balance += amount;
        }

        public boolean withdraw(double amount) {
            if (amount > balance) return false;
            balance -= amount;
            return true;
        }

        public double getBalance() {
            return balance;
        }
    }

    public static class SavingsAccount extends Account {
        private final double interestRate;

        public SavingsAccount(String accountNumber, double balance, double interestRate) {
            super(accountNumber, balance);
            this.interestRate = interestRate;
        }

        public void addInterest() {
            balance += balance * interestRate;
        }
    }

    public static class CheckingAccount extends Account {
        private final double overdraftLimit;

        public CheckingAccount(String accountNumber, double balance, double overdraftLimit) {
            super(accountNumber, balance);
            this.overdraftLimit = overdraftLimit;
        }

        @Override
        public boolean withdraw(double amount) {
            if (amount > balance + overdraftLimit) return false;
            balance -= amount;
            return true;
        }
    }
}

