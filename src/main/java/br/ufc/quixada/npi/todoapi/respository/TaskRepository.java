package br.ufc.quixada.npi.todoapi.respository;

import br.ufc.quixada.npi.todoapi.model.Project;
import br.ufc.quixada.npi.todoapi.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    Task findById(int id);

    @Query("SELECT new Task (t.id, t.title, t.description, t.project, t.date, t.time, t.checked, t.createdAt) FROM Task t")
    List<Task> findAll();

    @Query("SELECT new Task (t.id, t.title, t.description, t.project, t.date, t.time, t.checked, t.createdAt) FROM Task t WHERE t.project=(:p_id)")
    List<Task> findByProject(@Param("p_id") int id);

    @Transactional
    @Modifying
    @Query("UPDATE Task t SET t.title=(:title) WHERE t.id=(:id)")
    void updateTitle(@Param("id") int id, @Param("title") String title);

    @Transactional
    @Modifying
    @Query("UPDATE Task t SET t.description=(:description) WHERE t.id=(:id)")
    void updateDescription(@Param("id") int id, @Param("description") String description);

    @Transactional
    @Modifying
    @Query("UPDATE Task t SET t.project=(:project) WHERE t.id=(:id)")
    void updateProject(@Param("id") int id, @Param("project") Project project);

    @Transactional
    @Modifying
    @Query("UPDATE Task t SET t.date=(:date) WHERE t.id=(:id)")
    void updateDate(@Param("id") int id, @Param("date") String date);

    @Transactional
    @Modifying
    @Query("UPDATE Task t SET t.time=(:time) WHERE t.id=(:id)")
    void updateTime(@Param("id") int id, @Param("time") String time);

    @Transactional
    @Modifying
    @Query("UPDATE Task t SET t.checked=(:value) WHERE t.id=(:id)")
    void updateChecked(@Param("id") int id, @Param("value") boolean value);
}
