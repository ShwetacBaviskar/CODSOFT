public class Check{
    static void checkBalance(){
        System.out.println("==================================");
        System.out.println("The available balance in the your bank account is :");
        ATM.showBalance();
        System.out.println("===================================================");
        ATM.prompt();
    }
}