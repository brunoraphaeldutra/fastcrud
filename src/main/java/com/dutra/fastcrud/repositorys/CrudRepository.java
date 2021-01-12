package com.dutra.fastcrud.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CrudRepository<T> extends JpaRepository<T, Long>, JpaSpecificationExecutor<T> {
    //NTD
}
