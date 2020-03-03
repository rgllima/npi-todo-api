package br.ufc.quixada.npi.todoapi.respository;

import br.ufc.quixada.npi.todoapi.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    @Query("SELECT task FROM Task task WHERE task.id=(:id)")
    Task findById(@Param("id") Long id);

    @Query("SELECT new Task (t.id, t.title, t.description, t.project, t.date, t.time, t.checked, t.createdAt) FROM Task t WHERE t.project=(:p_id)")
    List<Task> findByProject(@Param("p_id") Long id);

}
