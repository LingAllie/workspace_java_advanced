package com.vti.entity;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import com.vti.repository.ExamRepository;

public class ExamCodeGenerator implements IdentifierGenerator{

	private ExamRepository repository;
	
	public ExamCodeGenerator() {
		repository = new ExamRepository();
	}
	
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		
			Exam exam = (Exam) object;
		
		 	short duration = exam.getDuration();
	        int count = 0;
	        
	        String code = "";

	        if (duration >= 180) {
	        	count = repository.getCountByType("L") + 1;
	            code = "L-" + count;
	        } else if (duration >= 90 && duration < 180) {
	        	count = repository.getCountByType("M") + 1;
	            code = "M-" + count; 
	        } else {
	        	count = repository.getCountByType("S") + 1;
	            code = "S-" + count; 
	        }
	      

	        return code;
	}

}
