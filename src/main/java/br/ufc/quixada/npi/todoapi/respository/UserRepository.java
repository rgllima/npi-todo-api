package br.ufc.quixada.npi.todoapi.respository;

import br.ufc.quixada.npi.todoapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);

    @Query("SELECT new User (u._id, u.name, u.email) FROM User u")
    List<User> findAll();
}
