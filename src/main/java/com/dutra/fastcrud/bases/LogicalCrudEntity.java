package com.dutra.fastcrud.bases;

public abstract class LogicalCrudEntity extends CrudEntity {
    public abstract void deactivate();
    public abstract void activate();
}
