package com.example.test2.repositories;

import com.example.test2.entities.Office;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OfficesRepository extends CrudRepository<Office,String> {

    @Query("SELECT o.id, o.addressLine1, o.addressLine2, o.country FROM Office o")
    List<String> findOffices();

    @Query("SELECT o.id, o.city,o.phone, o.state, o.country FROM Office o WHERE o.country=?1")
    List<String> findByCountry(String country);

    @Query("SELECT o.id, o.addressLine1, o.addressLine2, o.country FROM Office o where o.employees.size > 0")
    List<String> findOfficeWithEmployees();

    @Query("SELECT o.id, o.addressLine1, o.addressLine2, o.country FROM Office o where o.employees.size = 0")
    List<String> findOfficeWithoutEmployees();

    @Query("SELECT o.id, o.city, o.state, o.country, sum(o.employees.size) FROM Office o where o.id=?1")
    List<String> sumOfficeEmployeesById(String id);

    @Query("SELECT o FROM Office o where o.id=?1")
    Office ofId(String id);




}
