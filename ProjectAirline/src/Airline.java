
import java.util.ArrayList;
import java.util.Scanner;

public class Airline {
	public static void main (String []args){ 
		Scanner in = new Scanner(System.in);
		ArrayList<Customer> CusInfo = new ArrayList<Customer>();
	Customer c1 = new Customer();
	CusInfo.add(c1);
	ArrayList<Admin> AdminInfo = new ArrayList<Admin>();
	Admin A1 = new Admin();
	AdminInfo.add(A1);   
	Flight f1 = new Flight();
	int count2 = 1;
	int count3 = 1001;
	int LogInID = -1;
	System.out.println("Welcome To Airline!");
	String YorN = "y";
	while (YorN.equals("y")){
		System.out.println("-----------------------");
		System.out.println("     *Main Menu* ");
		System.out.println("-----------------------");
		System.out.println("1. Log in ");
		System.out.println("2. Create a new account ");
		System.out.println("3. Forget my password ");
		System.out.println("Select Option(1,2,3) : ");
		int choice = in.nextInt();
		if (choice == 1) {
			System.out.println("");
					System.out.println("");
			System.out.println("-----------------------");
			System.out.println("Log In");
			System.out.println("-----------------------");
			System.out.println("(1) Log in as a user");
			System.out.println("(2) Log in as an admin");
			System.out.println("(3) Back to Main Menu");
			System.out.println("Select Option(1,2,3) : ");
			int log = in.nextInt();
			if(log == 1) {
				int count1 = 0;
				boolean check = false;
				String ID;
				String Pas;
				System.out.println("Type user ID:");
				 ID = in.next();
				 System.out.println("Type user Password:");
					Pas = in.next();
					for(int i = 0; i < CusInfo.size(); i++) {
						if(CusInfo.get(i).getcustomerUsername().equals(ID) == true) {
							if(CusInfo.get(i).getcustomerPassword().equals(Pas) == true ) {
								check = true;
								LogInID = i;
							}
						}
							}					
						if(check == true) {				
						f1.CusFlight(LogInID,CusInfo);
					}			
					else {
						System.out.println("Incorrect User ID or Password");
						System.out.println("Back to the main menu? Press 'n' if you want to keep trying(y/n)");
						YorN = in.next();
						if(YorN.equals("n")) {
							System.out.println("Remaining chance: " + (3- count1));
							System.out.println();
						}
						while(count1<3 && YorN.equals("n"))
						{
						 System.out.println("Please Re-type user ID:");
						ID = in.next();
						System.out.println("Please Re-type user Password:");
						Pas = in.next();
						for(int i = 0; i < CusInfo.size(); i++) {
							if(CusInfo.get(i).getcustomerUsername().equals(ID) == true) {
								if(CusInfo.get(i).getcustomerPassword().equals(Pas) == true ) {
									check = true;
									LogInID = i;
								}
							}
								}					
							if(check == true) {		
								f1.CusFlight(LogInID,CusInfo);
						}else {
							count1++;
						System.out.println("Incorrect User ID or Password");
						System.out.println("Back to the main menu? Press 'n' if you want to keep trying(y/n)");
						YorN = in.next();
						if(YorN.equals("y")) {
							break;
						}
						System.out.println("Remaining chance: " + (3- count1));
						}
						}
								}
			if(count1 == 3) {
			System.out.println("Back to Main Menu");
			System.out.println();
		}
			}
		if(log == 2) {
			int count1 = 0;
			boolean check = false;
			String ID;
			String Pas;
			System.out.println("Type Admin ID:");
			 ID = in.next();
			 System.out.println("Type Admin Password:");
				Pas = in.next();
					for(int i = 0; i < CusInfo.size(); i++) {
						if(AdminInfo.get(i).getAdminCode().equals(ID) == true) {
							if(AdminInfo.get(i).getAdminPassword().equals(Pas) == true ) {
								check = true;
								LogInID = i;
							}
						}
							}					
						if(check == true) {
					
						System.out.println("Welcome!");	
					}			
					else {
						System.out.println("Incorrect User ID or Password");
						System.out.println("Back to the main menu? Press 'n' if you want to keep trying(y/n)");
						YorN = in.next();
						if(YorN.equals("n")) {
							System.out.println("Remaining chance: " + (3- count1));
							System.out.println();
						}
						while(count1<3 && YorN.equals("n"))
						{
						 System.out.println("Please Re-type user ID:");
						ID = in.next();
						System.out.println("Please Re-type user Password:");
						Pas = in.next();
						for(int i = 0; i < CusInfo.size(); i++) {
							if(AdminInfo.get(i).getAdminCode().equals(ID) == true) {
								if(AdminInfo.get(i).getAdminPassword().equals(Pas) == true ) {
									check = true;
									LogInID = i;
								}
							}
								}					
							if(check == true) {					
							System.out.println("Welcome!");	
							break;
						}else {
							count1++;
						System.out.println("Incorrect User ID or Password");
						System.out.println("Back to the main menu? Press 'n' if you want to keep trying(y/n)");
						YorN = in.next();
						if(YorN.equals("y")) {
							break;
						}
						System.out.println("Remaining chance: " + (3- count1));
						}
						}
								}
		}if(log == 3) {		
		}
		}
		if(choice == 2){
			System.out.println("");
			System.out.println("");
	System.out.println("-----------------------");
	System.out.println("Registration");
	System.out.println("-----------------------");
	System.out.println("(1) Create a new account for a user");
	System.out.println("(2) Create a new account for an Admin");
	System.out.println("(3) Back to Main Menu");
	System.out.println("Select Option(1,2,3) : ");
	int reg = in.nextInt();
	if(reg == 1) {
		System.out.println("Type First Name : ");   
		String first= in.next();
		System.out.println("Type Last Name : ");   
		String last= in.next();
		System.out.println("Type Address : ");   
		String address= in.nextLine();
		address= in.nextLine();
		System.out.println("Type Zip Code : ");   
		String zip= in.next();
		System.out.println("Type State : ");   
		String state= in.next();
		System.out.println("Type User Name : ");   
		String username= in.next();
		for (int i = 0; i < CusInfo.size(); i++) {
         while (CusInfo.get(i).getUsername().contains(username)) {
			System.out.println("\nThis is the username already used."+
					"\nPlease try again.");
			username= in.next();
		}
		}
		System.out.println("Type Password : ");   
		String password= in.next();
		System.out.println("Type Email : ");   
		String email= in.next();
		System.out.println("Type SSN : ");   
		String ssn= in.next();
		System.out.println("Type a security question for password recovery : ");   
		String securityQ= in.nextLine();
		securityQ= in.nextLine();
		Customer c2 = new Customer(count2++, first, last, address, zip, state, username, password, email, ssn, securityQ);
		CusInfo.add(c2);
		   System.out.println(c2.toString());
		System.out.println("Thank you!");
		 for(int e = 0; e < CusInfo.size(); e++) {
	         System.out.println("For every single person in the array: " + CusInfo.get(e).toString());
	      }
		   System.out.println("Back to the main menu?(y/n)");
			YorN = in.next();
			System.out.println();
		}
		if(reg == 2) {System.out.println("Type First Name : ");   
		String first= in.next();
		System.out.println("Type Last Name : ");   
		String last= in.next();
		System.out.println("Type Address : ");   
		String address= in.nextLine();
		address= in.nextLine();
		System.out.println("Type Zip Code : ");   
		String zip= in.next();
		System.out.println("Type State : ");   
		String state= in.next();
		System.out.println("Type User Name : ");   
		String username= in.next();
		for (int i = 0; i < CusInfo.size(); i++) {
         while (AdminInfo.get(i).getUsername().contains(username)) {
			System.out.println("\nThis is the username already used."+
					"\nPlease try again.");
			username= in.next();
		}
		}
		System.out.println("Type Password : ");   
		String password= in.next();
		System.out.println("Type Email : ");   
		String email= in.next();
		System.out.println("Type SSN : ");   
		String ssn= in.next();
		System.out.println("Type a security question for password recovery : ");   
		String securityQ= in.nextLine();
		securityQ= in.nextLine();
		System.out.println("Type the secret code for admin : ");   
		String AdminSecretCode= in.next();
		if(AdminInfo.get(0).getAdminSecretCode().contains(AdminSecretCode)) {
		Admin A2 = new Admin(count3++, first, last, address, zip, state, username, password, email, ssn, securityQ);
		AdminInfo.add(A2);
		   System.out.println(A2.toString());
		System.out.println("Thank you!");
		 for(int e = 0; e < AdminInfo.size(); e++) {
	         System.out.println("For every single person in the array: " + AdminInfo.get(e).toString());
	      }
		 System.out.println("Back to the main menu?(y/n)");
			YorN = in.next();
			System.out.println();
		}else {
			System.out.println("Wrong the secret code for admin");
			System.out.println("Back to Main Menu");
			System.out.println();
		}
		}if(reg == 3) {	
		}
		}
		if(choice == 3) {
			System.out.println("");
			System.out.println("");
	System.out.println("-----------------------");
	System.out.println("Forget My password");
	System.out.println("-----------------------");
	System.out.println("(1) Find my password for a user");
	System.out.println("(2) Find my password for an Admin");
	System.out.println("(3) Back to Main Menu");
	System.out.println("Select Option(1,2,3) : ");
	int forg = in.nextInt();
			int count = 0;
			boolean check = false;
			if(forg == 1) {
				System.out.println("Type user ID :");
				String UserID = in.next();
				System.out.println("Type the answer for the security question :");
				String SecQ = in.next();
				for(int i = 0; i < CusInfo.size(); i++) {
					if(CusInfo.get(i).getcustomerUsername().equals(UserID) == true) {
						if(CusInfo.get(i).getcustomerSecurityQ().equals(SecQ) == true ) {
							check = true;
							System.out.println(CusInfo.get(i).toString());
						}
					}
						}					
					if(check == true) {
	                  break;
				}			
				else {
					System.out.println("Incorrect User ID or Security Answer");
					System.out.println("Back to the main menu? Press 'n' if you want to keep trying(y/n)");
					YorN = in.next();
					if(YorN.equals("n")) {
						System.out.println("Remaining chance: " + (3- count));
						System.out.println();
					}
					while(count<3 && YorN.equals("n"))
					{
					 System.out.println("Please Re-type user ID:");
					 UserID = in.next();
					System.out.println("Please Re-type the answer for the security question :");
					SecQ = in.next();
					for(int i = 0; i < CusInfo.size(); i++) {
						if(CusInfo.get(i).getcustomerUsername().equals(UserID) == true) {
							if(CusInfo.get(i).getcustomerSecurityQ().equals(SecQ) == true ) {
								check = true;
								System.out.println(CusInfo.get(i).toString());
							}
						}
							}					
						if(check == true) {					
						break;
					}else {
						count++;
					System.out.println("Incorrect User ID or Security Answer");
					System.out.println("Back to the main menu? Press 'n' if you want to keep trying(y/n)");
					YorN = in.next();
					if(YorN.equals("y")) {
						break;
					}
					System.out.println("Remaining chance: " + (3- count));
					}
					}
							}
		}if(forg == 2) {
			System.out.println("Type user ID :");
			String UserID = in.next();
			System.out.println("Type the answer for the security question :");
			String SecQ = in.next();
			for(int i = 0; i < AdminInfo.size(); i++) {
				if(AdminInfo.get(i).getAdminCode().equals(UserID) == true) {
					if(AdminInfo.get(i).getAdminSecurityQ().equals(SecQ) == true ) {
						check = true;
						System.out.println(AdminInfo.get(i).toString());
					}
				}
					}					
				if(check == true) {
                  break;
			}			
			else {
				System.out.println("Incorrect User ID or Security Answer");
				System.out.println("Back to the main menu? Press 'n' if you want to keep trying(y/n)");
				YorN = in.next();
				if(YorN.equals("n")) {
					System.out.println("Remaining chance: " + (3- count));
					System.out.println();
				}
				while(count<3 && YorN.equals("n"))
				{
				 System.out.println("Please Re-type user ID:");
				 UserID = in.next();
				System.out.println("Please Re-type the answer for the security question :");
				SecQ = in.next();
				for(int i = 0; i < AdminInfo.size(); i++) {
					if(AdminInfo.get(i).getAdminCode().equals(UserID) == true) {
						if(AdminInfo.get(i).getAdminSecurityQ().equals(SecQ) == true ) {
							check = true;
							System.out.println(AdminInfo.get(i).toString());
						}
					}
						}					
					if(check == true) {					
					break;
				}else {
					count++;
				System.out.println("Incorrect User ID or Security Answer");
				System.out.println("Back to the main menu? Press 'n' if you want to keep trying(y/n)");
				YorN = in.next();
				if(YorN.equals("y")) {
					break;
				}
				System.out.println("Remaining chance: " + (3- count));
				}
				}
						}
	}if(forg == 3) {			
	}
	}
}
}
	}