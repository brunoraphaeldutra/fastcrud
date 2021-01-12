package com.dutra.fastcrud.services;

import com.dutra.fastcrud.bases.LogicalCrudEntity;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import javax.validation.Valid;

public abstract class LogicalCrudService<T extends LogicalCrudEntity, ID> extends CrudService<T, ID>{

    @Override
    public void delete(@Valid T entity) {
        throw new NotImplementedException();
    }

    @Override
    public boolean delete(ID entityId) {
        throw new NotImplementedException();
    }

    public T activate(T entity){
        entity.activate();
        delete(entity);
        return getRepository().save(entity);
    }

    public T deactivated(T entity){
        entity.deactivate();
        delete(entity);
        return getRepository().save(entity);
    }

    public T activate(ID entityId) throws NotFoundException {
        T entity = findById(entityId);
        entity.activate();
        delete(entity);
        return getRepository().save(entity);
    }

    public T deactivated(ID entityId) throws NotFoundException {
        T entity = findById(entityId);
        entity.deactivate();
        delete(entity);
        return getRepository().save(entity);
    }

}
