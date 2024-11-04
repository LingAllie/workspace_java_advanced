package com.vti.entity;

import com.vti.repository.ExamRepository;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

public class ExamCodeGenerator implements IdentifierGenerator {

    private ExamRepository repository;

    public ExamCodeGenerator(ExamRepository repository) {
        this.repository = repository;
    }

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        Exam exam = (Exam) object;

        short duration = exam.getDuration();

        String code = "";

        if (duration >= 180) {
            code = "L-" + (repository.getCountByType("L") + 1);
        } else if (duration >= 90) {
            code = "M-" + (repository.getCountByType("M") + 1);
        } else {
            code = "S-" + (repository.getCountByType("S") + 1);
        }

        return code;
    }
}
