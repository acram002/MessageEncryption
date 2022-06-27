package proj1;

import java.util.*;

public class SecureMessage {
	  String message;
	   String sourceName;
	   String destName;
	   String key;
	   
	   public static HashMap<String, String> keyMessage = new HashMap<String, String>();//hashmap to stores messages
	   
	   public static ArrayList<String> maxMess = new ArrayList<String>();//arraylists of the sourceNames of messages; individual to each user's inbox
	   public static ArrayList<String> kseniaMess = new ArrayList<String>();
	   public static ArrayList<String> sallyMess = new ArrayList<String>();
	   public static ArrayList<String> aliMess = new ArrayList<String>();
	   public static ArrayList<String> tyroneMess = new ArrayList<String>();
	   
	   public static int messageNumber = 0;
	   
	    
	    public static void SecureMessage (String message, String sourceName, String destName, String key) {//stores message from user to user
	     
	     	keyMessage.put(key, message);
	     		    	
	     	int m = 0;
	     	
	     	SecuritySystem.setUserInbox(Integer.parseInt(destName));
	     	
	     	switch(destName) {
		  	case "1": maxMess.add(sourceName); 
		  			SecuritySystem.sourceUserInbox(0, maxMess);
	     		break;
	     	case "2":kseniaMess.add(sourceName);
	     			SecuritySystem.sourceUserInbox(1, kseniaMess);
	     		break;
	     	case "3":aliMess.add(sourceName);
	     			SecuritySystem.sourceUserInbox(2, aliMess);
	     		break;
	     	case "4":sallyMess.add(sourceName);
	     			SecuritySystem.sourceUserInbox(3, sallyMess);
	     		break;
	     	case "5":tyroneMess.add(sourceName);
	     			SecuritySystem.sourceUserInbox(4, tyroneMess);
	     		break;
	     	}//end switch
	     	
	     	
	      }//end SecureMessage
	      
	      
	    public static String getMessage(String key) {//returns message from hashmap based on key
		
	    	return keyMessage.get(key);
	      
	      }//end getMesssage
	      
	      
	    public String getSourceName() {
	      
	    	return sourceName;
	      
	      }//end getSourceName
	      
	      
	    public String getDestName() {
	      
	      return destName; 
	      
	      }//end getDestName
	 
	}//end SecureMessage