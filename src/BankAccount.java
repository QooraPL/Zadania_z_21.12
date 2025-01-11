class NotEnoughMoneyException extends RuntimeException {
    public NotEnoughMoneyException(String message) {
        super(message);
    }
}

class Account {
    private String owner;
    private int balance;
    private String accountNumber;

    public Account(String owner, int balance, String accountNumber) {
        this.owner = owner;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public void transfer(int amount) {
        if (amount > balance) {
            throw new NotEnoughMoneyException("Brak wystarczajacych srodkow! Saldo: " + balance);
        }
        balance -= amount;
        System.out.println("Przelano kwote: " + amount + " zl. Nowe saldo: " + balance);
    }

    public int getBalance() {
        return balance;
    }
}

public class BankAccount {
    public static void main(String[] args) {
        Account account = new Account("Eryk Nowaczewski", 1000, "947209753");

        try {
            account.transfer(255);
            account.transfer(1234);
        } catch (NotEnoughMoneyException e) {
            System.out.println("Blad: " + e.getMessage());
        } finally {
            System.out.println("Saldo koncowe: " + account.getBalance() + " zl.");
        }
    }
}
