package com.vti.repository;

import com.vti.entity.Department;
import com.vti.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPositionRepository extends JpaRepository<Position, Integer> {

    public Position findByPositionName(String name);
    public boolean existsByPositionName(String name);
}
