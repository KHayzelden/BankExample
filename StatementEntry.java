
package banking.system;

public class StatementEntry 
{
    private final char TAB = '\t' ;

    private final String CustomerID ;
    private final int    amount ;
    private final int    currentBal ;

    public StatementEntry( String CID, int amount, int currentBal )
    {
        this.CustomerID = CID ;
        this.amount     = amount ;
        this.currentBal = currentBal ;
        
        System.out.println(this.toString());
    }

    public String getCustomer()      { return CustomerID ; }
    public int    getAmount()        { return amount ; }
    public int    getCurrentBalance(){ return currentBal ; }
    
    public String toString( )
    {
        return  "Customer: " + CustomerID + ","  + TAB + 
                "Amount: "   + amount     + ", " + TAB + 
                "Balance: "  + currentBal;
    }

}
