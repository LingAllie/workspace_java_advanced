package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
	@Enumerated(EnumType.ORDINAL)
	private TypeName typeName;

	public TypeQuestion() {
	}

	public TypeQuestion(short typeId, TypeName typeName) {
		this.typeId = typeId;
		this.typeName = typeName;
	}

	public short getTypeId() {
		return typeId;
	}

	public void setTypeId(short typeId) {
		this.typeId = typeId;
	}

	public TypeName isTypeName() {
		return typeName;
	}

	public void setTypeName(TypeName typeName) {
		this.typeName = typeName;
	}

	@Override
	public String toString() {
//		int typeName;
//		if (this.typeName == true) {
//			typeName = 1;
//		} else {
//			typeName = 0;
//		}
		return "TypeQuestion [typeId=" + typeId + ", typeName=" + typeName + "]";
	}
	
	// 
	public enum TypeName {
		ESSAY, MULTIPLECHOICE;
	}
}
