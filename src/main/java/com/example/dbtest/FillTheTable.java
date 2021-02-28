package com.example.dbtest;

import com.example.dbtest.domain.Department;
import com.example.dbtest.domain.Lector;
import com.example.dbtest.domain.Salary;
import com.example.dbtest.repos.DepartmentRepo;
import com.example.dbtest.repos.LectorRepo;
import com.example.dbtest.repos.SalaryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Component
public class FillTheTable {
    @Autowired
    private DepartmentRepo departmentRepo;
    @Autowired
    private LectorRepo lectorRepo;
    @Autowired
    private SalaryRepo salaryRepo;

    private static Department one;
    private static Department two;
    private static Lector l1;
    private static Lector l2;
    private static Salary s1;
    private static Salary s2;
    private static Salary s3;

    public FillTheTable() {
    }

    public FillTheTable(DepartmentRepo departmentRepo, LectorRepo lectorRepo, SalaryRepo salaryRepo) {
        this.departmentRepo = departmentRepo;
        this.lectorRepo = lectorRepo;
        this.salaryRepo = salaryRepo;
    }

    public void fill(){
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("tableData.xml");

        one = context.getBean("department1", Department.class);
        two = context.getBean("department2", Department.class);

        l1 = context.getBean("lector1", Lector.class);
        l2 = context.getBean("lector2", Lector.class);

        s1 = context.getBean("salary1", Salary.class);
        s2 = context.getBean("salary2", Salary.class);
        s3 = context.getBean("salary3", Salary.class);

        Set<Salary> set1 = new HashSet<>();
        set1.add(s1);
        set1.add(s3);
        one.setSalaries(set1);

        Set<Salary> set2 = new HashSet<>();
        set2.add(s2);
        one.setSalaries(set2);

//        System.out.println("fin");
        this.departmentRepo.save(one);
        this.departmentRepo.save(two);

        this.lectorRepo.save(l1);
        this.lectorRepo.save(l2);

        this.salaryRepo.save(s1);
        this.salaryRepo.save(s2);
        this.salaryRepo.save(s3);



        context.close();
    }

    public static void main(String[] args) {
        FillTheTable f = new FillTheTable();
        f.fill();
    }
}
