package com.cdy.jpa.entity;

import javax.persistence.*;

@Entity //告诉jpa这是一个实体类（与数据库表映射的实体类）
@Table(name="test_01") //此注解来指定该实体类和那张表对象 如果不写该注解，则默认与类名小写的表对应（test）
public class Test {

    @Id //主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增主键
    private Integer id;

    @Column(name = "last_name",length = 32)
    private String lastName;

    @Column// 不指定字段名，则属性名即为列名
    private int age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
