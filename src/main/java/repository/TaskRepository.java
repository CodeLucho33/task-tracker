package repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import model.Task;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TaskRepository {
    private static final String FILE_PATH = "tasks.json";
    private final ObjectMapper objectMapper;
    private List<Task> tasks;




    public TaskRepository() {
        this.tasks = new ArrayList<>();  // Inicializa la lista vacía
        this.objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    // Leer el archivo JSON y convertirlo en una lista de tareas
    public List<Task> getAllTasks() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try {
            return objectMapper.readValue(file, new TypeReference<List<Task>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    // Guardar la lista de tareas en el archivo JSON
    private void saveTasks(List<Task> tasks) {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE_PATH), tasks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Agregar una nueva tarea
    // Agregar una nueva tarea con ID autoincremental
    public void addTask(Task task) {
        List<Task> tasks = getAllTasks();

        // Obtener el ID más alto de las tareas existentes y sumar 1
        int nextId = tasks.stream()
                .mapToInt(Task::getId)
                .max()
                .orElse(0) + 1;
        task.setId(nextId);

        tasks.add(task);
        saveTasks(tasks);
    }


    // Buscar una tarea por ID
    public Optional<Task> getTaskById(int id) {
        return getAllTasks().stream()
                .filter(task -> task.getId() == id)
                .findFirst();
    }

    // Actualizar una tarea existente
    public void updateTask(Task updatedTask) {
        List<Task> tasks = getAllTasks();
        tasks.stream()
                .filter(task -> task.getId() == updatedTask.getId())
                .forEach(task -> {
                    task.setDescription(updatedTask.getDescription());
                    task.setStatus(updatedTask.getStatus());
                    task.setUpdatedAt(LocalDateTime.now());
                });
        saveTasks(tasks);
    }

    // Eliminar una tarea por ID
    public void deleteTask(int id) {
        List<Task> tasks = getAllTasks();
        tasks.removeIf(task -> task.getId() == id);
        saveTasks(tasks);
    }

    public List<Task>  getTasksByStatus(String status) {
        // Leer todas las tareas desde el archivo JSON
        List<Task> tasks = getAllTasks();
        return tasks.stream()
                .filter(task -> task.getStatus().equalsIgnoreCase(status))
                .collect(Collectors.toList());
    }

    // Marcar tarea como in-progress
    public void markTaskInProgress(int id) {
        List<Task> tasks = getAllTasks();
        tasks.stream()
                .filter(task -> task.getId() == id)
                .forEach(task -> {
                    task.setStatus("in-progress");
                    task.setUpdatedAt(LocalDateTime.now());
                });
        saveTasks(tasks);
    }

    // Marcar tarea como done
    public void markTaskDone(int id) {
        List<Task> tasks = getAllTasks();
        tasks.stream()
                .filter(task -> task.getId() == id)
                .forEach(task -> {
                    task.setStatus("done");
                    task.setUpdatedAt(LocalDateTime.now());
                });
        saveTasks(tasks);
    }

}