package com.example.dbtest.repos;

import com.example.dbtest.domain.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface DepartmentRepo extends CrudRepository<Department, Long> {
}
