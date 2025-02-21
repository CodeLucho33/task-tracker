import cli.TaskCLI;
import controller.TaskController;
import model.Task;
import repository.TaskRepository;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskController taskController = new TaskController();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            taskController.showMenu();
            int option = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (option) {
                case 1 -> taskController.createTask();
                case 2 -> taskController.updateTask();
                case 3 -> taskController.listTasks(); // Nueva opción
                case 4 -> taskController.deleteTask();
                case 5 -> exit = true;
                default -> System.out.println("Opción no válida.");
            }
        }
        System.out.println("¡Gracias por usar Task Tracker CLI!");
    }
}
