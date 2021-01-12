package com.dutra.fastcrud.tests;

import com.dutra.fastcrud.repositorys.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends CrudRepository<TestEntity> {
}
