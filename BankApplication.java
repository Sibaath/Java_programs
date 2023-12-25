
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " deposited: " + amount);
        notify();
    }
    public synchronized void withdraw(double amount) {
        while (balance < amount) {
            try {
                System.out.println(Thread.currentThread().getName() + " waiting for funds...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        balance -= amount;
        System.out.println(Thread.currentThread().getName() + " withdrew: " + amount);
    }
    public synchronized double checkBalance() {
        return balance;
    }
}

class TransactionThread extends Thread {
    private BankAccount account;

    public TransactionThread(BankAccount account, String name) {
        super(name);
        this.account = account;
    }

    @Override
    public void run() {
        account.deposit(100.0);
        account.withdraw(50.0);
        System.out.println(Thread.currentThread().getName() + " current balance: " + account.checkBalance());
    }
}

public class BankApplication {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(500.0);
        Thread thread1 = new TransactionThread(account, "Thread 1");
        Thread thread2 = new TransactionThread(account, "Thread 2");

        thread1.start();
        thread2.start();
    }
}