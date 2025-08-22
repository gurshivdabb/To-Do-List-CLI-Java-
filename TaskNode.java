/**
 * Node class specific to Task
 * used to create a linked list like data structure
 */

public class TaskNode {
    private Task task;
    private TaskNode next;

    public TaskNode (Task task) {
        this.task = task;
        next = null;
    }

    /**
     * getNext()
     * 
     * Getter method
     * 
     * @return the pointer to next node
     */
    public TaskNode getNext() {
        return next;
    }
    
    /**
     * getTask()
     * 
     * Getter method
     * 
     * @return the task
     */
    public Task getTask() {
        return task;
    }

    /**
     * setNext()
     * 
     * sets the pointer of the next node to
     * the node pointer in the parameter
     * @param next - the pointer to the node we set the next to
     */
    public void setNext(TaskNode next) {
        this.next = next;
    }
}