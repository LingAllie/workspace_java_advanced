package com.vti.entity;

import com.vti.repository.ExamRepository;

public class ExamCodeGenerator {

    private ExamRepository repository;

    public ExamCodeGenerator() {
        repository = new ExamRepository();
    }

   public String generate(short duration) {

       int count = 0;

       String code = "";

       if (duration >= 180) {
           count = repository.getCountByType("L") + 1;
           code = "L-" + count;
       } else if (duration >= 90) {
           count = repository.getCountByType("M") + 1;
           code = "M-" + count;
       } else {
           count = repository.getCountByType("S") + 1;
           code = "S-" + count;
       }

       return code;
   }
}
