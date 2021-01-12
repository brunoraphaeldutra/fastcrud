package com.dutra.fastcrud.tests;

import com.dutra.fastcrud.controller.LogicalCrudController;
import com.dutra.fastcrud.services.LogicalCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteController extends LogicalCrudController<TestEntity> {

    @Override
    public LogicalCrudService<TestEntity> getService() {
        return service;
    }

    @Autowired
    private TestService service;
}
