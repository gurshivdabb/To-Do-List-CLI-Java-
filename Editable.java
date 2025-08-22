/**
 * This interface handles the editing of the class
 */

import java.util.Scanner;

public interface Editable {
    /**
     * editMenu
     * 
     * displays the edit menu of a task, asking whether the user
     * want to edit the name, description, or status
     * 
     * @param list - list of the tasks
     * @param sc - scanner
     */
    void editMenu(TaskList list, Scanner sc);

    /**
     * editName()
     * 
     * asks the user to edit the task's name
     * 
     * @param list - list of the tasks
     * @param sc - scanner
     */
    void editName(TaskList list, Scanner sc);

    /**
     * editDescription()
     * 
     * asks the user to edit the task's description
     * 
     * @param list - list of the tasks
     * @param sc - scanner
     */
    void editDescription(TaskList list, Scanner sc);

    /**
     * edit Status()
     * 
     * asks the user to edit the task's status
     * 
     * @param list - list of the tasks
     * @param sc - scanner
     */
    void editStatus(TaskList list, Scanner sc);
}
