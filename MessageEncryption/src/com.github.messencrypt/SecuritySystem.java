package proj1;

import java.util.*;

public class SecuritySystem {
	
	public static int[] numMessages = new int[] {0, 0, 0, 0, 0};//shows number of messages each user has in inbox
	
	public static ArrayList<String> names = new ArrayList<String>(Arrays.asList("Max", "Ksenia", "Sally", "Ali", "Tyrone"));//list of user names

	public static ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();//list of sourceNames for each the messages in each user's respective inbox
	 
	public static void initList () {//initializes each user's inbox of sourceNames
		
		for (int i = 0; i < 5; i++) {
			list.add(i, new ArrayList<String>());
		}//end for loop
		
	}//end initList
	
	public static void printNames() {//prints users' names
		
	for (int i = 0; i < names.size(); i++) {
		System.out.println((i +1) + " - " + names.get(i));
		
		System.out.println();
	}
	
	
	}//end printNames
	
	public static void sourceUserInbox(Integer userIndex, ArrayList<String> sourceInbox) {//adds the sourceName of messages to user inbox
		
			list.add(userIndex, sourceInbox);
		
	}//end sourceUser
	
	public static ArrayList<String> getSourceList(int userIndex) {//returns the sourceNames of messages to a user
		
		return list.get(userIndex);
		
	}
	
	public static String getName(String index) {//returns specific user names
		
		return names.get((Integer.parseInt(index) - 1));
		
	}
	
	public static int userInbox(int userNum) {//returns number of messages in a user's inbox
		
		return numMessages[(userNum - 1)];
	
	}//end userInbox
	
	public static void setUserInbox(int userNum) { //increments number of messages in user inbox with each message received
	
		switch (userNum) {
		case 1 : numMessages[0]++;
				break;
		case 2 : numMessages[1]++;
				break;
		case 3 : numMessages[2]++;
				break;
		case 4 : numMessages[3]++;
				break;
		case 5 : numMessages[4]++;
				break;
		}//end switch
	
	}//end setUserInbox
		
	
	}//end SecuritySystem