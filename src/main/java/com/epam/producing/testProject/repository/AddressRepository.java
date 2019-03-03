package com.epam.producing.testProject.repository;

import com.epam.producing.testProject.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
    
}
