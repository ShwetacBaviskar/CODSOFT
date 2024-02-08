import java.util.*;
public class ATM {
    public static String accholdername;
    public static int balance=0;
    public static String accountnumber;
    public static ArrayList<String> history= new ArrayList<>();

    static void updateBalance(int dcash){
        balance=balance+dcash;
    }
    static void showBalance(){
        System.out.println(balance);
    }
    public static void Homepage(){
        System.out.println("\033[H\033[2J");
        Scanner sc=new Scanner(System.in);
        System.out.println("WELCOME TO OUR ATM Machine INTERFACE");
        System.out.println("============================================");
        System.out.println("select option from below to options:");
        System.out.println("1. Register  -----for your Registration ");
        System.out.println("2. Exit      ------ to exit fron ATM Interface");
        System.out.println("Enter choice");
        int choice =sc.nextInt();
        if (choice==1){
            BankAccount.Registration();
        }
        else {
            if(choice==2){
                System.exit(0);
            }
            else{
                System.out.println("select a value only from the given options :");
                Homepage();
            }
        }
    }
    static void prompt(){
        Scanner sc=new Scanner(System.in);
        System.out.println("WELCOME "+ATM.accholdername+"! TO OUR ATM SYSTEM");
        System.out.println("=====================================");
        System.out.println("Select option : ");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Transfer");
        System.out.println("4. Check balance");
        System.out.println("5. Transaction History");
        System.out.println("6. Exit");
        System.out.print("Enter your choice : ");
        int choice=sc.nextInt();
        switch (choice) {
            case 1:
                Transaction.withdraw();
            case 2:
                Transaction.deposit();
            case 3:
                Transaction.transfer();
            case 4:
                Check.checkBalance();
            case 5:
                forUSER.transactionHistory();
            case 6:
                System.exit(0);
        }
    }

    public static void main(String[] args) {
        Homepage();
    }
}