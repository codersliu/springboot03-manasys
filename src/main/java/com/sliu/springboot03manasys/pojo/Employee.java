package com.sliu.springboot03manasys.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Employee {
    private Integer id;
    private String name;
    private String email;
    private Integer sex;
    private Department department;
    private Date birth;

    public Employee(Integer id, String name, String email, Integer sex, Department department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.sex = sex;
        this.department = department;
        this.birth = new Date();
    }
}
