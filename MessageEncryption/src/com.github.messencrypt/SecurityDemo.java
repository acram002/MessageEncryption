/*
 * Alexander Cramer
 * Message Encryption
 */


package proj1;

import java.util.*;


public class SecurityDemo {
	
	public static Boolean loop = true;
	
	private static 	Scanner scnr = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		SecuritySystem.initList();//initializes list of message source names
		
		mainMenu();//calls main menu to display options 
		
		  
	}//end main
	
	public static void mainMenu() {//gives options for various program functions; uses switch to call methods for each option
		
		while (loop == true) {
		
		System.out.println("Please type one of the following:");
		System.out.println("0 - exit program");			
		System.out.println("1 - send a message");
		System.out.println("2 - view inbox");
		System.out.println("3 - view users\n");
		
		int option = scnr.nextInt();
		
		switch(option) {
		case 0: exitPrgrm();
			break;
		case 1:sendMessage();
			break;
		case 2:viewInbox();
			break;
		case 3:viewUsers();
			break;
		}//end switch
		
		System.out.println();
		
		}//end while loop
		
	}//end mainMenu
		
		public static void exitPrgrm() {//exits program
			System.out.println("\nThanks for using the Secure Messaging Program. Goodbye!");
			System.exit(0);
		}//end exitPrgrm
		
		
		public static void sendMessage() {//sends message from user
			System.out.println("\nSend a message to whom and from whom in the form:");
			System.out.println("     To From Message : Key\n");
			
			SecuritySystem.printNames();
		
			String to = scnr.next();
			String from = scnr.next();
			
			String myString = scnr.nextLine();
			
			String [] input = myString.split(":");
		
			SecureMessage.SecureMessage(input[0], from, to, input[1].trim()); //calls SecureMessage to store new message with all info
			
			System.out.println("\nSent message from " + SecuritySystem.getName(from) + " to " + SecuritySystem.getName(to) + " \"" + input[0] + "\"");
			
		}//end sendMessage

		public static void viewInbox() {//shows user's inbox and will display message if correct key is given
			
			System.out.println("\nView your inbox. Who are you?\n");
			SecuritySystem.printNames();
			
			int userNum = scnr.nextInt();
						
			int messNum = -1;
			
			while (messNum != 0) {
				System.out.println("\nHello " + SecuritySystem.names.get(userNum - 1) + ", you have " + SecuritySystem.userInbox(userNum) + " message waiting for you. Which do you want to read?");
				System.out.println("Type 0 to go back to main menu.\n");
				System.out.println("(Type the number of the message)");
							
				ArrayList<String> sourceList = SecuritySystem.getSourceList((userNum - 1));
				
				String [] sourceArray = (sourceList).toArray(new String[sourceList.size()]);
				
				for (int i = 0; i < sourceArray.length; i++) {
					System.out.print("\n" + (i + 1) + " - From ");
					switch (sourceArray[i]) {
					case "1":System.out.println("Max");
						break;
					case "2":System.out.println("Ksenia");
						break;
					case "3":System.out.println("Ali");
						break;
					case "4":System.out.println("Sally");
						break;
					case "5":System.out.println("Tyrone");
						break;
					}//end switch
					
				}//end for loop
				
				System.out.println("");
				
				messNum = scnr.nextInt(); 
				
				System.out.println("\n" + messNum);
			
				System.out.println("\nWhat is the key to read your message?\n");
			
				String messKey = scnr.next();
								
				String hashMess = SecureMessage.getMessage(messKey);
				
				if (hashMess != null) {
					System.out.println("\nCorrect! Your message is:");
					System.out.println(hashMess + "\n");
					}
				else {
					System.out.println("Incorrect key.\n");
					}
			
				}//end while loop
			
		}//end viewInbox
		
		public static void viewUsers(){//shows list of users
					
			System.out.println("\nUser list:\n");
			
			SecuritySystem.printNames();
			
		}//end viewUsers
		

	}//end SecurityDemo
