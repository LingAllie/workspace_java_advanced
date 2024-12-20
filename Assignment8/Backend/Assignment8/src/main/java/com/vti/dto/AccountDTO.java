package com.vti.dto;

import org.springframework.hateoas.RepresentationModel;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountDTO extends RepresentationModel<AccountDTO>{

	private int id;
	
	private String username;

	private String departmentName;
}
