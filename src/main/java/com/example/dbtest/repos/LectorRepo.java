package com.example.dbtest.repos;

import com.example.dbtest.domain.Lector;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface LectorRepo extends CrudRepository<Lector, Long> {
}
