// Michael French
// ST10195824
package prog5121poe;

//import javax.swing.*;
// http://tutorials.jenkov.com/java-regex/matcher.html
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class LogIn
{

    private String UserName;
    private String FirstName;
    private String LastName;
    private String Password;

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

    public boolean checkUsername()
    {
        // check to make sure the username is less than 5 characters and that the username contains an underscore
        if (this.UserName.length() <= 5 && this.UserName.contains("_"))
        {
            return true;
        }
        return false;
    }
    
    public boolean logUserIn(String userNameArg, String userPassArg)
    {
        if (userNameArg.equals(this.getUserName()) && userPassArg.equals(this.getPassword()))
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

    public String registerUser()
    {

        if (checkPasswordComplexity() && checkUsername())
        {
            //JOptionPane.showMessageDialog(null, "Username and Password successfully captured");
            return "Username and Password successfully captured";
        } else

        {
            if (!checkPasswordComplexity())
            {

                // add correct message
                return "Password must be at least 8 characters and contain at least 1: digit, special character, capital letter, please try agin ";
            }
        }

        if (!checkUsername())
        {
            return " Username is not correctly formattedplease ensure that your username contains an underscore and is no more than 5 Characters in length";
        }
        return null;
    }

}
