package com.onetoone.practiceonetoone.Repository;

import com.onetoone.practiceonetoone.Entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
