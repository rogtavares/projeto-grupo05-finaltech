package com.projetogrupofive.five.repository;

import com.projetogrupofive.five.model.AccountBank;

import org.springframework.data.repository.CrudRepository;

public interface AccountRepo extends CrudRepository<AccountBank, Long> {
    
    
}
