package com.onetoone.practiceonetoone.Service;

import com.onetoone.practiceonetoone.Entity.Person;
import com.onetoone.practiceonetoone.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.onetoone.practiceonetoone.Entity.Person;
import com.onetoone.practiceonetoone.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public void setPersonRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Optional<Person> getPersonById(Long id) {
        return personRepository.findById(id);
    }

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    public Person updatePerson(Long id, Person newPerson) {
        Optional<Person> optionalPerson = personRepository.findById(id);

        if (optionalPerson.isPresent()) {
            Person existingPerson = optionalPerson.get();
            existingPerson.setName(newPerson.getName());
            existingPerson.setAge(newPerson.getAge());
            existingPerson.setCar(newPerson.getCar());
            return personRepository.save(existingPerson);
        } else {
            newPerson.setId(id);
            return personRepository.save(newPerson);
        }
    }

    public void deletePersonById(Long id) {
        personRepository.deleteById(id);
    }
}


