package com.vti.controller;

import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.service.IDepartmentService;
import com.vti.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/positions")
public class PositionController {

    @Autowired
    private IPositionService service;

    @GetMapping
    public Page<Position> getAllPositions(Pageable pageable) {
        return service.getAllPositions(pageable);
    }

    @GetMapping("/{id}")
    public Position getPositionById(@PathVariable(name = "id") short id) {
        return service.getPositionByID(id);
    }

    @GetMapping("/name/{name}")
    public Position getPositionByName(@PathVariable(name = "name") String name) {
        return service.getPositionByPositionName(name);
    }

    @PostMapping("/create")
    public void createPosition(@RequestBody Position position) {
        service.createPosition(new Position(position.getPositionName()));
    }

    @PutMapping("/update1/{id}/{name}")
    public void updatePosition(@PathVariable(name = "id") short id, @PathVariable(name = "name") String newName) {
        service.updatePosition(id, newName);
    }

    @PutMapping("/update2")
    public void updatePosition(@RequestBody Position position) {
        service.updatePosition(position);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePosition(@PathVariable(name = "id") short id) {
        service.deletePosition(id);
    }

    @GetMapping("/checkIdExist/{id}")
    public boolean isPositionExistsByID(@PathVariable(name = "id") short id) {
        return service.isPositionExistsByID(id);
    }

    @GetMapping("/checkNameExist/{name}")
    public boolean isPositionExistsByName(@PathVariable(name = "name") String name) {
        return service.isPositionExistsByPositionName(name);
    }
}
