/**
 * 
 */
package nesti;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ahmed
 *
 */
public class Check {
	
	/**
	 * this function check if the password is strong
	 * @param password
	 * @return
	 */
	  public static int calculatePasswordStrength(String password){
	        
	        //total score of password
	        int iPasswordScore = 0;
	        
	        if( password.length() < 8 )
	            return 0;
	        else if( password.length() >= 10 )
	            iPasswordScore += 2;
	        else 
	            iPasswordScore += 1;
	        
	        //if it contains one digit, add 2 to total score
	        if( password.matches("(?=.*[0-9]).*") )
	            iPasswordScore += 2;
	        
	        //if it contains one lower case letter, add 2 to total score
	        if( password.matches("(?=.*[a-z]).*") )
	            iPasswordScore += 2;
	        
	        //if it contains one upper case letter, add 2 to total score
	        if( password.matches("(?=.*[A-Z]).*") )
	            iPasswordScore += 2;    
	        
	        //if it contains one special character, add 2 to total score
	        if( password.matches("(?=.*[~!@#$%^&*()_-]).*") )
	            iPasswordScore += 2;
	        
	        return iPasswordScore;
	        
	    }
	  
	  /**
	   * check if the email is valid a email
	   * @param email
	   * @return
	   */
	  public static boolean isValidEmail(String email) {
		  
	        // Regex to check valid email.
	        String regex = "^[\\w!#$%&'+/=?`{|}~^-]+(?:\\.[\\w!#$%&'+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
	        // Compile the ReGex
	        Pattern pattern = Pattern.compile(regex);
	        // If the email is empty
	        // return false
	        if (email == null) {
	            return false;
	        }
	        // Pattern class contains matcher() method
	        // to find matching between given email
	        // and regular expression.
	        Matcher m = pattern.matcher(email);
	        // Return if the email
	        // matched the ReGex
	        return m.matches();
	    }

}
