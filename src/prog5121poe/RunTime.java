// Michael French
// ST10195824
package prog5121poe;

import javax.swing.*;

public class RunTime
{

    LogIn registeration = new LogIn();

    public int mainMenu()
    {
        int chosenMenu = 0;
        boolean run = true;
        String userInput;
        while (run)
        {
            // the options displayed to the user
            userInput = JOptionPane.showInputDialog(null,
                    "Please enter a selection: \n"
                    + "\t1. Register user\n"
                    + "\t2. Login User\n"
                    + "\t3. Quit\n",
                    "Login or Register", JOptionPane.QUESTION_MESSAGE);
            // auto quits the menu if the user doent enter a value
            if ((userInput == null) || (userInput.isEmpty()))
            {
                chosenMenu = 3;
            } else
            {
                //assigns the menu selected by the user to the methods output
                chosenMenu = Integer.parseInt(userInput);
            }

            if ((chosenMenu < 1) || (chosenMenu > 3))
            {
                //validates that the user entered a real option if they didnt the menu is shown again
                JOptionPane.showMessageDialog(null,
                        "Invalid input",
                        "Error detected",
                        JOptionPane.ERROR_MESSAGE);
            } else
            {
                run = false;
            }
        }
        //outputs the value corresponding to the menu chosen by the user
        return chosenMenu;
    }

    public void subMenu(int chosenSubMenu)
    {
        // only 1 LogIn object is used currently as there is only be one user required for the scope of task 1.

        // registration menu 
        if (chosenSubMenu == 1)
        {
            // creates a custom Dialog to accsept 
            int result;
            JFrame frame = new JFrame("Registeration");
            JTextField userField = new JTextField("Enter a username");
            JTextField passField = new JTextField("Enter a password");
            JTextField nameField = new JTextField("Enter a name");
            JTextField lastNameField = new JTextField("Enter a surname");
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

            while (!registeration.registerUser().equals("Username and Password successfully captured"))
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
        } else
        {
            if (chosenSubMenu == 2)
            {
                int result;
                JFrame frame = new JFrame("Login");
                JTextField logUserField = new JTextField("Enter your username");
                JTextField logPassField = new JTextField("Enter your password");
                String message = "Please enter your username and password.";

                result = JOptionPane.showOptionDialog(frame, new Object[]
                {
                    message, logUserField, logPassField
                }, "Login", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                if (result == JOptionPane.OK_OPTION)
                {
                    JOptionPane.showMessageDialog(null, registeration.returnLoginStatus(logUserField.getText(), logPassField.getText()));
                    if (registeration.logUserIn(logUserField.getText(), logPassField.getText()))
                    {
                        EasyKanbanMenu();
                    }
                }
            }
        }
    }

    public int EasyKanbanMenu()
    {
        
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");
        
        
        int chosenMenu = 0;
        boolean run = true;
        String userInput;
        while (run)
        {
            // the options displayed to the user
            userInput = JOptionPane.showInputDialog(null,
                    "Please enter a selection: \n"
                    + "\t1. Register user\n"
                    + "\t2. Login User\n"
                    + "\t3. Quit\n",
                    "Login or Register", JOptionPane.QUESTION_MESSAGE);
            // auto quits the menu if the user doent enter a value
            if ((userInput == null) || (userInput.isEmpty()))
            {
                chosenMenu = 3;
            } else
            {
                //assigns the menu selected by the user to the methods output
                chosenMenu = Integer.parseInt(userInput);
            }

            if ((chosenMenu < 1) || (chosenMenu > 3))
            {
                //validates that the user entered a real option if they didnt the menu is shown again
                JOptionPane.showMessageDialog(null,
                        "Invalid input",
                        "Error detected",
                        JOptionPane.ERROR_MESSAGE);
            } else
            {
                run = false;
            }
        }
        //outputs the value corresponding to the menu chosen by the user
        return chosenMenu;
        
    }

    
        
    

}
