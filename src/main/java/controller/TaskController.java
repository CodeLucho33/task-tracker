package controller;

import model.Task;
import repository.TaskRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class TaskController {
    private final TaskRepository taskRepository;

    public TaskController() {
        this.taskRepository = new TaskRepository();
    }
    public void showMenu() {
        System.out.println("\n--- Task Tracker CLI ---");
        System.out.println("1. Crear tarea");
        System.out.println("2. Actualizar tarea");
        System.out.println("3. Listar tareas");
        System.out.println("4. Eliminar tarea");
        System.out.println("5. Salir");
        System.out.print("Selecciona una opción: ");
    }


    public void updateTask() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa el ID de la tarea a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        Optional<Task> optionalTask = taskRepository.getTaskById(id);
        if (optionalTask.isEmpty()) {
            System.out.println("No se encontró ninguna tarea con el ID especificado.");
            return;
        }

        Task taskToUpdate = optionalTask.get();

        System.out.print("Ingresa la nueva descripción: ");
        String newDescription = scanner.nextLine();
        taskToUpdate.setDescription(newDescription);

        System.out.print("Ingresa el nuevo estado (todo, in-progress, done): ");
        String newStatus = scanner.nextLine();
        taskToUpdate.setStatus(newStatus);

        taskRepository.updateTask(taskToUpdate);

        System.out.println("¡Tarea actualizada exitosamente!");
    }


    // Agregar esta función en TaskController.java
    public void createTask() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa la descripción de la tarea: ");
        String description = scanner.nextLine();

        System.out.print("Ingresa el estado de la tarea (todo, in-progress, done): ");
        String status = scanner.nextLine();

        // Crear la tarea sin ID, ya que se asigna automáticamente en el repositorio
        Task newTask = new Task(0, description, status, LocalDateTime.now(), LocalDateTime.now());
        taskRepository.addTask(newTask);

        System.out.println("¡Tarea creada exitosamente!");
    }


    public void listTasks() {
        List<Task> tasks = taskRepository.getAllTasks();

        if (tasks.isEmpty()) {
            System.out.println("No hay tareas registradas.");
            return;
        }

        System.out.println("\n--- Lista de Tareas ---");
        tasks.forEach(task ->
                System.out.println("ID: " + task.getId() +
                        " | Descripción: " + task.getDescription() +
                        " | Estado: " + task.getStatus() +
                        " | Creada: " + task.getCreatedAt() +
                        " | Actualizada: " + task.getUpdatedAt())
        );
    }

public void deleteTask() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa el ID de la tarea a eliminar: ");

        int id = scanner.nextInt();
        scanner.nextLine();
        Optional<Task> optionalTask = taskRepository.getTaskById(id);
        if (optionalTask.isEmpty()) {
            System.out.println("La tarea no existe");
        }else {
            taskRepository.deleteTask(id);
        }
}
}
