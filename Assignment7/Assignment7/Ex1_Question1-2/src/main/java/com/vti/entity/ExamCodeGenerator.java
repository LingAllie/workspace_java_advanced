package com.vti.entity;

import com.vti.service.ExamService;

public class ExamCodeGenerator {

    private ExamService service;

    public ExamCodeGenerator() {
        service = new ExamService() {};
    }

   public String generate(short duration) {

       int count = 0;

       String code = "";

       if (duration >= 180) {
           count = service.countByCode("L") + 1;
           code = "L-" + count;
       } else if (duration >= 90) {
           count = service.countByCode("M") + 1;
           code = "M-" + count;
       } else {
           count = service.countByCode("S") + 1;
           code = "S-" + count;
       }

       return code;
   }
}
