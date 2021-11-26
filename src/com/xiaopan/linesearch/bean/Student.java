package com.xiaopan.linesearch.bean;

import java.util.Objects;

public class Student{
    private String name;
    private Integer age;

    public Student() {}

    public Student(Integer age) {
        this.age = age;
    }

    public Student(String name, Integer age) {
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

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Student student = (Student) o;
//
//        if (name != null ? !name.equals(student.name) : student.name != null) return false;
//        if (age != null ? !age.equals(student.age) : student.age != null) return false;
//
//        return true;
//    }

    @Override
    public boolean equals(Object o) {
        // name 字段相同, 即两个对象逻辑相同
        if (this == o)
            return true;

        if (o == null)
            return false;

        if (o instanceof Student s) {
            return (this.name != null && s.name != null)
                    && this.name.equals(s.name);
        }

        return false;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (age != null ? age.hashCode() : 0);
        return result;
    }
}
