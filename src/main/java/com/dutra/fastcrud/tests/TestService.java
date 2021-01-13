package com.dutra.fastcrud.tests;

import com.dutra.fastcrud.repositories.CrudRepository;
import com.dutra.fastcrud.services.LogicalCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService extends LogicalCrudService<TestEntity> {

    @Override
    public CrudRepository<TestEntity> getRepository() {
        return repository;
    }

    @Override
    protected void internalCreate(TestEntity entity) {

    }

    @Override
    protected void internalUpdate(TestEntity originalEntity, TestEntity newEntity) {

    }

    @Override
    protected void internalDelete(TestEntity entity) {

    }

    @Autowired
    private TestRepository repository;

    @Override
    public void internalActivate(TestEntity entity) {

    }

    @Override
    public void internalDeactivate(TestEntity entity) {

    }
}
