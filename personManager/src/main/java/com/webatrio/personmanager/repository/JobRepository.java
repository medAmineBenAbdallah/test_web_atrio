package com.webatrio.personmanager.repository;

import com.webatrio.personmanager.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

    @Query("SELECT j FROM Job j WHERE j.person.id=:id AND j.startDate>=:startDate AND (j.endDate<=:endDate OR j.endDate IS NULL)")
    List<Job> findByDateRange(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate,@Param("id") long id);
}
