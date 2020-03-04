package br.ufc.quixada.npi.todoapi.respository;

import br.ufc.quixada.npi.todoapi.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Customer findByEmail(String email);

    Customer findById(int id);

    List<Customer> findByAvailable(boolean available);

    @Query("SELECT new Customer (c.id, c.name, c.email, c.available) FROM Customer c")
    List<Customer> findAll();

    @Transactional
    @Modifying
    @Query("UPDATE Customer c SET c.name=(:name)  WHERE c.id=(:id)")
    void updateName(@Param("id") int id, @Param("name") String name);

    @Transactional
    @Modifying
    @Query("UPDATE Customer c SET c.password=(:password)  WHERE c.id=(:id)")
    void updatePassword(@Param("id") int id, @Param("password") String password);
}
