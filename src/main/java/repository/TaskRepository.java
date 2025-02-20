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

public class TaskRepository {
    private static final String FILE_PATH = "tasks.json";
    private final ObjectMapper objectMapper;


    public TaskRepository() {
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
    public void addTask(Task task) {
        List<Task> tasks = getAllTasks();
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
}