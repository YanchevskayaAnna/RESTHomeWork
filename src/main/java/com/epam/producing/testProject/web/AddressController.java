package com.epam.producing.testProject.web;

import com.epam.producing.testProject.exception.AddressNotFoundException;
import com.epam.producing.testProject.model.Address;
import com.epam.producing.testProject.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {

    @Autowired
    private AddressRepository repository;

    @GetMapping("/employees/addresses")
    List<Address> all() {
        return repository.findAll();
    }

    @PostMapping("/employees/addresses")
    ResponseEntity<Address> newAddress(@RequestBody Address newAddress) {
        return new ResponseEntity<>(repository.save(newAddress), HttpStatus.OK);
    }

    // Single item

    @GetMapping("/employees/addresses/{id}")
    Address one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new AddressNotFoundException(id));
    }

    @PutMapping("/employees/addresses/{id}")
    Address replaceAddress(@RequestBody Address newAddress, @PathVariable Long id) {

        return repository.findById(id)
                .map(address -> {
                    address.setCity(newAddress.getCity());
                    address.setStreet(newAddress.getStreet());
                    return repository.save(address);
                })
                .orElseGet(() -> {
                    newAddress.setId(id);
                    return repository.save(newAddress);
                });
    }

    @DeleteMapping("/employees/addresses/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }

    public void setRepository(AddressRepository repository) {
        this.repository = repository;
    }
}
