import java.util.Scanner;
class Admin
{
    private String accno;
    private String name;
    private long balence;
    Scanner KB=new Scanner(System.in);
    //method to open an account
    void openAccount()
    {
        System.out.println("Enter Account number:");
        accno=KB.nextLine();
        System.out.println("Enter the name of user:");
        name=KB.nextLine();
        System.out.println("Enter balence:");
        balence=KB.nextLong();
    }
//method to display account details
void showAccount()
{
    System.out.println(accno+ " "+name+ " "+balence+" ");
}
//method to deposite money
void deposite()
{
    System.out.println("Enter the balence you deposite it");
    long amt=KB.nextLong();
    balence=balence+amt;
}
//methods to withdraw money
void withdraw()
{
    System.out.println("Enter the amount to be withdraw:");
    long wd=KB.nextLong();
    if(balence>=wd)
    {
        balence=balence-wd;
    }
    else
    {
        System.out.println("Insufficient balenec");
    }
        
}
//method to search an account number
boolean search(String acn)
{
    if(accno.equals(acn))
    {
        showAccount();
        return true;
    }
    return (false);
}
}
//main class
public class Bank
{
public static void main(String args[])
{
    Scanner KB=new Scanner(System.in);
    //create initial account
    System.out.println("How many customers:");
    int n=KB.nextInt();
    Admin c[]=new Admin[n];
    for(int i=0;i<c.length;i++)//01234
    {
        c[i]=new Admin();//c[0],c[1],...c[4]
        c[i].openAccount();//5 times a/c number,name,balence
    }
    //run the loop until 5 is not pressed
    int ch;
    do
    {
       System.out.println("Main menu\n1.Display All\n2.serch an account\n3.diposite\n4.withdraw");
       System.out.println("Enter your choice:");
       ch=KB.nextInt();//switch value
       switch(ch){
           case 1:
               for(int i=0;i<c.length;i++)
               {
                   c[i].showAccount();
               }
               break;
            case 2:
                System.out.println("Enter account that you wannaa search");
                String acn=KB.next();
                boolean found=false;
                for(int i=0;i<c.length;i++)
                {
                    found=c[i].search(acn);
                    if(found){
                        break;
                    }
                }
                if(!found){
                System.out.println("Search failed account not exits");
                }
                break;
            case 3:
                System.out.println("Enter account number:");
                acn=KB.next();
                found=false;
                for(int i=0;i<c.length;i++){
                    found=c[i].search(acn);
                    if(found){
                        c[i].deposite();
                        break;
                    }
                }
                if(!found){
                    System.out.println("Account does not exits!");
                }
                break;
                 case 4:
                System.out.println("Enter account number:");
                acn=KB.next();
                found=false;
                for(int i=0;i<c.length;i++){
                    found=c[i].search(acn);
                    if(found){
                        c[i].withdraw();
                        break;
                    }
                }
                if(!found){
                    System.out.println("Account does not exits!");
                }
                break;
            case 5:
                System.out.println("Good bye!");
                break;
       }
    }while(ch!=5);
}
}


    
    
