package com.onetoone.practiceonetoone.Service;

import static org.junit.jupiter.api.Assertions.*;

import com.onetoone.practiceonetoone.Entity.Person;
import com.onetoone.practiceonetoone.Repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @MockBean
    private PersonRepository personRepository;

    @Test
    public void testGetPersonById() {
        Person person = new Person();
        person.setId(1L);
        person.setName("John Doe");
        person.setAge(30);

        when(personRepository.findById(1L)).thenReturn(Optional.of(person));

        Optional<Person> foundPerson = personService.getPersonById(1L);

        assertTrue(foundPerson.isPresent());
        assertEquals("John Doe", foundPerson.get().getName());
        assertEquals(30, foundPerson.get().getAge());

        verify(personRepository, times(1)).findById(1L);
    }

    @Test
    public void testGetAllPersons() {
        Person person1 = new Person();
        person1.setId(1L);
        person1.setName("John Doe");
        person1.setAge(30);

        Person person2 = new Person();
        person2.setId(2L);
        person2.setName("Jane Doe");
        person2.setAge(25);

        when(personRepository.findAll()).thenReturn(Arrays.asList(person1, person2));

        List<Person> persons = personService.getAllPersons();

        assertNotNull(persons);
        assertEquals(2, persons.size());

        verify(personRepository, times(1)).findAll();
    }

    // Similarly write tests for createPerson, updatePerson and deletePersonById methods...
}




