
package banking.system;

import java.util.Random;

public class Parent implements Runnable  //implements runnable so it may be made into a thread in the main
{
    private String names;
    private CurrentAccount account;
    
    public String threadGroup;
    
    public Parent (String names, CurrentAccount account)
    {
        this.names = names;
        this.account = account;
    }
    
    @Override
    public void run ()
    {
        System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                            "TYPE   : Parents\n" +
                            "NAME   : " + this.names + "\n" +
                            "GROUP  : "  + this.threadGroup + "\n" +
                            "STATUS : Thread Started\n" +
                            "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        
        // deposits money three times to mock parents giving gifts
        
        try
        {
            Thread.sleep(randomTime()); //sleep is for a randomly determined time in the function below
            
            Transaction givePresent = new Transaction(this.names, 500);
            account.deposit(givePresent);

            Thread.sleep(randomTime());

            Transaction spendingMoney = new Transaction(this.names, 100);
            account.deposit(spendingMoney);

        }
        catch (InterruptedException e)
        {
            System.out.println("catch triggered");
        } 
        
        System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                            "TYPE   : Parents\n" +
                            "NAME   : " + this.names + "\n" +
                            "GROUP  : "  + this.threadGroup + "\n" +
                            "STATUS : Thread Endend\n" +
                            "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
    
    //generates a random time between 1 and 5 seconds
    private int randomTime()
    {
        Random r = new Random();
        int min = 1;
        int max = 5;
        return (r.nextInt((max - min) + 1) + min) * 1000;    
    }
}
