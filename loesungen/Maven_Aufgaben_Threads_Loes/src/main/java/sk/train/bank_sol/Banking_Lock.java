package sk.train.bank_sol;

import java.util.concurrent.locks.ReentrantReadWriteLock;

class Konto // Konto
{
    private float balance; // Kontostand
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);

    public void setBalance(float balance)
    {
    	try {
			lock.writeLock().lock();
			this.balance = balance;
		} finally {
			lock.writeLock().unlock();
		}
    }

    public float getBalance()
    {
    	try {
			lock.readLock().lock();
			return balance;
		} finally {
			lock.readLock().unlock();
		}
    }
}

class MyBank
{
    private Konto[] account;

    public MyBank()
    {
        account = new Konto[100];
        for(int i = 0; i < account.length; i++)
        {
            account[i] = new Konto();
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

class Bucher extends Thread
{
    private MyBank bank;

    public Bucher(String name, MyBank bank)
    {
        super(name);
        this.bank = bank;
        start();
    }

    public void run()
    {
        for(int i = 0; i < 1000; i++)
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

public class Banking_Lock
{
    public static void main(String[] args)
    {
        MyBank myBank = new MyBank();
        new Bucher("Max Meister", myBank);
        new Bucher("Petra Mueller", myBank);
    }
}