/**
 * Task class used to create Task object, which we will
 * be using in creating tasks.
 */

public class Task {
    private String name;
    private String description;
    private boolean status; // whether the task is COMPLETED or NOT
    private int id; // unique ID per task
    private static int idCounter = 1;

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
        status = false;
        id = idCounter++; // increments the id when a new Task is created
    }

    /**
     * getId()
     * 
     * Getter method
     * 
     * @return id of the task
     */
    public int getId() {
        return id;
    }

    /**
     * getName()
     * 
     * Getter method
     * 
     * @return name of the task
     */
    public String getName() {
        return name;
    }

    /**
     * getDescription()
     * 
     * Getter method
     * 
     * @return description of the task
     */
    public String getDescription() {
        return description;
    }

    /**
     * getStatus()
     * 
     * Getter method
     * 
     * @return status of the task
     */
    public boolean getStatus() {
        return status;
    }

    /**
     * setName()
     * 
     * sets new name of the task
     * 
     * @param newName - the new name of the task
     */
    public void setName(String newName) {
        name = newName;
    }

    /**
     * setDescription()
     * 
     * sets new task description
     * @param newDescription - new task description
     */
    public void setDescription(String newDescription) {
        description = newDescription;
    }

    /**
     * setStatus()
     * 
     * sets new status
     * 
     * @param newStatus - new task status
     */
    public void setStatus(boolean newStatus) {
        status = newStatus;
    }

    /**
     * equals()
     * 
     * checks whether this task is equivalent to otherTask
     * @param otherTask - the other task which ic being compared to this task
     * @return boolean true if the task's unique id matches or false if it does not match
     */
    public boolean equals(Task otherTask) {
        return this.id == otherTask.getId();
    }

    /**
     * viewTask()
     * 
     * This method prints everything the task has,
     * including the id, name, description, and status.
     */
    public void viewTask() {
        System.out.println("ID: " + id + "\n" + 
                "Task: " + name + "\n" +
                "Description: " + description + "\n" +
                "Progress: " + (status ? "Done" : "Pending") + "\n");
    }
}