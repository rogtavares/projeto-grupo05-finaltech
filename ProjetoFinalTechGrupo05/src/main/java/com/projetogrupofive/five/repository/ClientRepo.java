package com.projetogrupofive.five.repository;

import com.projetogrupofive.five.model.Client;

import org.springframework.data.repository.CrudRepository;

public interface ClientRepo extends CrudRepository<Client, Long> {
    public Client findByCpf(String cpf);
    public Client findByEmail(String email);
    
}
