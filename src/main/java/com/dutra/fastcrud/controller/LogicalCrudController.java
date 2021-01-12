package com.dutra.fastcrud.controller;

import com.dutra.fastcrud.bases.LogicalCrudEntity;
import com.dutra.fastcrud.services.LogicalCrudService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

public abstract class LogicalCrudController<T extends LogicalCrudEntity> extends CrudController<T> {

    public abstract LogicalCrudService<T> getService();

    @PatchMapping("/{id}/inactive")
    public ResponseEntity<ApiResponse> inactive(@PathVariable("id") Long id) throws ChangeSetPersister.NotFoundException {
        return ResponseEntity.ok(new ApiResponse(HttpStatus.OK, true, "Recovered.", getService().deactivated(id)));
    }

    @PatchMapping("/{id}/activate")
    public ResponseEntity<ApiResponse> active(@PathVariable("id") Long id) throws ChangeSetPersister.NotFoundException {
        return ResponseEntity.ok(new ApiResponse(HttpStatus.OK, true, "Recovered.", getService().activate( id)));
    }

}
