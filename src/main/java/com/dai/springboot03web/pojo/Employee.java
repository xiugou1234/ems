package com.dai.springboot03web.pojo;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
//员工表
public class Employee {
    private Integer id;
    private String lastName;
    private  String email;
    private Integer gender;//0:女 1：男
    private Department department;
    private Date date;


}
