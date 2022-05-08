// Michael French
// ST10195824
package prog5121poe;

import javax.swing.*;

public class RunTime
{
 
    public int mainMenu()
    {
        int chosenMenu = 0;
        boolean run = true;
        String userInput;
        while (run)
        {
            userInput = JOptionPane.showInputDialog(null,
                    "Please enter a selection: \n"
                    + "\t1. Register user\n"
                    + "\t2. Login User\n"
                    + "\t3. Quit\n",
                    "Login or Register", JOptionPane.QUESTION_MESSAGE);

            if ((userInput == null) || (userInput.isEmpty()))
            {
                chosenMenu = 3;
            } else
            {
                chosenMenu = Integer.parseInt(userInput);
            }

            if ((chosenMenu < 1) || (chosenMenu > 3))
            {
                JOptionPane.showMessageDialog(null,
                        "Invalid input",
                        "Error detected",
                        JOptionPane.ERROR_MESSAGE);
            } else
            {
                run = false;
            }
        }

        return chosenMenu;
    }

    public boolean subMenu(int chosenSubMenu)
    {
        LogIn registeration = new LogIn();

        if (chosenSubMenu == 1)
        {
            int result;
            JFrame frame = new JFrame("Registeration");
            JTextField userField = new JTextField("user");
            JTextField passField = new JTextField("psasword");
            JTextField nameField = new JTextField("name");
            JTextField lastNameField = new JTextField("lastname");
            String message = "Please enter your name, surname, username and password.";
            
             result = JOptionPane.showOptionDialog(frame, new Object[]
                {
                    message, nameField, lastNameField, userField, passField
                }, "Login", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                if (result == JOptionPane.OK_OPTION)
                {
                    registeration.setFirstName(nameField.getText());
                    registeration.setLastName(lastNameField.getText());
                    registeration.setUserName(userField.getText());
                    registeration.setPassword(passField.getText()); 
                }
                
            while (registeration.registerUser() != "Username and Password successfully captured" )
            {
                JOptionPane.showMessageDialog(null, registeration.registerUser());
               
                 result = JOptionPane.showOptionDialog(frame, new Object[]
                {
                    message, nameField, lastNameField, userField, passField
                }, "Login", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                if (result == JOptionPane.OK_OPTION)
                {
                    registeration.setFirstName(nameField.getText());
                    registeration.setLastName(lastNameField.getText());
                    registeration.setUserName(userField.getText());
                    registeration.setPassword(passField.getText()); 
                }
               
            }
            JOptionPane.showMessageDialog(null, registeration.registerUser());
            return true;
        }
        return false;
        
    }

}
