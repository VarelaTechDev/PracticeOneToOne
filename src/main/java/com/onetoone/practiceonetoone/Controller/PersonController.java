package com.onetoone.practiceonetoone.Controller;


import com.onetoone.practiceonetoone.Entity.Person;
import com.onetoone.practiceonetoone.Exception.BadRequestException;
import com.onetoone.practiceonetoone.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPerson(@PathVariable Long id) {
        if (id < 0) {
            throw new BadRequestException(id + " cannot be invalid");
        }

        Optional<Person> optionalPerson = personService.getPersonById(id);

        if (optionalPerson.isPresent()) {
            Person person = optionalPerson.get();
            return ResponseEntity.ok(person);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    public List<Person> getPersons() {
        return personService.getAllPersons();
    }

    @PostMapping()
    public Person createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }

    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable Long id, @RequestBody Person newPerson) {
        return personService.updatePerson(id, newPerson);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id) {
        personService.deletePersonById(id);
    }

}


//import com.onetoone.practiceonetoone.Entity.Person;
//import com.onetoone.practiceonetoone.Repository.PersonRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/persons")
//public class PersonController {
//
//    private final PersonRepository personRepository;
//
//    @Autowired
//    public PersonController(PersonRepository personRepository) {
//        this.personRepository = personRepository;
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<?> getPerson(@PathVariable Long id) {
//        Optional<Person> optionalPerson = personRepository.findById(id);
//
//        if (optionalPerson.isPresent()) {
//            Person person = optionalPerson.get();
//            return ResponseEntity.ok(person);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @GetMapping("/all")
//    public List<Person> getPersons() {
//        return personRepository.findAll();
//    }
//
//    @PostMapping()
//    public Person createPerson(@RequestBody Person person) {
//        return personRepository.save(person);
//    }
//
//    @PutMapping("/{id}")
//    public Person updatePerson(@PathVariable Long id, @RequestBody Person newPerson) {
//        Optional<Person> optionalPerson = personRepository.findById(id);
//
//        if (optionalPerson.isPresent()) {
//            Person existingPerson = optionalPerson.get();
//            existingPerson.setName(newPerson.getName());
//            existingPerson.setAge(newPerson.getAge());
//            existingPerson.setCar(newPerson.getCar());
//            return personRepository.save(existingPerson);
//        } else {
//            newPerson.setId(id);
//            return personRepository.save(newPerson);
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public void deletePerson(@PathVariable Long id) {
//        personRepository.deleteById(id);
//    }
//
//
//}
