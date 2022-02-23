package com.example.demo.Employee;

import javax.persistence.*;

@Entity
@Table(name ="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name ="id")
    private int id;
    @Column(name ="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name = "company")
    private String Company;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String company) {
        this.firstName = firstName;
        this.lastName = lastName;
        Company = company;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", Company='" + Company + '\'' +
                '}';
    }
}
