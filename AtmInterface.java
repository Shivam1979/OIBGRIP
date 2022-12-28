//shivam,
//singh,
import java.security.PrivateKey;
import java.util.Scanner;

class Account{
    protected String u_id;
    protected String u_p;
    void  createAcc(){
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter UserName \uD83D\uDC64\uD83D\uDC64 :");
        u_id= sc.nextLine();
        System.out.println("Enter Password \uD83D\uDDDD\uD83D\uDDDD  :");
        u_p= sc.nextLine();
        System.out.println("Congratulation \uD83D\uDC90\uD83D\uDC90!! Account created sucessfully");
    }
}

class LoginAcc extends Account{
    private String id;
    private String p;

    void login (){
        do {
            Scanner sc =new Scanner(System.in);
            System.out.println("Enter username:");
            id= sc.nextLine();
            if (u_id.equals(id)){
                do {
                    System.out.println("Enter password: ");
                    p = sc.nextLine();
                    if (p.equals(u_p)){
                        System.out.println("Login successful !");
                    }else{
                        System.out.println("Wrong password ! Please Enter Correct Password");
                    }
                }while (p.equals(u_p)==false);


            }else {
                System.out.println("Wrong Password \uD83D\uDDDD\uD83D\uDDDD! Please Enter correct password");
            }

        }while (u_id.equals(id)==false);
    }

}
//--------------------------------------------------------------------------------------------------------------

class  Deposit{
    int amount;
    int balance=100000;
    int prevtransaction;
    String Transactionhistory="";
    Scanner sc= new Scanner(System.in);

    void Display(){
        System.out.println("Enter amount deposit: ");
        amount= sc.nextInt();
        if (amount !=0){
            prevtransaction++;
            balance=balance+amount;
            String str=amount + " rs deposited \n";
            Transactionhistory =Transactionhistory.concat(str);
            System.out.println("Amount is successfully Deposited \uD83E\uDDE1! ");
        }
    }
}
//--------------------------------------------------------------------------------------------
class Withdraw extends Deposit {
     void  cash(){
         System.out.println("Enter amount to withdraw: ");
         amount =sc.nextInt();
         if (balance>amount){
             if (amount<=20000){
                 prevtransaction++;
                 balance=balance-amount;
                 prevtransaction=prevtransaction-amount;
                 System.out.println("Amount withdraw successfully\uD83E\uDDE1 !");
                 String str =amount + "rs withdrawed \n";
                 Transactionhistory = Transactionhistory.concat(str);

             }else {
                 System.out.println("Sorry!\uD83D\uDE10.......limit is 20000");
             }
         }else {
             System.out.println("Insufficient amount to withdraw !");
         }
     }
}

//---------------------------------------------------------------------------------------

class Transfer extends Withdraw{

    void forward(){
        int bank_acc;
        int ac;
        int r_accbalance=0;
        System.out.println("Enter amount to transfer: ");
        amount=sc.nextInt();
        if (balance<amount){
            System.out.println(" Oops \uD83D\uDE36! you have not suffcient balance to transfer amount");

        }else {
            System.out.println("Enter the account no of receiver: ");
            ac = sc.nextInt();
            this.balance=this.balance-amount;
            r_accbalance += amount;
            System.out.println("Your account balance becomes $ "+ this.balance);
            System.out.println("Account Balance receiver become $ " + r_accbalance );
            String str =amount + "Rs Transfered";
            Transactionhistory =Transactionhistory.concat(str);

        }
    }
}
//--------------------------------------------------------------------------------------------
class CheckBalance extends Transfer{
     void check (){
         System.out.println("\n available balnce is :: " + balance+ "Rs");
     }

}
//--------------------------------------------------------------------------------------------
class  TransactionHistory extends CheckBalance{
    void  history(){
        if (prevtransaction==0){
            System.out.println("\n" + prevtransaction);
        }
    }
}
//--------------------------------------------------------------------------------------------
public class AtmInterface {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println(" ******************\uD83C\uDFE6\uD83C\uDFE6WELCOME TO RDI BANK\uD83C\uDFE6\uD83C\uDFE6  ********************");
        LoginAcc a =new LoginAcc();
        a.createAcc();
        System.out.println("***************** \uD83C\uDFE6\uD83C\uDFE6WELCOME BACK TO RDI BANK\uD83C\uDFE6\uD83C\uDFE6******************");
        System.out.println("=================================================================");
        System.out.println("****************** \uD83D\uDC64\uD83D\uDDDDWElCOME TO LOGIN SECTOR \uD83D\uDC64\uD83D\uDDDD************************");
        a.login();
        int ch;
        TransactionHistory t = new TransactionHistory();
        while (true){
            System.out.println("\n");
            System.out.println("\n");
            System.out.println("1. Check Balance \uD83D\uDCB5\uD83D\uDCB5");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Previos Transaction");
            System.out.println("5. Transfer");
            System.out.println("6. Exit \uD83D\uDD19");
            System.out.println("====================================================================");
            System.out.println("Enter your choice: ");
            System.out.println("====================================================================");
            ch = sc.nextInt();
            switch (ch){
                case 1:
                     t.check();
                      break;

                case 2:
                    t.Display();
                    break;
                case 3:
                    t.cash();
                    break;
                case 4:
                    t.history();
                    break;
                case 5:
                    t.forward();
                    break;
                case 6:
                    System.out.println("Thank you \uD83E\uDDE1\uD83E\uDDE1 ! for using our service");
                    System.exit(ch);
                    break;
                default:
                    System.out.println("Enter valid choice");

            }
        }


    }
}
