package com.epam.producing.testProject.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name="employee")
public class Employee {
    
    private @Id @GeneratedValue long id;
    private String name;
    private String role;

   @OneToMany(mappedBy="employeeId", cascade={CascadeType.ALL})
   private List<Address> adresses;

    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public Employee() {
    }
}
