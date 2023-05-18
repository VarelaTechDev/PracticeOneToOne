package com.onetoone.practiceonetoone.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
    public class Person {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        private int age;

        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "car_id", referencedColumnName = "id")
        @JsonManagedReference
        private Car car;

    public Person() {
    }

    public Person(Long id, String name, int age, Car car) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.car = car;
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
