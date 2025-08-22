/**
 * This interface handles the adding functionalities of the class
 */

import java.util.Scanner;

public interface Addable {
    /**
     * createTask()
     * 
     * creates a new task
     * 
     * @param sc - scanner
     * @return the new task created by the user
     */
    Task createTask(Scanner sc);

    /**
     * addTask()
     * 
     * adds the task to the list
     * 
     * @param list - the task list
     * @param task - task to be added in the list
     */
    void addTask(TaskList list, Task task);
}