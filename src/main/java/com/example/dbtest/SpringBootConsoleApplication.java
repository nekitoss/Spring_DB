package com.example.dbtest;

import com.example.dbtest.repos.DepartmentRepo;
import com.example.dbtest.repos.LectorRepo;
import com.example.dbtest.repos.SalaryRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//@SpringBootApplication
//public class Application {
//    public static void main(String[] args) {
//        SpringApplication.run(Application.class, args);
//    }
//}

@SpringBootApplication
public class SpringBootConsoleApplication implements CommandLineRunner {
    @Autowired
    private DepartmentRepo departmentRepo;
    @Autowired
    private LectorRepo lectorRepo;
    @Autowired
    private SalaryRepo salaryRepo;

//    private Pattern headPattern = Pattern.compile("Who is head of department (.*?)");
//    private Pattern statPattern = Pattern.compile("Show (.*?) statistics.");
//    private Pattern avsalaryPattern = Pattern.compile("Show the average salary for the department (.*?).");
//    private Pattern countPattern = Pattern.compile("Show count of employee for (.*?).");
//    private Pattern searchPattern = Pattern.compile("Global search by (.*?).");
    private static Logger LOG = LoggerFactory
            .getLogger(SpringBootConsoleApplication.class);

    public static void main(String[] args) {
        LOG.info("STARTING THE APPLICATION");
        SpringApplication.run(SpringBootConsoleApplication.class, args);
        LOG.info("APPLICATION FINISHED");
    }

    @Override
    public void run(String... args) {
        LOG.info("EXECUTING : command line runner");
        LOG.info("args[0]: {}", args[0]);
        checkInput(args);
    }

    private void checkInput(String[] args){
        LOG.info("\n\n\n\n\n");

        if (args[0].equals("reset") && args.length==1){
//            resetTable();
            new FillTheTable(departmentRepo, lectorRepo, salaryRepo).fill();
            return ;
        }

        if (args[0].equals("Who") && args.length==6){
            LOG.info("who head is: {}", args[args.length - 1]);
            return ;
        }

        if (args[0].equals("Show") && args.length==3){
            LOG.info("stat {}", args[1]);
            return ;
        }

        if (args[0].equals("Show") && args.length==8){
            LOG.info("avsalary {}", args[args.length - 1]);
            return ;
        }

        if (args[0].equals("Show") && args.length==6){
            LOG.info("count {}", args[args.length - 1]);
            return ;
        }

        if (args[0].equals("Global") && args.length==4){
            LOG.info("search {}", args[args.length - 1]);
            return ;
        }
        /*Matcher matcher = headPattern.matcher(input);
        if (matcher.find()){
            LOG.info("who head is {}", matcher.group(1));
            return ;
        }

        matcher = statPattern.matcher(input);
        if (matcher.find()) {
            LOG.info("show stat {}", matcher.group(1));
            return ;
        }

        matcher = avsalaryPattern.matcher(input);
        if (matcher.find()) {
            LOG.info("avsalary {}", matcher.group(1));
            return ;
        }

        matcher = countPattern.matcher(input);
        if (matcher.find()) {
            LOG.info("count {}", matcher.group(1));
            return ;
        }

        matcher = searchPattern.matcher(input);
        if (matcher.find()) {
            LOG.info("search {}", matcher.group(1));
            return ;
        }
*/
        LOG.info("UNRECOGNIZED command: {}", args);
    }

/*    public void resetTable(){
        Department one = new Department("one", "zZ");
        Department two = new Department("two", "xX");
        departmentRepo.save(one);
        departmentRepo.save(two);

        Lector l1 = new Lector("la1", "lb1", "lc1");
        Lector l2 = new Lector("la2", "lb2", "lc2");

        lectorRepo.save(l1);
        lectorRepo.save(l2);

        Salary s1 = new Salary(l1, one, 100);
        Salary s2 = new Salary(l1, two, 200);
        Salary s3 = new Salary(l2, one, 350);

        salaryRepo.save(s1);
        salaryRepo.save(s2);
        salaryRepo.save(s3);


        Set<Salary> set1 = new HashSet<>();
        set1.add(s1);
        set1.add(s3);
        one.setSalaries(set1);

        Set<Salary> set2 = new HashSet<>();
        set2.add(s2);
        one.setSalaries(set2);

        departmentRepo.save(one);
        departmentRepo.save(two);

        LOG.info("resetting table");
    }*/
}