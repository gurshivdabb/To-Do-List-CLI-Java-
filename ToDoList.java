import java.util.Scanner;

public class ToDoList implements Home, Addable, Deletable, Editable {
    public static void main(String[] args) {
        TaskList list = new TaskList(); // creating new task list

        // display welcome message and home screen
        ToDoList toDoList = new ToDoList();
        toDoList.welcomeMessage();
        toDoList.homeScreen(list);
    } // main()

    @Override
    public void homeScreen(TaskList list) {
        Scanner sc = new Scanner(System.in);
        String option = "";

        // keep displating option until the option is not 5 (to end the loop)
        while (!option.equals("5")) {
            System.out.println("1. Add Task");
            System.out.println("2. View Task");
            System.out.println("3. Edit Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Pick your choice (1-5): ");

            option = sc.next();
            options(option, sc, list);

            // if 5, then exit
            if (option.equals("5")) {
                System.out.println("-----EXIT-----");
                System.out.println();
                break;
            }
        }
        sc.close();
    } // homeScreen()

    /**
     * options()
     * 
     * gives user all the options to select and executes those options
     * depending on what the user selected
     * 
     * @param option - String option (what the user selected)
     * @param sc - scanner
     * @param list - task list
     */
    public void options(String option, Scanner sc, TaskList list) {
        switch (option) {
            case "1" -> {
                System.out.println();

                // create and add task
                Task task = createTask(sc);
                addTask(list, task);

                System.out.println();
                System.out.println("Task Added.");
                System.out.println();
            }
            case "2" -> {
                // view task
                System.out.println();
                System.out.println("View Task");
                System.out.println();
                list.viewList();
            }
            case "3" -> {
                // edit task
                System.out.println();
                System.out.println("Edit Task");
                System.out.println();
                editMenu(list, sc);
            }
            case "4" -> {
                // delete task
                System.out.println();
                deleteMenu(list, sc);
                System.out.println();
                System.out.println("Task Deleted");
                System.out.println();
            }
            case "5" -> {
                System.out.println();
            }
            default -> {
                System.out.println();
                System.out.println("Please choose the correct option");
                System.out.println();
            }
        }
    } // options()

    @Override
    public Task createTask(Scanner sc) {
        sc.nextLine();
        System.out.print("Task Name: ");
        String name = sc.nextLine();
        System.out.print("Description: ");
        String description = sc.nextLine();
        return new Task(name, description);
    } // createTask()

    @Override
    public void addTask(TaskList list, Task task) {
        list.addLast(task);
    } // addTask()

    /**
     * selectTask()
     * 
     * selects and returns the task from the list
     * based on the id input by the user
     * 
     * @param list - task list
     * @param sc - scanner
     * @return - returns task if found, else returns null
     */
    public Task selectTask(TaskList list, Scanner sc) {
        boolean isCorrectID = false;

        while (!isCorrectID) {
            System.out.print("Please Select the Task ID: ");
            String input = sc.nextLine();

            try {
                int id = Integer.parseInt(input);
                Task task = list.getTaskById(id); // gets task by id

                if (task != null) { // if task found
                    return task;
                } else {
                    System.out.println("The ID is incorrect. Please enter the correct id.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }

        return null;
    }

    @Override
    public void deleteMenu(TaskList list, Scanner sc) {
        // if list is empty
        if (list.isEmpty()) {
            System.out.println("The list is empty. Nothing to delete.");
            return;
        }

        sc.nextLine();
        System.out.println("Which task would you like to delete:");
        list.viewList();

        Task task = selectTask(list, sc);
        boolean isCorrectTask = false;

        while (!isCorrectTask) {
            // if task exist, delete it
            if (task != null) {
                isCorrectTask = deleteTask(list, task);
            } else {
                System.out.println("Please select the correct id for the task.");
            }
        }

    } // deleteMenu()

    @Override
    public boolean deleteTask(TaskList list, Task task) {
        return list.delete(task);
    } // deleteTask()

    @Override
    public void editMenu(TaskList list, Scanner sc) {
        // if list is empty
        if (list.isEmpty()) {
            System.out.println("The list is empty. Nothing to edit.");
            return;
        }

        sc.nextLine();
        list.viewList();

        System.out.println();
        System.out.println("Do you want to edit the");
        System.out.println("1. Name");
        System.out.println("2. Description");
        System.out.println("3. Status");

        boolean isCorrect = false;

        while (!isCorrect) {
            System.out.print("Please enter the number (1-3): ");
            String input = sc.nextLine();
            try {
                int num = Integer.parseInt(input);
                switch (num) {
                    // edit name
                    case 1 -> {
                        editName(list, sc);
                        isCorrect = true;
                    }
                    // edit description
                    case 2 -> {
                        editDescription(list, sc);
                        isCorrect = true;
                    }
                    // edit status
                    case 3 -> {
                        editStatus(list, sc);
                        isCorrect = true;
                    }
                    default -> {
                        System.out.println("Please enter the correct number.");
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }
    } // editMenu()

    @Override
    public void editName(TaskList list, Scanner sc) {
        list.viewList();
        Task task = selectTask(list, sc);

        // asks the user to enter new name
        System.out.print("Please enter a new task name: ");
        String newName = sc.nextLine();
        task.setName(newName);

        System.out.println("Name changed.");
        System.out.println();
    }

    @Override
    public void editDescription(TaskList list, Scanner sc) {
        list.viewList();
        Task task = selectTask(list, sc);
        
        // asks the user to enter new description
        System.out.print("Please enter a new task description: ");
        String newDescription = sc.nextLine();
        task.setDescription(newDescription);

        System.out.println("Description changed.");
        System.out.println();
    }

    @Override
    public void editStatus(TaskList list, Scanner sc) {
        list.viewList();
        Task task = selectTask(list, sc);

        // changes the status:
        //      true -> false
        //      false -> true
        boolean status = task.getStatus();

        status = !status; // change happens here
        task.setStatus(status); // setting the status
        
        System.out.println("Status changed.");
        System.out.println();
    }
}
