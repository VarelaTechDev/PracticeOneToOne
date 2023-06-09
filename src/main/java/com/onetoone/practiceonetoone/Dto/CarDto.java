package com.onetoone.practiceonetoone.Dto;

import com.onetoone.practiceonetoone.Entity.Person;

public class CarDto {
    private Long id;
    private String make;
    private String model;
    private String color;
    private PersonDto owner;


    public CarDto() {
    }

    public CarDto(Long id, String make, String model, String color, PersonDto owner) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.color = color;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public PersonDto getOwner() {
        return owner;
    }

    public void setOwner(PersonDto owner) {
        this.owner = owner;
    }
}

