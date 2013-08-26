package acme_client;



import beans.CustomerBeanRemote;
import beans.EmployeeBeanRemote;
import beans.SavingsBeanRemote;
//import beans.ShoppingCartRemote;
import java.io.Serializable;
import java.sql.Date;
import java.util.Scanner;
import javax.ejb.EJB;
// Below is main method |||Test again
//johnny
// Testing change for commit

/**
 *
 * @author s3248563
 */
//
public class Main implements Serializable{

    /**
     * @param args the command line arguments
     */
    @EJB
    private static CustomerBeanRemote customerBean;
    
    @EJB
    private static EmployeeBeanRemote employeeBean;
    
    @EJB
    private static SavingsBeanRemote savingsBean;
    
    //TUTORITAL 4
    //@EJB
    //private static ShoppingCartRemote shoppingCartBean;
    
    
    //private String id;
    
    //private Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
        // TODO code application logic here
    
    Scanner scan = new Scanner(System.in);
    int id;
    String name;
    String emp = "q";
    //String emp = "Default1";
    //Employee Logging In   
    // Ask for First Name
    // Ask for Last Name
    // Ask for ID
    
//    ADDING EMPLOYEE
//    System.out.print("Enter employee First Name: ");
//    String fName = scan.nextLine();
//    System.out.print("Enter employee Last Name: ");
//    String lName = scan.nextLine();
//    employeeBean.addEmployee(fName,lName);
//    System.out.println(fName + " " + lName + " was added.");
    
     //Adding a customer    
    //customerBean.addCustomer("Danny", "Brians", new Date(1987-1900,9-1,21), "178 Space Way.");
    //for date need to subtract 1900 and -1   
    
    //Creating Savings Account
    savingsBean.createSavingsAccount(2, "Con321", 1000);
   
  //FINDING EMPLOYEE // SIMPLE LOG IN SYSTEM AND MENU  
    System.out.println("Employee Login");
    System.out.println("-------------------------------");
    System.out.print("Enter employee ID: ");
    id = scan.nextInt();
    //emp = employeeBean.readEmployee(id);
    System.out.println("");
    System.out.print("Enter employee Name: ");
    name = scan.next();
    System.out.println(name);
    System.out.println(emp);
    
    emp = employeeBean.readEmployee(id) ;
    System.out.println(emp);
    //String emp = "1";
    //String emp = employeeBean.readEmployee(id);
    //String emp = employeeBean.readEmployee(name).toString();
    //emp.compareTo(name) ==1
    if (emp.equals(name))
    {
     System.out.println("Welcome: " + emp);
     int choice = 0;
     int count = 0;
     
     do
     {
        System.out.println("MENU SYSTEM " + "Number of Operations this session: " + count);
        System.out.println("-------------------------------");
        System.out.println("1) Register a new customer");
        System.out.println("2) Open a Savings Account (To be implemented)");
        System.out.println("3) Savings Account -- Deposit");
        System.out.println("4) Savings Account -- Withdrawl");
        System.out.println("5) Savings Account -- Balance");
        System.out.println("0) Log Out");
        System.out.println("-------------------------------");
        System.out.println("Make a selection: ");
        choice = scan.nextInt();
       
        
        //Simple creating customer form. Maybe to simple and may need the use of beans to do. //Works fine as it is now.
        if (choice == 1)
        {
            String fName;
            String lName;
            Date dob;
            int year;
            int month;
            int day;
            String address;     
            
            System.out.println("Enter a First Name: ");
            fName = scan.next();
            System.out.println("Enter a Last Name: ");
            lName = scan.next();        
            System.out.println("Enter an Address: ");
            scan.nextLine();
            address = scan.nextLine();
            //scan.nextLine();
            System.out.println("Enter a Date Of Birth Year: ");
            year = scan.nextInt();
            System.out.println("Enter a Date Of Birth Month: ");
            month = scan.nextInt();
            System.out.println("Enter a Date Of Birth Day: ");
            day = scan.nextInt();
            dob = new Date(year - 1900,month-1,day);
            
            customerBean.addCustomer(fName, lName, dob, address);
            //System.out.println(fName + " " + lName + " " + dob + " " + address);
            //customerBean.addCustomer("Tony", "Conners", new Date(1966-1900,7-1,3), "154 Arberdeen Ave.");
            //for date need to subtract 1900 and -1  
             count ++;
             choice = -1;
        }
        else if (choice == 2)
        {
            //CREATING SAVINGS ACCOUNT
            int c_id;
            String accNum;
            int balance;
            boolean isMax;
            
            System.out.println("Creating a Savings Account: ");
            System.out.println("Enter the Customer ID: ");
            c_id = scan.nextInt();
            System.out.println("Enter an Account Number: ");
            accNum = scan.next();     
            System.out.println("Enter the Opening Balance $: ");
            balance = scan.nextInt();  
            
            System.out.println(c_id + accNum + balance);
            
            isMax = savingsBean.maxSavings(c_id);
            if (isMax == true)
            {
            System.out.println("Creating savings account...");
            savingsBean.createSavingsAccount(c_id, accNum, balance);
            count++;
            }
            else
            {
                System.out.println("Maximum amount of Savings account have been made for Customer ID " + c_id);
            }
        }
        else if(choice == 3)
        {
         //DEPOSIT
            count++;
        }
        else if(choice == 4)
        {
         //WITHDRAWL
            count++;
        }
        else if(choice == 5)
        {
         //VIEW BALANCE
            String accNum;
            
            System.out.println("View Balance");
            System.out.println("Enter an Account Number: ");
            accNum = scan.next();
            System.out.print("Current Balance: $");
            int i = savingsBean.getBalance(accNum);
            System.out.println(i);
            System.out.println(accNum);
            
            count++;
        }
        else
        { 
            count = 10;
        }
     }
     while(choice != 0 || count != 10);
     System.out.println("Logging Out...");

    }
    else
    {
    System.out.println("");
    System.out.println("Log In failed, ID and Name do not match.");
    }   
        

        
 //TUTORIAL 4 SHOPPING CART MENU
    //ShoppingCart
//    int menuSelection = 0;
//    Main m = new Main();
// do {
//     
// System.out.println("Cart:");
// List<String> cartItems = shoppingCartBean.getItemsInCart();
// for (String item : cartItems) {
// System.out.println(item);
// }
//     
//     
// System.out.println();
// System.out.println("1: Add item 1");
// System.out.println("2: Add item 2");
// System.out.println("3: Add item 3");
// System.out.println("4: Add item 4");
// System.out.println("5: View Cart");
// System.out.println("6: Empty Cart");
// System.out.println("7: Log Out");
// //m.getSelection();
// menuSelection = m.getSelection();
// 
//
// 
// if (menuSelection >= 1 && menuSelection <= 4) {
// shoppingCartBean.addItemToCart(menuSelection);
// }
// if (menuSelection == 5) {
// shoppingCartBean.getItemsInCart();
// }
// if (menuSelection == 6) {
// shoppingCartBean.emptyCart();
// }
// 
// }while (menuSelection != 7);
// 
 
 
 
    
    }
    
// private int getSelection() {
// String input = "";
// int output = -1;
// boolean validInput = false;
// //Scanner scan = new Scanner(System.in);
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 
// do {
//    try {
//        input = br.readLine();
//        if (input.length() > 1) {
//        continue;
//        }
//        output = Integer.parseInt(input);
//            if (output < 0 || output > 9) {
//            continue;
//        }
//        validInput = true;
// }catch (IOException ioe) {
//     
// System.out.println(ioe.getMessage());
// ioe.printStackTrace();
// validInput = false;
// } catch (NumberFormatException nfe) {
// validInput = false;
// }
// } while (validInput == false);
// return output;
// }
    
}
