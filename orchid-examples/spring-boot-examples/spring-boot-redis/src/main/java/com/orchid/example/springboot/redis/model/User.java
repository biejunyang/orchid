package com.orchid.example.springboot.redis.model;

import java.util.Date;

public class User {
    private Integer id;

    private String name;

    private Integer age;

    private Double weight;

    private Date birthday;

    private Date createTime;

    public User() {
    }

    public User(Integer id, String name, Integer age, Double weight, Date birthday, Date createTime) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.birthday = birthday;
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", birthday=" + birthday +
                ", createTime=" + createTime +
                '}';
    }
}
