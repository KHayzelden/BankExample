
package banking.system;

public class Transaction 
{
    private final String customerID;
    private final int amount;
    
    public Transaction (String customerID, int amount)
    {
        this.customerID = customerID;
        this.amount = amount;
    }
    
    public String getCustomerID() 
    {
        return customerID;
    }

    public int getAmount() 
    {
        return amount;
    }
    
    @Override
    public String toString()
    {
        return  "[ Customer: " + customerID + ", " +
                "Amount: " + amount + " ]" ;
    }    
}
