package com.ankit.model;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * Created by ankit07 on 9/7/16.
 */

@Entity
@Table(name = "EMPLOYEE")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 3,max = 40)
    @Column(name = "NAME",nullable = false)
    private String name;

    @NotNull
    @DateTimeFormat(pattern = "dd/MM//yyyy")
    @Column(name = "JOINING DATE",nullable = false)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate" )
    private LocalDate joiningDate;


    @NotNull
    @Digits(integer=8, fraction=2)
    @Column(name = "SALARY", nullable = false)
    private BigDecimal salary;

    @NotEmpty
    @Column(name = "SSN", unique=true, nullable = false)
    private String ssn;



    public int getId() {
        return id;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public LocalDate getJoiningDate() {

        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;

    }
}
