package com.dutra.fastcrud.bases;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@Embeddable
@MappedSuperclass
public abstract class LogicalCrudEntity extends CrudEntity {
    public abstract void deactivate();
    public abstract void activate();
}
