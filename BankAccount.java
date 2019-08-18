
package banking.system;

public interface BankAccount 
{
    public int getBalance( ) ;           // returns the current balance

    public int getAccountNumber( ) ;     // returns the Account number

    public String getAccountHolder( ) ;     // returns the Account holder


    public void deposit( Transaction t ) ;     // perform a deposit transaction on the bank account

    public void withdrawal( Transaction t ) ;  // perform a withdrawal transaction on the bank account

    
    public boolean wouldBeOverdrawn( Transaction t) ;   // returns true if overdrawn; false otherwise

    public void printStatement( ) ;         // prints out the transactions performed so far
}
