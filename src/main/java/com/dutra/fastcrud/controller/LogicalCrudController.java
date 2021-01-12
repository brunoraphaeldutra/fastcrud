package com.dutra.fastcrud.controller;

import com.dutra.fastcrud.bases.CrudEntity;
import com.dutra.fastcrud.bases.LogicalCrudEntity;
import com.dutra.fastcrud.services.CrudService;
import com.dutra.fastcrud.services.LogicalCrudService;
import com.dutra.fastcrud.specifications.AbstractSpecification;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public abstract class LogicalCrudController<T extends LogicalCrudEntity, ID> extends CrudController<T, ID> {

    public abstract LogicalCrudService<T, ID> getService();

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> inactive(@RequestParam("id") Long id) throws ChangeSetPersister.NotFoundException {
        return ResponseEntity.ok(new ApiResponse(HttpStatus.OK, true, "Recovered.", getService().deactivated((ID) id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> active(@RequestParam("id") Long id) throws ChangeSetPersister.NotFoundException {
        return ResponseEntity.ok(new ApiResponse(HttpStatus.OK, true, "Recovered.", getService().activate((ID) id)));
    }

}
