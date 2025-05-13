package sk.train.bank;

class Account // Konto
{
    private float balance; // Kontostand

    public void setBalance(float balance)
    {
        if (balance < -5000) throw new IllegalArgumentException("Konto negativ");
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
        //todo: Array mit 100 Konten erzeugen
    }

    
   
    public void transferMoney(int accountNumber, float amount)
    {
    	//todo:
    	//den jetzigen Kontostand um den neuen Betrag (amount) erhöhen bzw. reduzieren
        
    }
}

class Clerk extends Thread
{
    private Bank bank;

    public Clerk(String name, Bank bank)
    {
        super(name);
        this.bank = bank;
        start();
    }

    public void run()
    {
        for(int i = 0; i < 10000; i++)
        {
            /* todo:
             * Kontonummer einlesen; simuliert durch
             * Wahl einer Zufallszahl zwischen 0 und 99
             */
            

            /*
             * Überweisungsbetrag einlesen; simuliert durch Wahl einer
             * Zufallszahl zwischen -500 und +499
             */
            

            /*
             * Betrag auf Konto transferieren
             */
        }
    }
}

public class Banking
{
    public static void main(String[] args)
    {
        Bank myBank = new Bank();
        new Clerk("Andrea Müller", myBank);
        new Clerk("Petra Schmitt", myBank);
    }
}