package com.example.dbtest.domain;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Scope("prototype")
@Entity
@Table(name = "salary")
public class Salary {
    @Id
    @SequenceGenerator(
            name = "salary_sequence",
            sequenceName = "salary_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "salary_sequence")
    @Column(name = "id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "lectors_id", referencedColumnName = "id")
    private Lector lector;

    @ManyToOne
//    @JoinColumn(name = "departments_id")
    private Department department;

    private int amount;

    public Salary() {
    }

    public Salary(Lector lector, Department department, int amount) {
        this.lector = lector;
        this.department = department;
        this.amount = amount;
    }

    public Lector getLector() {
        return lector;
    }

    public void setLector(Lector lector) {
        this.lector = lector;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


}
