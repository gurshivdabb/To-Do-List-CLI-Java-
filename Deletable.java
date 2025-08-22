/**
 * This interface handles the deleting functionalities of the class
 */

import java.util.Scanner;

public interface Deletable {
    /**
     * deleteMenu()
     * 
     * displays the delete menu and asks the user which task to delete
     * 
     * @param list - task list
     * @param sc - scanner
     */
    void deleteMenu(TaskList list, Scanner sc);
    /**
     * deleteTask()
     * 
     * deletes the task from the list if the task exists
     * 
     * @param list - task list
     * @param task - the task to be deleted
     * @return boolean value true if the task is deleted or false if not
     */
    boolean deleteTask(TaskList list, Task task);
}
