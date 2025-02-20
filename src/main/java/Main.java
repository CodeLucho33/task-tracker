import model.Task;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Task task = new Task(1, "Buy groceries", "todo", LocalDateTime.now(), LocalDateTime.now());
        System.out.println(task);
    }
}
