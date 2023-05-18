package com.onetoone.practiceonetoone.Repository;

import com.onetoone.practiceonetoone.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
