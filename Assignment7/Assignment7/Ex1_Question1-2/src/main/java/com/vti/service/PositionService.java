package com.vti.service;

import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.repository.IDepartmentRepository;
import com.vti.repository.IPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PositionService implements IPositionService {

    @Autowired
    private IPositionRepository repository;

    @Override
    public Page<Position> getAllPositions(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Position getPositionByID(short id) {
        return repository.findById((int) id).get();
    }

    @Override
    public Position getPositionByPositionName(String name) {
        return repository.findByPositionName(name);
    }

    @Override
    public void createPosition (Position position) {
        repository.save(position);
    }

    @Override
    public void updatePosition(short id, String newName) {
        Position updatePosition = getPositionByID(id);
        Position.PositionName name = newName.equalsIgnoreCase("Dev") ? Position.PositionName.DEV
                : newName.equalsIgnoreCase("Test") ? Position.PositionName.TEST
                : newName.equalsIgnoreCase("Scrummaster") ? Position.PositionName.SCRUMMASTER
                : Position.PositionName.PM;

        updatePosition.setPositionName(name);
        repository.save(updatePosition);
    }

    @Override
    public void updatePosition(Position position) {
        repository.save(position);
    }

    @Override
    public void deletePosition(short id) {
        repository.deleteById((int) id);
    }

    @Override
    public boolean isPositionExistsByID(short id) {
        return repository.existsById((int) id);
    }

    @Override
    public boolean isPositionExistsByPositionName(String name) {
        return repository.existsByPositionName(name);
    }
}
