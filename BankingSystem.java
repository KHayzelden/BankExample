
package banking.system;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BankingSystem 
{
    public static void main(String[] args) 
    {
        String studentName = "Kris Hayzelden";
        String parentsNames = "The Hayzeldens";
        String loanCompanyName = "Student Finance";
        String universityName = "U. of Westminster";
        
        int accountNumber = Integer.parseInt("1945056"); //random
        
        // creates the current account with the set details
        
        CurrentAccount account = new CurrentAccount (studentName, accountNumber);
        
        ThreadGroup human = new ThreadGroup("Human");
        ThreadGroup automated = new ThreadGroup("Automated");
        
        // creates an instance of each object then implements it as the thread
        // as they are all runnable, then adds the thread version to the
        // approperiate thread group
        
        Student student = new Student (studentName, account);
        Thread studentThread = new Thread(human, student);
        student.threadGroup = studentThread.getThreadGroup().getName();
        
        Parent parent = new Parent(parentsNames, account);
        Thread parentThread = new Thread(human, parent);
        parent.threadGroup = parentThread.getThreadGroup().getName();
        
        LoanCompany loanCompany = new LoanCompany(loanCompanyName, account);
        Thread loanCompanyThread = new Thread(automated, loanCompany);
        loanCompany.threadGroup = loanCompanyThread.getThreadGroup().getName();
        
        University university = new University(universityName, account);
        Thread universityThread = new Thread(automated, university);
        university.threadGroup = universityThread.getThreadGroup().getName();
        
        studentThread.start();
        parentThread.start();
        loanCompanyThread.start();
        universityThread.start();
        
        // joins the threads together to ensure that the final statement is only 
        // printed once when all the threads are finally completed
        try 
        {
            studentThread.join();
            parentThread.join();
            universityThread.join();
            loanCompanyThread.join();
            
        } 
        catch (InterruptedException ex) 
        {
            System.out.println("join failed");
        }
        
        account.printStatement();
    }
}