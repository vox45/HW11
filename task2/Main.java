import java.util.HashMap;
import java.util.Map;

class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private boolean isLocked;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.isLocked = false;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void deposit(double amount) {
        if (!isLocked) {
            balance += amount;
            System.out.println("Deposit successful. New balance: " + balance);
        } else {
            System.out.println("Account is locked. Cannot deposit.");
        }
    }

    public void withdraw(double amount) {
        if (!isLocked) {
            if (balance >= amount) {
                balance -= amount;
                System.out.println("Withdrawal successful. New balance: " + balance);
            } else {
                System.out.println("Insufficient funds.");
            }
        } else {
            System.out.println("Account is locked. Cannot withdraw.");
        }
    }

    public void transfer(BankAccount recipient, double amount) {
        if (!isLocked && !recipient.isLocked) {
            if (balance >= amount) {
                balance -= amount;
                recipient.deposit(amount);
                System.out.println("Transfer successful. New balance: " + balance);
            } else {
                System.out.println("Insufficient funds for transfer.");
            }
        } else {
            System.out.println("One or both accounts are locked. Cannot transfer.");
        }
    }

    public void lockAccount() {
        isLocked = true;
        System.out.println("Account locked.");
    }

    public void unlockAccount() {
        isLocked = false;
        System.out.println("Account unlocked.");
    }
}

class Bank {
    private Map<String, BankAccount> accounts;

    public Bank() {
        this.accounts = new HashMap<>();
    }

    public BankAccount createAccount(String accountNumber, String accountHolder, double initialBalance) {
        BankAccount account = new BankAccount(accountNumber, accountHolder, initialBalance);
        accounts.put(accountNumber, account);
        return account;
    }

    public BankAccount getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }
}

public class Main {
    public static void main(String[] args) {
        // Створення банку
        Bank bank = new Bank();

        // Створення рахунку
        BankAccount account1 = bank.createAccount("123456", "John Doe", 1000);

        // Зняття грошей та перевірка балансу
        account1.withdraw(500);
        System.out.println("Current balance: " + account1.getBalance());

        // Переведення грошей на інший рахунок
        BankAccount account2 = bank.createAccount("789012", "Jane Doe", 500);
        account1.transfer(account2, 300);

        // Блокування та розблокування рахунку
        account1.lockAccount();
        account1.withdraw(200);  // Не відбудеться через заблокований рахунок
        account1.unlockAccount();
        account1.withdraw(200);  // Тепер відбудеться

        // Отримання інформації про рахунок через банк
        BankAccount retrievedAccount = bank.getAccount("123456");
        System.out.println("Retrieved account information: " + retrievedAccount.toString());
    }
}
