package edu.andre.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 180, nullable = false)
    private String street;
    private Integer number;
    @Column(name = "address_supplement")
    private String addressSupplement;
    private String notes;

    @OneToMany(mappedBy = "address")
    private List<Employee> employees;

    public Address() {
    }

    public Address(String street, Integer number, String addressSupplement) {
        this.street = street;
        this.number = number;
        this.addressSupplement = addressSupplement;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", number=" + number +
                ", addressSupplement='" + addressSupplement + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getAddressSupplement() {
        return addressSupplement;
    }

    public void setAddressSupplement(String addressSupplement) {
        this.addressSupplement = addressSupplement;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
