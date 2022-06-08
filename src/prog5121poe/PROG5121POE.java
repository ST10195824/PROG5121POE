// Michael French
// ST10195824
package prog5121poe;

public class PROG5121POE
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        //instantiates the menu system
        RunTime worker = new RunTime();
        boolean run = true;
        int selectedEasyKanbanMenu;
        while (run)
        {
            //assigns the selected submenu to the input of the submenu method
            int chosenSubMenu = worker.entranceHallMenu();
            switch (chosenSubMenu)
            {
                case 1 -> worker.registrationMenu();
                case 2 ->
                {
                    boolean userLogin = worker.loginMenu();
                    if (userLogin)
                    {   //application menu then using a method to switch to each otion if that menu
                        selectedEasyKanbanMenu = worker.EasyKanbanMenu();
                        worker.menuSwitcher(selectedEasyKanbanMenu);
                    }
                }
                case 3 -> System.exit(0);

            }
            
        }

    }

}
