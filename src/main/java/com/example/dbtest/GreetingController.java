package com.example.dbtest;

import com.example.dbtest.domain.Department;
import com.example.dbtest.domain.Lector;
import com.example.dbtest.domain.Salary;
import com.example.dbtest.repos.DepartmentRepo;
import com.example.dbtest.repos.LectorRepo;
import com.example.dbtest.repos.SalaryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
public class GreetingController {
    @Autowired
    private DepartmentRepo depRepo;
//    @Autowired
//    private LectorRepo lectorRepo;
//    @Autowired
//    private SalaryRepo salaryRepo;


    @GetMapping("/greeting")
    public String greeting(@RequestParam(value = "department_name", defaultValue = "dep") String department_name,
                           @RequestParam(value = "head_of_department_name", defaultValue = "head") String head_of_department_name){ //,
//            Map<String, Object> model) {
//        model.put("name", department_name);
        depRepo.save(new Department(department_name, head_of_department_name));
//        Iterable<Message>  messages = universityRepo.findAll();
//        model.put("messages", messages);
        return String.format("Head of %s department is %s", department_name, head_of_department_name);
    }



//    @GetMapping
//    public String main(Map<String, Object> model){
//        Iterable<Message>  messages = messageRepo.findAll();
//
//        model.put("messages", messages);
//        return "main";
//    }
//
//    @PostMapping
//    public String add(@RequestParam String text, @RequestParam String tag, Map<String, Object> model){
//        new Message();
//        return "main";
//    }

//    private static final String template = "Hello, %s!";
//    private final AtomicLong counter = new AtomicLong();
//
//    @GetMapping("/greeting")
//    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
//        return new Greeting(counter.incrementAndGet(), String.format(template, name));
//    }
}