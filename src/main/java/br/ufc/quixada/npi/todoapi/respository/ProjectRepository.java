package br.ufc.quixada.npi.todoapi.respository;

import br.ufc.quixada.npi.todoapi.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

    @Query("SELECT new Project (p._id, p.title, p.description, p.color, p.createdAt) FROM Project p")
    List<Project> findAll();
}
