package com.webatrio.personmanager.repository;

import com.webatrio.personmanager.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {
    @Query("SELECT p FROM Person p LEFT JOIN Job j ON p.id=j.person.id WHERE j.endDate IS NULL ORDER  BY p.firstName")
    List<Person> findAllByOrderByFirstName();

    @Query("SELECT p FROM Person p LEFT JOIN Job j ON p.id=j.person.id WHERE j.company=:companyName")
    List<Person> findAllByOrderByJobCompany(@Param("companyName") String companyName);
}
