import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Task class to represent a task
class Task {
    String name;
    int duration;

    // Constructor for the Task class
    public Task(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Task{name='" + name + "', duration=" + duration + '}';
    }
}

// TaskScheduler class containing methods to add tasks and run the scheduler
public class TaskScheduler {

    // List to store tasks
    static List<Task> tasks = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);  // Scanner to read input from user

    // Method to add a task to the task list
    public static void add_task() {
        System.out.print("Enter task name: ");
        String name = scanner.nextLine();
        System.out.print("Enter task duration in minutes: ");
        int duration = scanner.nextInt();
        scanner.nextLine();  // Consume newline character left by nextInt()

        Task newTask = new Task(name, duration);
        tasks.add(newTask);
        System.out.println("Task added: " + newTask);
    }

    // Method to run the scheduler and process the tasks
    public static void run_scheduler() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to run.");
            return;
        }

        System.out.println("\nStarting Task Scheduler...");
        for (Task task : tasks) {
            System.out.println("Running task: " + task.name + " for " + task.duration + " minutes");
            // Simulate task running by waiting for task duration
            try {
                Thread.sleep(task.duration * 1000);  // Duration is in seconds for simulation
            } catch (InterruptedException e) {
                System.out.println("Task interrupted: " + task.name);
            }
        }
        System.out.println("\nAll tasks completed.");
    }

    // Main method to execute the program
    public static void main(String[] args) {
        while (true) {
            // Display menu options
            System.out.println("\nTask Scheduler Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. Run Scheduler");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline character left by nextInt()

            switch (choice) {
                case 1:
                    add_task();  // Add a new task
                    break;
                case 2:
                    run_scheduler();  // Run the scheduler
                    break;
                case 3:
                    System.out.println("Exiting program...");
                    return;  // Exit the program
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
