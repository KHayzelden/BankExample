
package banking.system;

import java.util.Random;

public class CurrentAccount implements BankAccount 
{
    private int balance;
    private final int accountNumber;
    private final String accountHolder;
    private Statement statement;
    
    CurrentAccount (String accountHolder, int accountNumber)
    {
        this.balance = 0; // ensures the balance is 0 on creation
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.statement = new Statement(this.accountHolder, this.accountNumber);
    }
    
    //--------------------------------------//
    
    @Override
    public int getBalance( )
    {
        return this.balance;
    }
    
    @Override
    public int getAccountNumber()
    {
        return this.accountNumber;
    }
    
    @Override
    public String getAccountHolder()
    {
        return this.accountHolder;
    }
    
    //--------------------------------------//
    
    @Override
    public synchronized void deposit (Transaction t)
    {
        this.balance += t.getAmount();
        
        statement.addTransaction(t.getCustomerID(), t.getAmount(), this.balance);
        
        this.notifyAll();
    }
    
    @Override
    public synchronized void withdrawal (Transaction t)
    {
        //addition as the t.getamount for a withdrawl will alreday be negative

        try
        {
            while (wouldBeOverdrawn(t))
            {
                System.out.println("*** Insufficent Funds: "+ (t.getAmount()* -1) + " needed for " + t.getCustomerID());
                
                //will print the failure to withdraw for the customer then goes back to wait for funds
                
                this.wait(); 
            }
           
            this.balance += t.getAmount() ;
            
            statement.addTransaction(t.getCustomerID(), t.getAmount(), this.balance);
            
        }
        catch (InterruptedException e)
        {
            System.out.println("u messed up bro");
        }
    }
    
    //--------------------------------------//
    
    @Override
    public boolean wouldBeOverdrawn(Transaction t) // changed to accept transaction as it needs context to know
    {
        return ((this.balance + t.getAmount()) < 0);
    }
    
    @Override
    public void printStatement()
    {
        statement.print();
    }
}