/**
 * Home Interface
 */

public interface Home {
    /**
     * welcomeMessage()
     * 
     * prints the welcome message
     */
    public default void welcomeMessage() {
        System.out.println("Welcome to To-Do-List.");
    }

    /**
     * homeScreen()
     * 
     * This shows the home screen interface to the user
     * 
     * @param list - the task list the homescreen will show to the user
     */
    void homeScreen(TaskList list);
}
