package com.demo.basic.entity;

import com.demo.basic.validation.MultiplesOfThree;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * 工作
 *
 * @author xielx at 2019/11/28 19:30
 */
public class Job {
    
    /**
     * 1.注解一般会忽略参数为null的校验,但可以使用@NotNull校验,也可自定义注解
     * 2.同一个注解可以注解多个数据类型
     */
    @MultiplesOfThree
    private Long id;
    
    @Size(min = 1)
    private String name;
    
    @Size(min = 1,max = 10)
    @NotNull
    @MultiplesOfThree
    private List<String> labels;
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public List<String> getLabels() {
        return labels;
    }
    
    public void setLabels(List<String> labels) {
        this.labels = labels;
    }
}
