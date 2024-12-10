package com.vti.repository;

import com.vti.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IExamRepository extends JpaRepository<Exam, Integer> {

    public Exam findByCode(String code);
    public boolean existsByCode(String code);

    @Query("SELECT COUNT(*) FROM Exam e WHERE e.code LIKE ?1")
    public int countByCode(String code);
}
