package com.dutra.fastcrud.controller;

import com.dutra.fastcrud.bases.CrudEntity;
import com.dutra.fastcrud.services.CrudService;
import com.dutra.fastcrud.specifications.AbstractSpecification;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public abstract class CrudController<T extends CrudEntity> extends AbstractController<T, AbstractSpecification> {

    public abstract CrudService<T> getService();

    @PostMapping
    public ResponseEntity<ApiResponse> create(@RequestBody T entity){
        return ResponseEntity.ok(new ApiResponse(HttpStatus.OK, true, "Recovered.", getService().create(entity)));
    }

    @PutMapping
    public ResponseEntity<ApiResponse> update(@RequestBody T entity) throws ChangeSetPersister.NotFoundException {
        return ResponseEntity.ok(new ApiResponse(HttpStatus.OK, true, "Recovered.", getService().update(entity)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable("id") Long id) throws ChangeSetPersister.NotFoundException {
        return ResponseEntity.ok(new ApiResponse(HttpStatus.OK, true, "Recovered.", getService().delete(id)));
    }

    @GetMapping
    public ResponseEntity findAll(@RequestParam(value = "search", required = false) String search,
                                  Pageable pageable){
        Specification<T> spec = buildSpecification(search);
        return ResponseEntity.ok(new ApiResponse(HttpStatus.OK, true, "Recovered.", getService().findAll(spec, pageable)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getById(@PathVariable("id") Long id) throws ChangeSetPersister.NotFoundException {
        return ResponseEntity.ok(new ApiResponse(HttpStatus.OK, true, "Recovered.", getService().findById(id)));
    }
}
