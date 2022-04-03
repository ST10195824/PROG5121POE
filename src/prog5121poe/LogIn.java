// Michael French
// ST10195824
package prog5121poe;

import javax.swing.*;
// http://tutorials.jenkov.com/java-regex/matcher.html

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class LogIn {

    String UserName;
    String FirstName;
    String LastName;
    String Password;

    public LogIn() {

    }
//____________DATA_VALIDATION_______________//

    public boolean UsernameValidation(String rawUserName) {

        // check to make sure the username is less than 5 characters and that tyhe username contains an underscore
        if (rawUserName.length() > 5 | !rawUserName.contains("_")) {
            JOptionPane.showMessageDialog(null, "Username must contain an underscore and cannot be more than 5 characters in length, please try again");
            return false;
        } else {
            JOptionPane.showMessageDialog(null, "Username successfully captured");
            this.UserName = rawUserName;
            return true;
        }
    }

    public boolean PasswordValidation(String rawPassword) {
        // patterns to go through to check for needed characters
        Pattern CapitalLetter = Pattern.compile("[A-Z]");
        Pattern SpecialCharacter = Pattern.compile("[!#$%&'()*+,-./:;<=>?@^_`{|}~]");
        Pattern Number = Pattern.compile("[0-9]");

        // matchers to return if the character was found in the string
        Matcher checkForSpecialCharacter = SpecialCharacter.matcher(rawPassword);
        Matcher checkForCapitalLetter = CapitalLetter.matcher(rawPassword);
        Matcher checkForNumber = Number.matcher(rawPassword);

        // check that password is longer than 7 characters has a capital letter, a number and a special character
        if (rawPassword.length() >= 8 && checkForSpecialCharacter.find() &&  checkForCapitalLetter.find() && checkForNumber.find()) {
            JOptionPane.showMessageDialog(null, "Password successfully captured");
            this.Password = rawPassword;
            return true;
        } else {
             JOptionPane.showMessageDialog(null,"""
                               Password must be at least 8 characters and contain at least 1: digit, special character, capital letter, 
                                please try agin""");
            return false;
        }
    }
}
