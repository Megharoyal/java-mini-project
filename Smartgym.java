import java.util.*;
class Admin
{
    public long balance;
    public String idno;
    public long number;
    private String gender;
    private String name;
    Scanner sc=new Scanner(System.in);
    //method to open an account
    void register()
    {
        System.out.println("Enter your id number😇😇:");
        idno=sc.nextLine();
        System.out.println("Enter your register number:");
        number=sc.nextLong();
        System.out.println("Enter your name:");
        name=sc.next();
        System.out.println("Enter you gender");
        System.out.println("if male press M🤵‍♂️,if female press F🤵‍♀️");
        gender=sc.next();
        System.out.println("our smart gym have separate branches for boys and girls");
        System.out.println("Budjet per month only");
        balance=sc.nextLong();
        System.out.println("yeah!!! we have slots for that buject...😊😊😊😊😊😊");
        
    }

//method to display account details
    void showDetails()
    {
        System.out.println("Enter your details:");
        System.out.println(idno+" "+number+" "+name+" "+balance+" "+gender);
    }
//method to deposit
    void Payment()
    {
        System.out.println("Enter the payment ammount:");
        long amt;
        amt=sc.nextLong();
        balance=balance+amt;
    }
//method to withdraw
    void Completion()
    {
    
        long amt;
        System.out.println("if you again join to Smart gym Contact me 8090909809....");
        amt=sc.nextLong();
        
        if(balance>=amt)
        {
            balance=balance-amt;
        }
        else
        {
            System.out.println("Invalid id number");
        }   
    }
//method to search an account number
    boolean search(String acn)
    {
        if(idno.equals(acn))
        {
            showDetails();
            return true;
        }
        else
        return false;
    }
}
//main class
public class Project3
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        //create initial account
        System.out.println("🥳🥳🥳🥳🥳🥳🥳🥳Welcome to our Smart gym 🥳🥳🥳🥳🥳🥳🥳🥳 ");
       System.out.println("How many members do you want to join in our smart gym.........");
       System.out.println("like your friends and family members");
       System.out.println("we have separate offers for that😎😎😎😎😎😎😎😎😎");
       System.out.println("now enter how many members do you want to join");
        int n=sc.nextInt();
        Admin C[]=new Admin[n];
        for(int i=0;i<C.length;i++)
        {
            C[i]=new Admin();
            C[i].register();
        }
        //run the loop until 5 is not pressed
        int ch;
        do
        {
            System.out.println("Main menu\n1.Display All\n2.Height and Weight \n3.Payment\n4.Completion\n5.Feedback.");
            System.out.println("**********************");
            System.out.println("Enter your choice:");
            ch=sc.nextInt();//switch value
            switch(ch)
            {
                case 1:
                    for(int i=0;i<C.length;i++)
                    {
                        C[i].showDetails();
                    }
                    break;
                case 2:
                    System.out.println("Enter height and weight ");
                    String acn=sc.next();
                    boolean found=false;
                    for(int i=0;i<C.length;i++)
                    {
                        found=C[i].search(acn);
                        if(found)
                        {
                            break;
                        }
                    }
                        if(!found)
                        {
                            System.out.println("your body is not fit");
                            System.out.println("!.Don't worry we we help you");
                            System.out.println("😇😇😇😇😇😇😇😇😇😇😇😇😇");
                        }
                         break;
                case 3:
                    System.out.println("Enter Account number:");
                    acn=sc.next();
                    found=false;
                    for(int i=0;i<C.length;i++)
                    {
                        found=C[i].search(acn);
                        if(found)
                        {
                            C[i].Payment();
                            break;
                        }
                    }
                    if(!found)
                    {
                        System.out.println("Account does not exist");
                        System.out.println("😕😕😕😕😕😕😕😕😕😕😕😕😕");
                    }
                    break;
                case 4:
                    System.out.println("Enter Register number:");
                    acn=sc.next();
                    found=false;
                    for(int i=0;i<C.length;i++)
                    {
                        found=C[i].search(acn);
                        if(found)
                        {
                            C[i].Completion();
                            break;
                        }
                    }
                    if(!found)
                    {
                        System.out.println("Account does not exist");
                    }
                    break;
                case 5:
                    System.out.println("Thank you and come again and  again...!");
                    System.out.println("😍😍😍😍🥰🥰🥰🥰🥰🥰😍😍😍😍😍");
                    break;
            }
        }while(ch!=5);
    }
}
