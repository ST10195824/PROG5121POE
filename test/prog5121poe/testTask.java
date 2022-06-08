// Michael French
// ST10195824
package prog5121poe;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mfren
 */
public class testTask
{

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    public static final Task[] taskArr =
    {
        new Task("Create Add Task feature to add task users", "Create Login to authenticate users", "Robyn Harrison", 10, "To Do"),
        new Task("Create Add Task feature to add task users", "Create Login to authenticate users", "Mike Smith", 12, "Done"),
        new Task("Create Add Task feature to add task users", "Create Login to authenticate users", "Robyn Harrison", 55, "To Do"),
        new Task("Create Add Task feature to add task users", "Create Login to authenticate users", "Mike Smith", 11, "Doing"),
        new Task("Create Add Task feature to add task users", "Create Login to authenticate users", "Robyn Harrison", 1, "To Do")
    };

    public static final String[] ArrID =
    {
        "CR:0:SON",
        "CR:1:ITH",
        "CR:2:SON",
        "CR:3:ITH",
        "CR:4:SON"
    };

    @Test
    public void testCorrectSetTaskDescription()
    {
        Task testTask;
        testTask = new Task("Login Feature", "", "Robyn Harrison", 8, "To Do");
        String result = testTask.setTaskDescription("Create Login to authenticate users");
        String expectedResult = "Task successfully captured";
        assertEquals(expectedResult, result);
    }

    @Test
    public void testIncorrectSetTaskDescription()
    {
        Task testTask;
        testTask = new Task("Login Feature", "", "Robyn Harrison", 8, "To Do");
        String result = testTask.setTaskDescription("Create Login to authenticate users and some other stuff im not really "
                + "sure, this is sureley over fifty characters by now? "
                + "anyyyway ill stop typing now");
        String expectedResult = "Please enter a task description of less than 50 characters";
        assertEquals(expectedResult, result);
    }

    @Test
    public void testCorrectCheckTaskDescription()
    {
        Task testTask;
        testTask = new Task("Login Feature", "Create Login to authenticate users", "Robyn Harrison", 8, "To Do");
        boolean result = testTask.checkTaskDescription(testTask.getTaskDescription());
        boolean expectedresult = true;
        assertEquals(expectedresult, result);

    }

    @Test
    public void testcreatetaskID()
    {
        for (int i = 0; i < taskArr.length; i++)
        {
            assertEquals(ArrID[i], taskArr[i].getID());
        }
    }

    

    @Test
    public void testReturnTotalHours()
    {
        double result = 0;
        double expectedResult = 89.0;
        for (int i = 0; i < taskArr.length; i++)
        {
            result = Task.returnTotalHours(taskArr[i].getTaskDuration());
        }
        assertEquals(expectedResult, result, 0);
    }

}
