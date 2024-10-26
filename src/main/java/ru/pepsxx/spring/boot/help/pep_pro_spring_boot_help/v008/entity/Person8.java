package ru.pepsxx.spring.boot.help.pep_pro_spring_boot_help.v008.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;


@NamedQuery(
        name = "Person8.findAllBy",
        query = "FROM Person8 p WHERE p.id = 20")

@NamedQuery(
        name = "Person8.findByName",
        query = "FROM Person8 p WHERE p.name = :name OR p.id = 2")

@Entity
@Table(name = "person")
public class Person8 {

    @Id
    private long id;

    private String name;

    private int age;

    // get

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // set

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // toString

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
