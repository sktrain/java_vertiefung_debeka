package sk.train.bank_sol;

class Account // Konto
{
    private float balance; // Kontostand

    public void setBalance(float balance)
    {
        this.balance = balance;
    }

    public float getBalance()
    {
        return balance;
    }
}

class Bank
{
    private Account[] account;

    public Bank()
    {
        account = new Account[100];
        for(int i = 0; i < account.length; i++)
        {
            account[i] = new Account();
        }
    }

    
//    public synchronized void transferMoney(int accountNumber, float amount)
//    {
//        float oldBalance = account[accountNumber].getBalance();
//        float newBalance = oldBalance + amount;
//        account[accountNumber].setBalance(newBalance);
//    }
    
    public void transferMoney(int accountNumber, float amount)
    {
        synchronized(account[accountNumber])
        {
            float oldBalance = account[accountNumber].getBalance();
            float newBalance = oldBalance + amount;
            account[accountNumber].setBalance(newBalance);
        }
    }
}

class Clerk extends Thread
{
    private MyBank bank;

    public Clerk(String name, MyBank bank)
    {
        super(name);
        this.bank = bank;
        start();
    }

    public void run()
    {
        for(int i = 0; i < 10000; i++)
        {
            /*
             * Kontonummer einlesen; simuliert durch
             * Wahl einer Zufallszahl zwischen 0 und 99
             */
            int accountNumber = (int) (Math.random() * 100);

            /*
             * Überweisungsbetrag einlesen; simuliert durch Wahl einer
             * Zufallszahl zwischen -500 und +499
             */
            float amount = (int) (Math.random() * 1000) - 500;

            bank.transferMoney(accountNumber, amount);
            System.out.println(getName()+": Transfer von "+amount+" auf Konto " + accountNumber);
        }
    }
}

public class Banking
{
    public static void main(String[] args)
    {
        MyBank myBank = new MyBank();
        new Clerk("Andrea Müller", myBank);
        new Clerk("Petra Schmitt", myBank);
    }
}