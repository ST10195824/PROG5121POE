/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog5121poe;

import java.util.ArrayList;

/**
 *
 * @author Michael
 */
public class TaskArray
{

    TaskArray()
    {

    }

    public Task[] returnDoneTasks(ArrayList<Task> tasks)
    {
        // iterates through all tasks adds all the tasks that have the "Done" status to an array of tasks
        Task[] doneTasksArr = new Task[tasks.size()];
        for (int i = 0; i < tasks.size(); i++)
        {
            Task arr = tasks.get(i);
            if (arr.getTaskStatus().equals("Done"))
            {
                doneTasksArr[i] = arr;
            }

        }
        return doneTasksArr;
    }

    public double returnMaxTaskDuration(ArrayList<Task> tasks)
    {
        //keeps a "highest yet" variable while interating through the entiire array so that it finds the max value
        double maxDuration = 0;
        for (int i = 0; i < tasks.size(); i++)
        {
            Task arr = tasks.get(i);

            if (arr.getTaskDuration() > maxDuration)
            {
                maxDuration = arr.getTaskDuration();
            }
        }
        return maxDuration;
    }

    public Task taskNameSearch(String taskName, ArrayList<Task> tasks)
    {
        Task result = null;
        for (int i = 0; i < tasks.size(); i++)
        {
            Task arr = tasks.get(i);

            if (arr.getTaskName().equals(taskName))
            {
                result = arr;
            }
        }
        // in runtime check if result is null then message to user that no task was found
        return result;
    }

    public Task[] developerSearch(String dev, ArrayList<Task> tasks)
    {
        // iterates through all tasks adds all the tasks that have the correct dev to an array of tasks
        boolean onefound = false;
        Task[] devTasksArr = new Task[tasks.size()];
        for (int i = 0; i < tasks.size(); i++)
        {
            Task arr = tasks.get(i);
            if (arr.getDevDetails().equals(dev))
            {
                devTasksArr[i] = arr;
                onefound = true;
            }
        }
        //way to know if no dev was found
        if (onefound)
        {
            return devTasksArr;
        } else
            return null;
    }
    
    public Boolean taskDelete(String taskName, ArrayList<Task> tasks)
    {
        for (int i = 0; i < tasks.size(); i++)
        {
            if (tasks.get(i).getTaskName().equals(taskName))
            {
                tasks.remove(i);
                return true;
            }
        }
        // in runtime check if result is false then message to user that no task was found
        return false;
    }

    //END//
}
