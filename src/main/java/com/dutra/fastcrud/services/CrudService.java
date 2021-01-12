package com.dutra.fastcrud.services;

import com.dutra.fastcrud.bases.CrudEntity;
import com.dutra.fastcrud.repositorys.CrudRepository;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;

public abstract class CrudService<T extends CrudEntity, ID> {

    public abstract CrudRepository<T, ID> getRepository();

    protected abstract void internalCreate(T entity);

    protected abstract void internalUpdate(T originalEntity, T newEntity);

    protected abstract void internalDelete(T entity);

    @Transactional
    public T create(@Valid T entity) {
        internalCreate(entity);
        return getRepository().save(entity);
    }

    @Transactional
    public T update(@Valid T entity) throws NotFoundException {
        T originalEntity = findById(entity.getId());
        internalUpdate(originalEntity, entity);
        return getRepository().save(originalEntity);
    }

    @Transactional
    public void delete(@Valid T entity) {
        internalDelete(entity);
        getRepository().delete(entity);
    }

    @Transactional
    public boolean delete(ID entityId) throws NotFoundException {
        T entity = findById(entityId);
        internalDelete(entity);
        getRepository().delete(entity);
        return true;
    }

    @Transactional(readOnly = true)
    public Page<T> findAll(Specification<T> specification, Pageable page) {
        return getRepository().findAll(specification, page);
    }

    @Transactional(readOnly = true)
    public T findById(ID id) throws NotFoundException {
        return getRepository().findById(id).orElseThrow(NotFoundException::new);
    }

}
