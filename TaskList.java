/**
 * TaskList class is a list of tasks using linkedlist type data structure.
 */

public class TaskList {
    private TaskNode head; // first node of the list
    private TaskNode tail; // last node of the list

    public TaskList() {
        head = null;
        tail = null;
    }

    /**
     * addLast()
     * 
     * Creates a task node and places it at the end of the list
     * 
     * @param task - Task variable created by the user
     */
    public void addLast(Task task) {
        TaskNode newNode = new TaskNode(task);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
    }

    /**
     * delete()
     * 
     * Deletes the task asked by the user to delete
     * If the task does not exist, it won't delete anything
     * 
     * @param task - Task variable to be deleted, if it exists in the list
     */
    public boolean delete(Task task) {
        TaskNode prev = null;
        TaskNode curr = head;

        while (curr != null) {
            if (curr.getTask().equals(task)) {
                if (prev != null) {
                    prev.setNext(curr.getNext());
                } else {
                    head = curr.getNext();
                    curr.setNext(null);
                }

                if (curr == tail) {
                    tail = prev;
                }

                return true;
            }

            prev = curr;
            curr = curr.getNext();
        }

        return false;
    }

    /**
     * isEmpty()
     * 
     * checks whether the list is empty or not
     * 
     * @return boolean value true if it is empty or false if not
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * getTaskById()
     * 
     * fetches the task searched by the user based on the task id
     * 
     * @param id - id of the task the user is looking for
     * @return - returns the task when found or null if not found
     */
    public Task getTaskById(int id) {
        TaskNode curr = head;

        while (curr != null) {
            if (curr.getTask().getId() == id) {
                return curr.getTask();
            }
            curr = curr.getNext();
        }

        return null;
    }

    /**
     * viewList()
     * 
     * views and prints all the tasks in the list
     * It prints first the pending tasks then the completed tasks
     */
    public void viewList() {
        // if task is empty
        if (this.isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }

        // print the pending tasks
        System.out.println("Task List:");
        System.out.println();
        System.out.println("Task Pending:");

        TaskNode curr = head;

        while (curr != null) {
            if (!curr.getTask().getStatus()) {
                curr.getTask().viewTask();
            }
            curr = curr.getNext();
        }

        curr = head; // reset curr

        //print the finished tasks
        System.out.println("Task Done:");

        while (curr != null) {
            if (curr.getTask().getStatus()) {
                curr.getTask().viewTask();
            }
            curr = curr.getNext();
        }
        System.out.println();
    }   
}
