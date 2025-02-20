package controller;

import model.Task;
import repository.TaskRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class TaskController {
    private final TaskRepository taskRepository;

    public TaskController() {
        this.taskRepository = new TaskRepository();
    }

    public void updateTask(int id, String newDescription, String newStatus) {
        List<Task> tasks = taskRepository.getAllTasks();

        if (tasks.isEmpty()) {
            System.out.println("No hay tareas registradas aún.");
            return;
        }

        Optional<Task> optionalTask = taskRepository.getTaskById(id);

        if (optionalTask.isPresent()) {
            Task taskToUpdate = optionalTask.get();
            taskToUpdate.setDescription(newDescription);
            taskToUpdate.setStatus(newStatus);
            taskRepository.updateTask(taskToUpdate);
            System.out.println("Tarea actualizada exitosamente.");
        } else {
            System.out.println("No se encontró ninguna tarea con el ID especificado.");
        }
    }

    // Agregar esta función en TaskController.java
    public void createTask(String description, String status) {
        List<Task> tasks = taskRepository.getAllTasks();
        int newId = tasks.size() + 1; // ID autoincremental básico

        Task newTask = new Task(newId, description, status, LocalDateTime.now(), LocalDateTime.now());
        taskRepository.addTask(newTask);

        System.out.println("Tarea creada exitosamente.");
    }

}
