package ru.pepsxx.spring.boot.help.pep_pro_spring_boot_help.v008.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.pepsxx.spring.boot.help.pep_pro_spring_boot_help.v008.entity.Person8;

import java.util.List;

@Repository
public interface TestRepository8 extends JpaRepository<Person8, Long> {

    Person8 findById(long id);

//    @Query("FROM Person8 p WHERE p.name = :name OR p.id = 1") // Есть с таким-же именем в entity
    List<Person8> findByName(@Param("name") String name);

    @Query("FROM Person8 p WHERE p.id = 10") // Есть с таким-же именем в entity
    List<Person8> findAllBy();

}
