package com.dutra.fastcrud.services;

import com.dutra.fastcrud.bases.LogicalCrudEntity;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import javax.validation.Valid;

public abstract class LogicalCrudService<T extends LogicalCrudEntity> extends CrudService<T>{

    public abstract void internalActivate(T entity);
    public abstract void internalDeactivate(T entity);

    @Override
    public void delete(@Valid T entity) {
        throw new NotImplementedException();
    }

    @Override
    public boolean delete(Long entityId) {
        throw new NotImplementedException();
    }

    public T activate(T entity){
        entity.activate();
        internalActivate(entity);
        return getRepository().save(entity);
    }

    public T deactivated(T entity){
        entity.deactivate();
        internalDeactivate(entity);
        return getRepository().save(entity);
    }

    public T activate(Long entityId) throws NotFoundException {
        T entity = findById(entityId);
        entity.activate();
        internalActivate(entity);
        return getRepository().save(entity);
    }

    public T deactivated(Long entityId) throws NotFoundException {
        T entity = findById(entityId);
        entity.deactivate();
        internalDeactivate(entity);
        return getRepository().save(entity);
    }

}
