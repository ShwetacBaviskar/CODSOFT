import java.util.Scanner;

public class Transaction{
    static void withdraw(){
        Scanner sc=new Scanner(System.in);
        System.out.println("----------------");
        System.out.println("Enter amount to withdraw :");
        int wcash=sc.nextInt();
        if(wcash<=ATM.balance){
            ATM.balance=ATM.balance-wcash;
            ATM.history.add(Integer.toString(wcash));
            ATM.history.add("Withdraw");
            System.out.println("Amount Rs"+wcash+"/-withdraw successfully");
        }
        else{
            System.out.println("insufficient balance to withdraw the cash");
        }
        System.out.println("---------------------------");
        ATM.prompt();
    }
    static void deposit(){
        Scanner sc=new Scanner(System.in);
        System.out.println("----------------");
        System.out.print("Enter amount to deposit :");
        int dcash=sc.nextInt();
        ATM.updateBalance(dcash);
        ATM.history.add(Integer.toString(dcash));
        ATM.history.add("Deposit");
        System.out.println("Amount Rs."+dcash+"/- deposit successful!");
        System.out.println("---------------------------");
        ATM.prompt();
    }
    static void transfer(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the receiving body:");
        String s=sc.nextLine();
        System.out.println("Enter the account number of the receiving body");
        int num=sc.nextInt();
        System.out.println("Enter the amount to be transferred :");
        int tcash=sc.nextInt();
        if(tcash<=ATM.balance){
            ATM.balance=ATM.balance-tcash;
            ATM.history.add(Integer.toString(tcash));
            ATM.history.add("transferred");
            System.out.println("Amount Rs."+tcash+"/- transferred successfully");
        }
        else{
            System.out.println(" you have insufficient balance  in your account to transfer the cash");
        }
        System.out.println("=======================================");
    }
}
