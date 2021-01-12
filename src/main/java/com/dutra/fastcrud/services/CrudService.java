package com.dutra.fastcrud.services;

import javax.validation.Valid;

import com.dutra.fastcrud.interfaces.CrudEntity;
import com.dutra.fastcrud.repositorys.CrudRepository;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

public abstract class CrudService<T extends Comparable<CrudEntity>> {

    public abstract CrudRepository<T> getService();

    protected abstract void validCreate(T entity);

    protected abstract void validUpdate(T newEntity);

    protected abstract void validDelete(T entity);

    @Transactional
    public T create(@Valid T entity) {
        validCreate(entity);
        return getService().save(entity);
    }

    @Transactional
    public T update(@Valid T entity) {
        validUpdate(entity);
        return getService().save(entity);
    }

    @Transactional
    public void delete(@Valid T entity) {
        validDelete(entity);
        getService().delete(entity);
    }

    @Transactional
    public void delete(Long entityId) throws NotFoundException {
        T entity = findById(entityId);
        validDelete(entity);
        getService().delete(entity);
    }

    @Transactional(readOnly = true)
    public Page<T> findAll(Specification<T> specification, Pageable page) {
        return getService().findAll(specification, page);
    }

    @Transactional(readOnly = true)
    public T findById(Long id) throws NotFoundException {
        return getService().findById(id).orElseThrow(NotFoundException::new);
    }

}