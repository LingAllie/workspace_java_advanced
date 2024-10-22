package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "`Position`")
public class Position implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "PositionID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short positionId;
	
	@Column(name = "PositionName", nullable = false, unique = true)
	@Convert(converter = PositionNameConverter.class)
	private PositionName positionName;
	
	public Position() {}


	public Position(short positionId, PositionName positionName) {
		super();
		this.positionId = positionId;
		this.positionName = positionName;
	}

	public short getPositionId() {
		return positionId;
	}

	public void setPositionId(short positionId) {
		this.positionId = positionId;
	}

	public PositionName getPositionName() {
		return positionName;
	}

	public void setPositionName(PositionName positionName) {
		this.positionName = positionName;
	}


	@Override
	public String toString() {
		return "Position [positionId=" + positionId + ", positionName=" + positionName + "]";
	}
	
	
	public enum PositionName {
		DEV("Dev"), TEST("Test"), SCRUMMASTER("ScrumMaster"), PM("PM");
		
		private String name;
		
		private PositionName(String name) {
			this.name = name;
		}
		
		public String getName() {
			return this.name;
		}
		
		public static PositionName toEnum(String sqlName) {
			for (PositionName item: PositionName.values()) {
				if (item.getName().equals(sqlName)) {
					return item;
				}
			}
			return null;
		}
	}
	
}
