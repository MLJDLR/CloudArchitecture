package fr.efrei.CloudArchitecture.domain;

import jakarta.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator", sequenceName = "student_sequence", allocationSize = 1)

    public Integer id;
    private String name;
    private int age;

    public Student () {
    }

    public int getAge() {
        return age;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
