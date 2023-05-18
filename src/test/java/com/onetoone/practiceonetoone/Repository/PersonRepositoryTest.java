package com.onetoone.practiceonetoone.Repository;

import static org.junit.jupiter.api.Assertions.*;

import com.onetoone.practiceonetoone.Entity.Car;
import com.onetoone.practiceonetoone.Entity.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class PersonRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PersonRepository personRepository;

    private Person person;

    @BeforeEach
    public void setUp() {
        Car car = new Car();
        car.setMake("Toyota");
        car.setModel("Corolla");
        car.setColor("Blue");

        person = new Person();
        person.setName("John Doe");
        person.setAge(30);
        person.setCar(car);

        car.setOwner(person);
    }

    @AfterEach
    public void tearDown() {
        personRepository.deleteAll();
    }

    @Test
    public void whenFindById_thenReturnPerson() {
        entityManager.persistAndFlush(person);

        Person foundPerson = personRepository.findById(person.getId()).orElse(null);
        assertThat(foundPerson).isNotNull();
        assertThat(foundPerson.getName()).isEqualTo(person.getName());
        assertThat(foundPerson.getCar().getMake()).isEqualTo(person.getCar().getMake());
    }

    // Add more tests as needed...
}