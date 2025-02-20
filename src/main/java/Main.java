import model.Task;
import repository.TaskRepository;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        TaskRepository taskRepository = new TaskRepository();

        // Crear una nueva tarea
        Task newTask = new Task(1, "Complete the Task Tracker CLI", "todo", LocalDateTime.now(), LocalDateTime.now());
        taskRepository.addTask(newTask);

        // Mostrar todas las tareas
        System.out.println("Tareas:");
        taskRepository.getAllTasks().forEach(System.out::println);

        // Actualizar la tarea
        newTask.setDescription("Complete and test the Task Tracker CLI");
        newTask.setStatus("in-progress");
        taskRepository.updateTask(newTask);

        // Mostrar la tarea actualizada
        System.out.println("Tarea Actualizada:");
        taskRepository.getTaskById(1).ifPresent(System.out::println);

        // Eliminar la tarea
        taskRepository.deleteTask(1);

        // Mostrar todas las tareas después de eliminar
        System.out.println("Tareas después de eliminar:");
        taskRepository.getAllTasks().forEach(System.out::println);
    }
}