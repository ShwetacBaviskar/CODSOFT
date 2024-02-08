import java.util.Scanner;

public class BankAccount{
    static  void Registration(){
        Scanner sc=new Scanner(System.in);
        System.out.println("---------------------------");
        System.out.println("Enter your name :");
        ATM.accholdername=sc.nextLine();
        System.out.println("Enter username :");
        String user=sc.nextLine();
        System.out.println("Enter password :");
        String pass=sc.nextLine();
        System.out.println("Enter your Account number :");
        ATM.accountnumber=sc.nextLine();
        System.out.println("REGISTRATION SUCCESSFULLY!");
        System.out.println("---------------------------");
        ATM.prompt();
        while(true){
            display(ATM.accholdername);
            int choice=sc.nextInt();
            if(choice==1){
                login(user,pass);
                break;
            }
            else {
                if(choice==2){
                    System.exit(0);
                }
                else{
                    System.out.println("Bad value! Enter again!");
                }
            }
        }
    }
    static void display(String accholdername){}
    static void login(String user,String pass){}
}