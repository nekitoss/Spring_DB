package com.example.dbtest.domain;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Scope("prototype")
@Entity
@Table(name = "lectors")
public class Lector {
    @Id
    @SequenceGenerator(
            name = "lector_sequence",
            sequenceName = "lector_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "lector_sequence")
    @Column(name = "id")
    private Long id;

    private String lastName; //Фамилия
    private String firstName; //Имя
    private String surName; //Отчество


    public Lector() {
    }

    public Lector(String lastName, String firstName, String surName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.surName = surName;
    }



    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }
}
