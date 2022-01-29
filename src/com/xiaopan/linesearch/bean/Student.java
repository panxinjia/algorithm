package com.xiaopan.linesearch.bean;

import java.util.Objects;

public class Student implements Comparable<Student>{
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

    @Override
    public boolean equals(Object o) {
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

    @Override
    public int compareTo(Student o) {
        if (this == o)
            return 0;

        if (o == null)
            throw new RuntimeException("obj o is null");

        return Integer.compare(this.getAge(), o.getAge());
    }
}
