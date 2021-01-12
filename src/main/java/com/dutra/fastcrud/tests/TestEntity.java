package com.dutra.fastcrud.tests;

import com.dutra.fastcrud.bases.LogicalCrudEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TestEntity extends LogicalCrudEntity {


    private boolean active;
    private String name;

    @Override
    public void deactivate() {
        this.active = false;
    }

    @Override
    public void activate() {
        this.active = true;
    }
}
