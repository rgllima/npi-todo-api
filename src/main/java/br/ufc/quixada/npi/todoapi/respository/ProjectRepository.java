package br.ufc.quixada.npi.todoapi.respository;

import br.ufc.quixada.npi.todoapi.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

    Project findById(int id);

    @Query(value = "SELECT new Project (p.id, p.title, p.description, p.color, p.createdAt) FROM Project p")
    List<Project> findAll();

    @Transactional
    @Modifying
    @Query(value = "UPDATE Project p SET p.title=(:title) WHERE p.id=(:id)")
    void updateTitle(@Param("id") int id, @Param("title") String title);

    @Transactional
    @Modifying
    @Query("UPDATE Project p SET p.description=(:description) WHERE p.id=(:id)")
    void updateDescription(@Param("id") int id, @Param("description") String description);

    @Transactional
    @Modifying
    @Query("UPDATE Project p SET p.color=(:color) WHERE p.id=(:id)")
    void updateColor(@Param("id") int id, @Param("color") String color);
}
