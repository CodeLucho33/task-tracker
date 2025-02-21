package cli;

import controller.TaskController;

import java.util.Scanner;

public class TaskCLI {
    private final TaskController taskController;

    public TaskCLI() {
        this.taskController = new TaskController();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Task Tracker CLI ---");
            System.out.println("1. Crear nueva tarea");
            System.out.println("2. Actualizar tarea");
            System.out.println("3. Salir");
            System.out.println("4. Eliminar tarea");
            System.out.print("Selecciona una opción: ");

            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    System.out.print("Ingresa la descripción de la nueva tarea: ");
                    String description = scanner.nextLine();

                    System.out.print("Ingresa el estado inicial (todo, in-progress, done): ");
                    String status = scanner.nextLine();

                    taskController.createTask();
                    break;
                case "2":
                    System.out.print("Ingresa el ID de la tarea a actualizar: ");
                    int id = Integer.parseInt(scanner.nextLine());

                    System.out.print("Ingresa la nueva descripción: ");
                    String newDescription = scanner.nextLine();

                    System.out.print("Ingresa el nuevo estado (todo, in-progress, done): ");
                    String newStatus = scanner.nextLine();

                    taskController.updateTask();
                    break;
                case "3":
                    running = false;
                    System.out.println("Saliendo...");
                    break;
                    case "4":
                        taskController.deleteTask();
                        break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }



        }

        scanner.close();
    }
}
