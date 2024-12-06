package cue.edu.ProyectoFinalPruebas.integracion;

import cue.edu.ProyectoFinalPruebas.model.Task;
import cue.edu.ProyectoFinalPruebas.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TaskIntegrationTest {

    @Autowired
    private TaskRepository taskRepository;

    @Test
    public void testCreateAndFindTask() {
        Task task = new Task();
        task.setTitle("Integration Task");
        task.setDescription("Integration Description");
        task.setCompleted(false);

        Task savedTask = taskRepository.save(task);
        Task foundTask = taskRepository.findById(savedTask.getId()).orElse(null);

        assertNotNull(foundTask);
        assertEquals("Integration Task", foundTask.getTitle());
    }
}

