package com.vti;

import java.util.List;

import com.vti.entity.Position;
import com.vti.repository.PositionRepository;


public class ProgramPosition {
	public static void main(String[] args) {
		PositionRepository repository = new PositionRepository();

		System.out.println("***********GET ALL POSITIONS***********");

		List<Position> positions = repository.getAllPositions();

		for (Position position : positions) {
			System.out.println(position);
		}

//		System.out.println("\n\n***********GET POSITION BY ID***********");
//
//		Position positionById = repository.getPositionByID((short) 3);
//		System.out.println(positionById);

//		System.out.println("\n\n***********GET POSITION BY NAME***********");
//
//		Position positionByName = repository.getPositionByName("DEV");
//		System.out.println(positionByName);

//		System.out.println("\n\n***********CREATE POSITION***********");
//
//		Position positionCreate = new Position();
//		positionCreate.setPositionName(Position.PositionName.TEST);
//		repository.createPosition(positionCreate);

//		System.out.println("\n\n***********UPDATE POSITION 1***********");
//
//		repository.updatePosition((short) 1, "TEST");

//		System.out.println("\n\n***********UPDATE POSITION 2***********");
//
//		Position positionUpdate = new Position();
//		positionUpdate.setPositionId((short) 3);
//		positionUpdate.setPositionName("PM");
//		repository.updatePosition(positionUpdate);
		
		
//		System.out.println("\n\n***********DELETE POSITION***********");
//		repository.deletePosition((short) 2);

//		System.out.println("***********CHECK POSITION EXISTS BY ID***********");
//		System.out.println(repository.isPositionExistsByID((short) 2));

//		System.out.println("***********CHECK POSITION EXISTS BY NAME***********");
//		System.out.println(repository.isPositionExistsByName("Test"));

	}
}
