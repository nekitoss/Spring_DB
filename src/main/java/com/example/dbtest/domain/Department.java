package com.example.dbtest.domain;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Component
@Scope("prototype")
@Entity
@Table(name = "departments")
public class Department {
    @Id
    @SequenceGenerator(
            name = "department_sequence",
            sequenceName = "department_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "department_sequence")
    @Column(name = "id")
    private Long id;

    @OneToMany( cascade = CascadeType.ALL)//, orphanRemoval = true)//mappedBy = "departments",
    private Set<Salary> salaries = new HashSet<>();

    private String departmentName;
    private String headOfDepartmentName;

    public Department() {
    }

    public Department(String department_name, String head_of_department_name) {
        this.departmentName = department_name;
        this.headOfDepartmentName = head_of_department_name;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getHeadOfDepartmentName() {
        return headOfDepartmentName;
    }

    public void setHeadOfDepartmentName(String headOfDepartmentName) {
        this.headOfDepartmentName = headOfDepartmentName;
    }


    public Set<Salary> getSalaries() {
        return salaries;
    }

    public void setSalaries(Set<Salary> salaries) {
        this.salaries = salaries;
    }
}
