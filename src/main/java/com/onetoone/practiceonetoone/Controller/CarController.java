package com.onetoone.practiceonetoone.Controller;

import com.onetoone.practiceonetoone.Dto.CarDto;
import com.onetoone.practiceonetoone.Dto.PersonDto;
import com.onetoone.practiceonetoone.Entity.Car;
import com.onetoone.practiceonetoone.Entity.Person;
import com.onetoone.practiceonetoone.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarRepository carRepository;

    @Autowired
    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCar(@PathVariable Long id) {
        Optional<Car> optionalCar = carRepository.findById(id);
        if (optionalCar.isPresent()) {
            Car car = optionalCar.get();

            CarDto carDTO = new CarDto();
            carDTO.setId(car.getId());
            carDTO.setMake(car.getMake());
            carDTO.setModel(car.getModel());
            carDTO.setColor(car.getColor());

            Person owner = car.getOwner();
            PersonDto ownerDto = new PersonDto();
            ownerDto.setId(owner.getId());
            ownerDto.setName(owner.getName());
            ownerDto.setAge(owner.getAge());

            carDTO.setOwner(ownerDto);

            return ResponseEntity.ok(carDTO);

        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping
    public List<Car> getCar(){
        return carRepository.findAll();
    }

    @PostMapping
    public Car createCar(@RequestBody Car car) {
        return carRepository.save(car);
    }

    @PutMapping("/{id}")
    public Car updateCar(@PathVariable Long id, @RequestBody Car newCar) {
        Optional<Car> optionalCar = carRepository.findById(id);

        if (optionalCar.isPresent()) {
            Car existingCar = optionalCar.get();
            existingCar.setMake(newCar.getMake());
            existingCar.setModel(newCar.getModel());
            existingCar.setColor(newCar.getColor());
            return carRepository.save(existingCar);
        } else {
            newCar.setId(id);
            return carRepository.save(newCar);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) {
        carRepository.deleteById(id);
    }
}

