package com.onetoone.practiceonetoone.Repository;

import com.onetoone.practiceonetoone.Entity.Car;
import com.onetoone.practiceonetoone.Entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CarRepositoryTest {

    @Autowired
    CarRepository carRepository;

    @Autowired
    PersonRepository personRepository;

    @Test
    public void testFindAllCars() {
        List<Car> carsList = carRepository.findAll();
        assertNotNull(carsList);
        assertFalse(carsList.isEmpty());
    }

    @Test
    public void testFindById() {
        Car car = new Car();
        car.setMake("Toyota");
        car.setModel("Corolla");
        car.setColor("Blue");

        Person person = new Person();
        person.setName("John Doe");
        person.setAge(30);

        // Assuming you have PersonRepository autowired
        person = personRepository.save(person);

        car.setOwner(person);
        person.setCar(car);

        car = carRepository.save(car);

        Car foundCar = carRepository.findById(car.getId()).orElse(null);

        assertNotNull(foundCar);
        assertEquals(car.getMake(), foundCar.getMake());
        assertEquals(car.getModel(), foundCar.getModel());
        assertEquals(car.getColor(), foundCar.getColor());
    }

    // Add more tests as needed...
}