
package banking.system;

import java.util.Random;

public class LoanCompany implements Runnable //implements runnable so it may be made into a thread in the main
{
    private String name;
    private CurrentAccount account;
    
    public String threadGroup;

    public LoanCompany (String name, CurrentAccount account)
    {
        this.name = name;
        this.account = account;
    }
    
    @Override
    public void run()
    {
        System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                            "TYPE   : Loan Company\n" +
                            "NAME   : " + this.name + "\n" +
                            "GROUP  : "  + this.threadGroup + "\n" +
                            "STATUS : Thread Started\n" +
                            "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // deposits £3000 three times to mock student fudning
        
        try
        {
            Transaction loan = new Transaction(this.name, 3000);

            Thread.sleep(randomTime()); //sleep is for a randomly determined time in the function below
            
            account.deposit(loan);

            Thread.sleep(randomTime());
            
            account.deposit(loan);

            Thread.sleep(randomTime());
            
            account.deposit(loan); 
        }
        catch (InterruptedException e)
        {
            System.out.println("catch triggered");
        } 

        System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                            "TYPE   : Loan Company\n" +
                            "NAME   : " + this.name + "\n" +
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
