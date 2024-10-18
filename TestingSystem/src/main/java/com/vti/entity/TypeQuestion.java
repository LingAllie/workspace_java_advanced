package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TypeQuestion")
public class TypeQuestion implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "TypeID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short typeId;
	
	@Column(name = "TypeName", nullable = false, unique = true)
	private boolean typeName;

	public TypeQuestion() {
	}

	public TypeQuestion(short typeId, boolean typeName) {
		this.typeId = typeId;
		this.typeName = typeName;
	}

	public short getTypeId() {
		return typeId;
	}

	public void setTypeId(short typeId) {
		this.typeId = typeId;
	}

	public boolean isTypeName() {
		return typeName;
	}

	public void setTypeName(boolean typeName) {
		this.typeName = typeName;
	}

	@Override
	public String toString() {
		int typeName;
		if (this.typeName == true) {
			typeName = 1;
		} else {
			typeName = 0;
		}
		return "TypeQuestion [typeId=" + typeId + ", typeName=" + typeName + "]";
	}
	
	
}
