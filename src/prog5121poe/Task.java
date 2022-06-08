/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog5121poe;
//way to increment the taskNumber automatically based on the number of existing constructor methods.
// this is best used for thread saftey when doing multithreading but it works for this purpose too.

import java.util.concurrent.atomic.AtomicInteger;

public final class Task
{

    private static final AtomicInteger aggregator = new AtomicInteger();
    private static double total = 0;
    //fields for task object
    private String taskName;
    private final int taskNumber;
    private String taskDescription;
    private String devDetails;
    private double taskDuration;
    private String ID;
    private String taskStatus;

    public Task()
    {
        taskNumber = aggregator.incrementAndGet() -1;
    }

    public Task(String taskName, String taskDescript, String devDetails, double taskDuration, String taskStatus)
    {
        this.taskName = taskName;
        this.taskDescription = taskDescript;
        this.devDetails = devDetails;
        this.taskDuration = taskDuration;
        this.taskStatus = taskStatus;
        this.taskNumber = aggregator.incrementAndGet() -1;
        createtaskID();
    }

    public String getTaskStatus()
    {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus)
    {
        this.taskStatus = taskStatus;
    }

   

    public String getTaskName()
    {
        return taskName;
    }

    public void setTaskName(String taskName)
    {
        this.taskName = taskName;
    }

    public int getTaskNumber()
    {
        return taskNumber;
    }

    public String getTaskDescription()
    {
        return taskDescription;
    }

    public String setTaskDescription(String taskDescription)
    {
        if (taskDescription.length() <= 50)
        {
            this.taskDescription = taskDescription;
            return "Task successfully captured";
        } else
        {
            return "Please enter a task description of less than 50 characters";
        }
    }

    public String getDevDetails()
    {
        return devDetails;
    }

    public void setDevDetails(String devDetails)
    {

        this.devDetails = devDetails;

    }

    public double getTaskDuration()
    {
        return taskDuration;
    }

    public boolean setTaskDuration(String taskDuration)
    {
        try
        {
            this.taskDuration = Double.parseDouble(taskDuration);
        } catch (NumberFormatException ex)
        {
            return false;
        }
        return true;
    }

    public String getID()
    {
        return ID;
    }

    public boolean checkTaskDescription(String taskDesc)
    {
        if (taskDesc.length() <= 50)
        {
            this.taskDescription = taskDesc;
            return true;
        } else
        {
            return false;
        }
    }
    
    public void createtaskID()
    {
        int nameLength = devDetails.length();
        String theID = this.taskName.substring(0, 2) + ":" + this.taskNumber + ":" + this.devDetails.substring(nameLength - 3, nameLength);
        this.ID = theID.toUpperCase();
    }

    public String printTaskDetails()
    {
        return "taskName: " + taskName + "\n"
                + "taskNumber: " + taskNumber + "\n"
                + "taskDescription: " + taskDescription + "\n"
                + "devDetails: " + devDetails + "\n"
                + "taskDuration: " + taskDuration + "\n"
                + "ID: " + ID + "\n"
                + "taskStatus: " + taskStatus;
    }

    public static double returnTotalHours(double duration)
    {
        total += duration;
        return total;
    }

}
