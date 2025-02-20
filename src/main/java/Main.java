import cli.TaskCLI;
import model.Task;
import repository.TaskRepository;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        TaskCLI taskCLI = new TaskCLI();
        taskCLI.start();
    }
}