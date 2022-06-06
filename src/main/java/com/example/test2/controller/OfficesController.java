package com.example.test2.controller;

import com.example.test2.entities.Office;
import com.example.test2.repositories.OfficesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/office")
public class OfficesController {
    @Autowired
    private OfficesRepository officesRepository;


    @GetMapping(path = "/all")
    public @ResponseBody Iterable<String> getAllOffices(){
        return officesRepository.findOffices();
    }

    @GetMapping(path = "/country/usa")
    public @ResponseBody Iterable<String> getAllOfficesByCountry(){
        return officesRepository.findByCountry("USA");
    }

    @GetMapping(path = "/withEmployees")
    public @ResponseBody
    Iterable<String> getOfficesWithEmployee(){
        return officesRepository.findOfficeWithEmployees();
    }

    @GetMapping(path = "/withoutEmployees")
    public @ResponseBody
    Iterable<String> getOfficesWithoutEmployee(){
        return officesRepository.findOfficeWithoutEmployees();
    }
    @GetMapping(path = "/office/{id}")
    public @ResponseBody Iterable<String> getEmployeesPerOffice(@PathVariable String id){
        return officesRepository.sumOfficeEmployeesById(id);
    }

    @PostMapping("/add")
    public Iterable<String> insertOffice(){
        Office o = new Office();
        o.setCity("Beograd");
        o.setPhone("063251698");
        o.setAddressLine1("Patrisa Lumumbe 36");
        o.setAddressLine2("Leposave Vujosevic 10");
        o.setState("Srbija");
        o.setCountry("Srbija");
        o.setPostalCode("11060");
        o.setTerritory("SRB");
        officesRepository.save(o);

        return officesRepository.findOffices();
    }

    @PostMapping("/edit/5")
    public String editOffice(){
        Office o = officesRepository.ofId("5");
        o.setCity("Beograd");
        o.setPhone("063251698");
        o.setAddressLine1("Patrisa Lumumbe 36");
        o.setAddressLine2("Leposave Vujosevic 10");
        o.setState("Srbija");
        o.setCountry("Srbija");
        o.setPostalCode("11060");
        o.setTerritory("SRB");
        officesRepository.save(o);

        return "Updated successfully";
    }

    @PostMapping("/delete/5")
    public @ResponseBody String deleteOfficeByID(){
        officesRepository.deleteById("5");
        return "Deleted successfully";
    }


}
