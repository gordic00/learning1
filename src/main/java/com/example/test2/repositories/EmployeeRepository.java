package com.example.test2.repositories;

import com.example.test2.entities.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee,Integer> {
    List<Employee> findByFirstName(String firstName);

    List<Employee> findByOfficeIsNotNull();

    @Query("select e.office.id from Employee e")
    List<String> findOfficeCodes();

    List<Employee> queryByOfficeIsNull();

}
