package com.epam.producing.testProject.model;

import lombok.Data;
import org.hibernate.annotations.Parent;

import javax.persistence.*;

@Data
@Entity(name="address")
public class Address {

    private @Id
    @GeneratedValue
    long id;
    private String city;
    private String street;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employeeId;

    public Address() {
    }
    public Address(String city, String street) {
        this.city = city;
        this.street = street;
    }

    public Address(String city, String street, Employee employeeId) {
        this.city = city;
        this.street = street;
        this.employeeId = employeeId;
    }

}
