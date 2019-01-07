package com.sqlapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sqlapi.model.Customer;
import com.sqlapi.repository.CustomerRepository;
 
@RestController
public class WebController {
    @Autowired
    CustomerRepository repository;
      
    @RequestMapping(value = "/save",  method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> add(@RequestParam String firstName, @RequestParam String lastName){
        Customer customer = new Customer(firstName, lastName);
    	repository.save(customer);
        return ResponseEntity.ok("SAVED");
    }
      
      
    @RequestMapping(value = "/findall",  method = RequestMethod.GET)
    @ResponseBody
    public String getAll(){
        return repository.findAll().toString();
    }
      
    @RequestMapping(value = "/findbyid",  method = RequestMethod.GET)
    public Optional<Customer> findById(@RequestParam("id") long id){
        return repository.findById(id);
    }
      
    @RequestMapping(value = "/findbylastname",  method = RequestMethod.GET)
    @ResponseBody
    public List<Customer> fetchDataByLastName(@RequestParam("lastname") String lastName){
        return repository.findByLastName(lastName);

    }
}