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
<<<<<<< Updated upstream
        boolean run = true;
        while (run)
        {
            //assigns the selected submenu to the input of the submenu method
            int chosenSubMenu = worker.mainMenu();
            if (chosenSubMenu == 3)
            {
                System.exit(0);
            }
            worker.subMenu(chosenSubMenu);
        }

=======
        worker.subMenu(worker.mainMenu());

        System.exit(0);
>>>>>>> Stashed changes
    }

}
