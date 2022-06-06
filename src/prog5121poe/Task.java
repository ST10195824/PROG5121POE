/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog5121poe;
//way to increment the taskNumber automatically based on the number of existing constructor methods.
// this is best used for thread saftey when doing multithreading but it works for this purpose too.

import java.util.concurrent.atomic.AtomicInteger;

public class Task
{

    private static final AtomicInteger aggregator = new AtomicInteger();

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
        //this might fuck shit up later
        taskNumber = aggregator.incrementAndGet();
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
        }
        else
            return "Please enter a task description of less than 50 characters";
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

    public void setTaskDuration(double taskDuration)
    {
        this.taskDuration = taskDuration;
    }

    public String getID()
    {
        return ID;
    }

    
    
    /* first two letters of the Task
    Name, a colon (:), the Task Number, a colon (:)
    and the last three letters of the developer
    assigned to the task’s name. The ID should be
    displayed in all caps:
    AD:0:INA*/
    
    public void createtaskID()
    {
        this.ID = "a bunch of string manipulation" ;
    }

}
