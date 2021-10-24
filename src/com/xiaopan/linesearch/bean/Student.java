package com.xiaopan.linesearch.bean;

import java.util.Objects;

public class Student implements Comparable<Student>{
    private String name;
    private Integer age;

    public Student() {}

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
        // 引用地址相同 true
        if (this == o)
            return true;

        // 类型不同 false
        if (!(o instanceof Student s))
            return false;

        // 属性字段全部相同返回true
        return (this.name != null && this.name.equals(s.getName())) &&
                (this.age != null && this.age.equals(s.getAge()));
    }

    @Override
    public int compareTo(Student o) {
        if (o == null) {
            return -1;
        }
        // 单纯比较age
        return this.age - o.getAge();
    }
}
