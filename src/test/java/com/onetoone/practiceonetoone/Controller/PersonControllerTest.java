package com.onetoone.practiceonetoone.Controller;

import com.onetoone.practiceonetoone.Entity.Person;
import com.onetoone.practiceonetoone.Repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

public class PersonControllerTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonController personController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(personController).build();
    }

    @Test
    public void getPerson_whenPersonExists_returnPerson() throws Exception {
        Person person = new Person();
        person.setId(1L);
        person.setName("John Doe");
        person.setAge(30);

        when(personRepository.findById(1L)).thenReturn(Optional.of(person));

        mockMvc.perform(get("/persons/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\": 1,\"name\":\"John Doe\",\"age\":30}"));
    }

    @Test
    public void getPerson_whenPersonDoesNotExists_returnNotFound() throws Exception {
        when(personRepository.findById(1L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/persons/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    // You can add more tests for other methods of PersonController.
}
