package com.demo.basic.proxy.staticproxy.entity;

/**
 * 被追求者
 *
 * @author xielx at 2020/2/1 16:14
 */
public class Girl {
    
    
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
    
    public Girl(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Integer getAge() {
        return age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
}
