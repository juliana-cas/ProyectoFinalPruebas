package cue.edu.ProyectoFinalPruebas.repository;

import cue.edu.ProyectoFinalPruebas.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
