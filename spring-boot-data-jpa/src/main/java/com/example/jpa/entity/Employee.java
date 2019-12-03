package com.example.jpa.entity;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * employee实体类
 * @author xielx at 2019/12/2 22:11
 */

@Entity
@Table(name = "employee")
public class Employee {
    
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//主键自增
    private Long empId;
    /**
     * 姓名
     */
    @Column(name = "emp_name")
    private String empName;
    /**
     * 性别,0:保密;1:男;2:女
     */
    private String gender;
    /**
     * 出生年月,yyyy-MM-dd
     */
    private LocalDate birth;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 联系方式
     */
    private String phone;
    
}
