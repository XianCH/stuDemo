package com.x14n.stuCase.bo;

import java.util.Date;

public class Person {

    private String name;

    private Integer age;

    private Date dateTime;


    public Person(String name, Integer age, Date dateTime) {
        this.name = name;
        this.age = age;
        this.dateTime = dateTime;
    }

    public Person(){}

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

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", dateTime=" + dateTime +
                '}';
    }
}
