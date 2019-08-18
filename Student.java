
package banking.system;

import java.util.Random;

public class Student implements Runnable  //implements runnable so it may be made into a thread in the main
{
    private String name;
    private CurrentAccount account;
    
    public String threadGroup;
    
    public Student (String name, CurrentAccount account)
    {
        this.name = name;
        this.account = account;
    }

    @Override
    public void run ()
    {
        System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                            "TYPE   : Student\n" +
                            "NAME   : " + this.name + "\n" +
                            "GROUP  : "  + this.threadGroup + "\n" +
                            "STATUS : Thread Started\n" +
                            "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        
        // deposits or withdraws money six random times to mock a student interacting with their account
        
        try
        {
            Thread.sleep(randomTime()); //sleep is for a randomly determined time in the function below
            
            Transaction winLottery = new Transaction(this.name, 1500);
            account.deposit(winLottery);

            Thread.sleep(randomTime());

            Transaction buyIphone = new Transaction(this.name, -600);
            account.withdrawal(buyIphone);

            Thread.sleep(randomTime());

            Transaction buyGroceries = new Transaction(this.name, -100);
            account.withdrawal(buyGroceries);
            
            Thread.sleep(randomTime());

            Transaction buyComputer = new Transaction(this.name, -1000);
            account.withdrawal(buyComputer);

            Thread.sleep(randomTime());

            Transaction winAward = new Transaction(this.name, 50);
            account.deposit(winAward);
      
            Thread.sleep(randomTime());

            Transaction buyBooks = new Transaction(this.name, -400);
            account.withdrawal(buyBooks);

        }
        catch (InterruptedException e)
        {
            System.out.println("catch triggered");
        } 

        System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                            "TYPE   : Student\n" +
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
