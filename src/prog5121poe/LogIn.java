// Michael French
// ST10195824
package prog5121poe;


// http://tutorials.jenkov.com/java-regex/matcher.html
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class LogIn
{
// creating fields for LogIn class
    private String UserName;
    private String FirstName;
    private String LastName;
    private String Password;

 //--------------SETTERS_&_GETTERS--------------//   
    public LogIn()
    {

    }


    public String getUserName()
    {
        return UserName;
    }

    public void setUserName(String UserName)
    {
        this.UserName = UserName;
    }

    public String getFirstName()
    {
        return FirstName;
    }

    public void setFirstName(String FirstName)
    {
        this.FirstName = FirstName;
    }

    public String getLastName()
    {
        return LastName;
    }

    public void setLastName(String LastName)
    {
        this.LastName = LastName;
    }

    public String getPassword()
    {
        return Password;
    }

    public void setPassword(String Password)
    {
        this.Password = Password;
    }
//-----------END_OF_SETTERS_&_GETTERS--------//
    
//----------DATA_VALIDATION----------------//
    
    public boolean checkUsername()
    {
        // check to make sure the username is less than 5 characters and that the username contains an underscore
        if (this.UserName.length() <= 5 && this.UserName.contains("_"))
        {
            return true;
        }
        return false;
    }

    
    public boolean checkPasswordComplexity()
    {
        // patterns to go through to check for needed characters
        Pattern CapitalLetter = Pattern.compile("[A-Z]");
        Pattern SpecialCharacter = Pattern.compile("[!#$%&'()*+,-./:;<=>?@^_`{|}~]");
        Pattern Number = Pattern.compile("[0-9]");

        // matchers to return if the character was found in the string
        Matcher checkForSpecialCharacter = SpecialCharacter.matcher(this.Password);
        Matcher checkForCapitalLetter = CapitalLetter.matcher(this.Password);
        Matcher checkForNumber = Number.matcher(this.Password);

        // check that password is longer than 7 characters has a capital letter, a number and a special character
        return this.Password.length() >= 8 && checkForSpecialCharacter.find() && checkForCapitalLetter.find() && checkForNumber.find();

    }

  // the next 2 methods are exactly the same except the first returns a true or false and the second returns a string (it seemed like the task 1 instructions wanted this?)  
   public boolean logUserIn(String userNameArg, String userPassArg)
    {
        // checks the objects internal username and password against the method arguments
        // as this returns a boolean the if statment is not nessasary but is left here for readability
        if (userNameArg.equals(this.getUserName()) && userPassArg.equals(this.getPassword()))
        {
            return true;
        }
        return false;
    } 
    
   //------------------END_OF_DATA_VALIDATON--------------//
   
   //-----------BEGINING_OF_USER_PROMPTING_METHODS_THAT_SEEM_KINDA_REDUNDANT_BUT_IDK ¯\_(ツ)_/¯-------//
   
   
    public String returnLoginStatus(String userNameArg, String userPassArg)
    {
        if (userNameArg.equals(this.getUserName()) && userPassArg.equals(this.getPassword()))
        {
            return "Welcome " + this.FirstName + " " +this.LastName + " it is great to see you again.";
        }
        return "Username or password incorrect, please try again";
    }
    
    public String registerUser()
    {
        // checks if the username and password are valid for registration and returns a string to the user either confirming success or prompting them to retry
        if (checkPasswordComplexity() && checkUsername())
        {
            return "Username and Password successfully captured";
        } 
        
        if (!checkPasswordComplexity() && !checkUsername())
        {
            return "Password must be at least 8 characters and contain at least 1: digit, special character, capital letter and username must contain an underscore and be no more than 5 Characters in length, please try again"; 
        } else
            
        {
            
            if (!checkPasswordComplexity())
            {

                // add correct message
                return "Password must be at least 8 characters and contain at least 1: digit, special character, capital letter, please try again";
            }

            if (!checkUsername())
            {
                return "Username is not correctly formatted please ensure that your username contains an underscore and is no more than 5 Characters in length";
            }
            return null;
        }
    }
//-----------END_OF_USER_PROMPTING_METHODS_THAT_SEEM_KINDA_REDUNDANT_BUT_IDK ¯\_(ツ)_/¯-------//
}
