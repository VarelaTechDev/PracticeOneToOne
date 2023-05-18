package com.onetoone.practiceonetoone;

import com.onetoone.practiceonetoone.Entity.Car;
import com.onetoone.practiceonetoone.Entity.Person;
import com.onetoone.practiceonetoone.Repository.CarRepository;
import com.onetoone.practiceonetoone.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private final PersonRepository personRepository;
    private final CarRepository carRepository;

    @Autowired
    public DatabaseSeeder(PersonRepository personRepository, CarRepository carRepository) {
        this.personRepository = personRepository;
        this.carRepository = carRepository;
    }

    @Override
    public void run(String... args) {
        String[] carMakes = {"Toyota", "Honda", "Ford", "BMW", "Audi"};
        String[] carModels = {"Corolla", "Civic", "Mustang", "X5", "A4"};
        String[] carColors = {"Red", "Blue", "Black", "White", "Silver"};

        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            Person person = new Person();
            person.setName("Person " + i);
            person.setAge(20 + random.nextInt(50));

            Car car = new Car();
            car.setMake(carMakes[random.nextInt(carMakes.length)]);
            car.setModel(carModels[random.nextInt(carModels.length)]);
            car.setColor(carColors[random.nextInt(carColors.length)]);
            car.setOwner(person);

            person.setCar(car);

            personRepository.save(person);
        }
    }
}

