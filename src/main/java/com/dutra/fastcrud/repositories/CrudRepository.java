package com.dutra.fastcrud.repositories;

import com.dutra.fastcrud.bases.CrudEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CrudRepository<T extends CrudEntity> extends JpaRepository<T, Long>, JpaSpecificationExecutor<T> {
    //NTD
}
