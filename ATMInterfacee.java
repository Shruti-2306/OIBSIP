////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Problem Statement: We have come across ATMs in our cities and it is built on java.This complex project consists of five different classes
//                    and is a console based application. When the system starts the user is prompted with user id and user pin. On entering 
//                    the details successfully, then ATM functionalities are unlocked. The project allows to perform following operations:
//                    a.Transaction History
//                    b.Withdraw
//                    c.Deposit
//                    d.Transfer
//                    e.Check Balance
//                    f.Quit
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//Please Note that the initial balance in the account is considered to be 1000f



import java.util.Scanner;

class Account
{
	
    String UserName;
	String SName;
    
	
	String iPin;
	
	float fBalance =0;
	int Transactions = 0;
	String TransactionHistory = "";
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Class used:    Account
//Function Used:  RegisterNewAccount()
// Description:   The function RegisterNewAccount is used to register the user.It is also used to set the username and pin.
// Parameter:     This function does not take any parameters.
// Return Value:  The function is of type void so it does not return anything.
// Author:        Shruti Vaibhav Bartakke
// Date:          7/08/2023   
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
	public void RegisterNewAccount()
    {
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter Your Name: ");
		this.SName = sc.nextLine();
		System.out.print("\nEnter Your Username: ");
		this.UserName = sc.nextLine();
		System.out.print("\nEnter Your Pin: ");
		this.iPin = sc.nextLine();
		
		System.out.println("\nRegistration Succesfull !!!");
        System.out.println("---------------------------------------------------------");
        
	}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Class used:    Account
//Function Used:  Login()
// Description:   The function Login() is used to check the authenticity of account i.e. it checks whether the username and pin that is registered or not
// Parameter:     This function does not take any parameters.
// Return Value:  The function is of type boolean so it returns whether the account is valid or not anything.
// Author:        Shruti Vaibhav Bartakke
// Date:          8/08/2023   
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
	public boolean Login()
     {
	   boolean IsLogin = false;
		Scanner sc = new Scanner(System.in);
		
			System.out.print("\nEnter Your Username: ");
			String Username = sc.nextLine();
			if ( Username.equals(UserName) ) 
            {

					System.out.print("\nEnter Your Pin: ");
					String EnterediPin = sc.nextLine();
					if ( EnterediPin.equals(iPin) )
                    {
						System.out.println("\nLogin successful!!");
                        System.out.println("----------------------------");
                         IsLogin = true;
					
					}
					else 
                    {
						System.out.println("\nIncorrect Pin");
                        System.out.println("\nPlease Enter correct Pin and try again later!");
					}
			}
			
			else
            {
				System.out.println("\nUsername not found");
				System.out.println("***TERMINATING THE APPLICATION******");
				System.out.println("PLEASE RESTART FOR USE");
                 IsLogin = false;
            
			}
			return IsLogin;
		}
		
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Class used:    Account
//Function Used:  TransactionHistory()
// Description:   The function TransactionHistory() is used to display the transactions done sequentially.When any function is used eg deposit, withdraw, transfer
//                it is added in the transation history.
// Parameter:     This function does not take any parameters.
// Return Value:  The function is of type void so it does not return anything.It just displays the transaction history.
// Author:        Shruti Vaibhav Bartakke
// Date:          8/08/2023   
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
    public void TransactionHistory()
     {
		if ( Transactions == 0 )
         {
			System.out.println("\nNo Transactions to show");
			System.out.println("----------------------------");
		}
		else 
        {
			System.out.println("------------------------------------------------------------");
			System.out.println("\nYour Transaction History is \n" + TransactionHistory+"\n");
			System.out.println("------------------------------------------------------------");

		}
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Class used:    Account
//Function Used:  Withdraw()
// Description:   The function Withdraw() is used to withdraw the amount.
// Parameter:     This function does not take any parameters.
// Return Value:  The function is of type void so it does not return anything.
// Author:        Shruti Vaibhav Bartakke
// Date:          9/08/2023   
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 	
	public void Withdraw()
     {
		
		System.out.println("\nEnter amount that you want to withdraw: ");
		Scanner sobj = new Scanner(System.in);
		float amount = sobj.nextFloat();
		try {
			
			if ( fBalance >= amount ) 
            {
				Transactions++;
				fBalance = fBalance -  amount;
				System.out.println("\nAmount of "+amount+ " Withdrawn Successfully");
                System.out.println("------------------------------------------------");
				String str = amount+" Rs withdrawn\n";
				TransactionHistory = TransactionHistory.concat(str);
				
			}
			else
             {
				System.out.println("------------------------------------------------------------------------");

				System.out.println("\nYour Account has Insufficient Balance");
				System.out.println("------------------------------------------------------------------------");

			}
			
		}
		catch ( Exception e) {
		}
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Class used:    Account
//Function Used:  Deposit()
// Description:   The function Deposit() is used to deposit the amount.
// Parameter:     This function does not take any parameters.
// Return Value:  The function is of type void so it does not return anything.
// Author:        Shruti Vaibhav Bartakke
// Date:          9/08/2023   
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 	
	public void Deposit() {
		
		System.out.print("\nEnter the amount that you want to Deposit:  ");
		Scanner sc = new Scanner(System.in);
		float amount = sc.nextFloat();
		
		try {
			if ( amount >= fBalance ) {
				Transactions++;
				fBalance = fBalance + amount;
				System.out.println("\nAmount of "+amount+" is Successfully Deposited");
                System.out.println("----------------------------------------------------");
				String str ="\n"+ amount +" Rs Deposited\n";
				TransactionHistory = TransactionHistory.concat(str);
			}
			else {
				System.out.println("------------------------------------------------------------------------");

				System.out.println("\nSorry amount not deposited");
				System.out.println("------------------------------------------------------------------------");

			}
			
		}
		catch ( Exception e) {
		}
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Class used:    Account
//Function Used:  Transfer()
// Description:   The function Transfer() is used to transfer the amount.
// Parameter:     This function does not take any parameters.
// Return Value:  The function is of type void so it does not return anything.
// Author:        Shruti Vaibhav Bartakke
// Date:          9/08/2023   
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 	
	public void Transfer()
     {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter Receipent's Name: ");
		String receipent = sc.nextLine();
		System.out.print("\nEnter amount to transfer:  ");
		float amount = sc.nextFloat();
		
		try {
			if ( fBalance >= amount ) {
				if ( amount <= fBalance ) {
					Transactions++;
					fBalance = fBalance - amount;
					System.out.println("\nThe amount of "+amount+" is Successfully Transfered to " + receipent);
                    System.out.println("------------------------------------------------------------------------");
					String str = amount + " Rs transfered to " + receipent + "\n";
					TransactionHistory = TransactionHistory.concat(str);
				}
				else {
					System.out.println("------------------------------------------------------------------------");

					System.out.println("\nSorry but the amount cannot be transferred");
					System.out.println("------------------------------------------------------------------------");

				}
			}
			else {
				System.out.println("------------------------------------------------------------------------");

				System.out.println("\nSorry your account has Insufficient Balance");
                System.out.println("\nUnable to transfer amount!! Please try again later");
				System.out.println("------------------------------------------------------------------------");

			}
		}
		catch ( Exception e) {
		}
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Class used:    Account
//Function Used:  checkBalance()
// Description:   The function checkBalance() is used to check the Balance in the account.
// Parameter:     This function does not take any parameters.
// Return Value:  The function is of type void so it does not return anything.It just Displays the balance in the account.
// Author:        Shruti Vaibhav Bartakke
// Date:          9/08/2023   
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 	
	public void checkBalance()
    {
        System.out.println("----------------------------------");
		System.out.println("\nBalance is " + fBalance + " Rs");
        System.out.println("----------------------------------");

	}

}   
	
	



public class ATMInterfacee
{
	
	
/////////////////////////////////////////////////////////////////////////////////
//  Entry Point function
/////////////////////////////////////////////////////////////////////////////////
	
	public static void main(String[] args)
    {
        
		
		System.out.println("\n*********WELCOME TO ATM INTERFACE*********\n");
		System.out.println("1.Register");
        System.out.println("2.Exit");
		System.out.println("Enter Your Choice: ");
		
        Scanner sobj = new Scanner(System.in);
        int choice = sobj.nextInt();


		
		if ( choice == 1 )
         {
			Account aobj = new Account();
			aobj.RegisterNewAccount();
			
			if(aobj.Login())
            {
                       while (choice != 2)
                         {
                            System.out.println("\nChoose the Operation");
                
							System.out.println(" \n1.Deposit");
                            System.out.println("\n2.Withdraw ");
                            System.out.println("\n3.Transfer ");
							System.out.println("\n4.Transaction History ");
							System.out.println("\n5.Check Balance ");
							System.out.println("\n6.Exit");
                

				System.out.print("\nEnter Your Choice: ");
                Scanner zobj = new Scanner(System.in);
                int ch = zobj.nextInt();
				
		if(ch > 6)
		{
			System.out.println("Please Enter valid choice");
			break;
		}


							switch(ch)
                             {
								case 1:
								aobj.Deposit();
								break;

								case 2:
								aobj.Withdraw();
								break;

								case 3:
								aobj.Transfer();
								break;

								case 4:
								aobj.TransactionHistory();
								break;

								case 5:
								aobj.checkBalance();
								break;

								case 6:
                                choice = 2;

                                System.out.println("*****TERMINATING THE APPLICATION******");
								break;
							}
						}
					
			}
             
				
        }
		
		
		System.out.println("Thank you for using the ATM Services");
	}
}

     