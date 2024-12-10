package com.vti.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.vti.dto.DepartmentDTO;
import com.vti.entity.Department;
import com.vti.form.DepartmentFilterForm;
import com.vti.service.IDepartmentService;

@RestController
@RequestMapping(value = "api/v1/departments")
public class DepartmentController {

	@Autowired
	private IDepartmentService service;

	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping()
	public Page<DepartmentDTO> getAllDepartments(
			Pageable pageable, 
			@RequestParam(name = "search", required = false) String search,
			DepartmentFilterForm filterForm) {
		Page<Department> entityPages = service.getAllDepartments(pageable, search, filterForm);

		// convert entities --> dtos
		List<DepartmentDTO> dtos = modelMapper.map(
				entityPages.getContent(), 
				new TypeToken<List<DepartmentDTO>>() {}.getType());

		// add HATEOAS
		for (DepartmentDTO dto : dtos) {
			dto.add(linkTo(methodOn(DepartmentController.class).getDepartmentByID(dto.getId())).withSelfRel());
		}
				
		Page<DepartmentDTO> dtoPages = new PageImpl<>(dtos, pageable, entityPages.getTotalElements());

		return dtoPages;
		
	}
	
	@GetMapping(value = "/{id}")
	public DepartmentDTO getDepartmentByID(@PathVariable(name = "id") int id) {
		Department entity = service.getDepartmentByID(id);

		// convert entity to dto
		DepartmentDTO dto = modelMapper.map(entity, DepartmentDTO.class);
		
		dto.add(linkTo(methodOn(DepartmentController.class).getDepartmentByID(id)).withSelfRel());

		return dto;
	}

}
