// Michael French
// ST10195824
package prog5121poe;

import javax.swing.*;

public class RunTime
{
    LogIn registeration = new LogIn();
    
    public int entranceHallMenu()
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
    
    public void registrationMenu()
    {
        // creates a custom Dialog to accept registration info
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
    }
    
    public boolean loginMenu()
    {
        // custom dialog for user login
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
                // boolean determines whether user is taken to the EasyKanban menu
                return true;
            }
        }
        return false;
    }
    
    public int EasyKanbanMenu()
    {
        
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");
        
        int chosenMenu = 0;
        boolean run = true;
        String userInput;
        //dialog will continue to be reshown when user enters invalid information
        while (run)
        {
            // the options displayed to the user
            userInput = JOptionPane.showInputDialog(null,
                    "Please enter a selection: \n"
                    + "\t1. Add tasks\n"
                    + "\t2. Show report\n"
                    + "\t3. Quit\n",
                    "EasyKanban", JOptionPane.QUESTION_MESSAGE);
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
        return chosenMenu;
        
    }
    
    public void addTaskSubMenu()
    {
        int numOfTasks = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the number of tasks you wish to create."));
        final String[] statusOptions =
        {
            "To Do", "Done", "Doing"
        };
        Task[] taskArray = new Task[numOfTasks];
        double totalHours = 0;
        //--------- LOOP_TO_COLLECT_TASK_INFO-----------------//
        for (int i = 0; i < numOfTasks; i++)
        {
            //declaration of task object array
            taskArray[i] = new Task();
            int result;
            boolean inputsAreValid = false;
            while (!inputsAreValid)
            {
                JFrame frame = new JFrame("Add Tasks");
                JTextField taskName = new JTextField("Enter the task name");
                JTextField taskDesc = new JTextField("Enter a Description");
                JTextField devDets = new JTextField("Enter the developer name");
                JTextField taskDuration = new JTextField("Enter the estimated task duration in hours");
                //a combobox is used for status as there can only be 3 options 
                JComboBox statusSelect = new JComboBox(statusOptions);
                //sets the option selected by default
                statusSelect.setSelectedIndex(0);
                String message = "please enter all task details:";
                result = JOptionPane.showOptionDialog(frame, new Object[]
                {
                    message, taskName, taskDesc, devDets, taskDuration, statusSelect
                }, "Add Task", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                
                if (result == JOptionPane.OK_OPTION)
                {
                    // VALIDATION AND ASSIGNMENT
                    taskArray[i].setTaskName(taskName.getText());
                    taskArray[i].setDevDetails(devDets.getText());
                    taskArray[i].setTaskStatus((String) statusSelect.getSelectedItem());
                    // checks length less than or equal to 50 and if a number was entered for duration
                    inputsAreValid = (taskArray[i].setTaskDuration(taskDuration.getText()) && taskArray[i].checkTaskDescription(taskDesc.getText()));
                    if (!taskArray[i].setTaskDuration(taskDuration.getText()))
                    {
                        JOptionPane.showMessageDialog(null, "please enter a number value for task duration");
                    } else
                    {
                        totalHours = Task.returnTotalHours(taskArray[i].getTaskDuration());
                    }
                    //messages user based on wther the task desription is a valid length
                    JOptionPane.showMessageDialog(null,taskArray[i].setTaskDescription(taskDesc.getText()) ); 
                    
                    taskArray[i].createtaskID();
                }
            }
            JOptionPane.showMessageDialog(null, taskArray[i].printTaskDetails());
        }
        JOptionPane.showMessageDialog(null, "the total duration of all tasks is: " + totalHours);
        //returns the user to the EasyKanban menu instead of the enterance hall menu
        EasyKanbanMenu();
    }
    
    public void showReportSubMenu()
    {
        JOptionPane.showMessageDialog(null, "Coming Soon");
    }
    
    public void menuSwitcher(int selectedmenu)
    {
        //menu controller for the EasyKanban menu
        switch (selectedmenu)
        {
            case 1 ->
                addTaskSubMenu();
            case 2 ->
                showReportSubMenu();
            case 3 ->
                entranceHallMenu();
        }
    }
}
