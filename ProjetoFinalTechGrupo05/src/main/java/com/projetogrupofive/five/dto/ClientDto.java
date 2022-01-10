package com.projetogrupofive.five.dto;

import com.projetogrupofive.five.model.Client;
import com.projetogrupofive.five.repository.ClientRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientDto {
    
    @Autowired
    private ClientRepo repoClient;

    public Client newClient(Client ClientNew) {
        Client cpfClienteEncontrado = repoClient.findByCpf(ClientNew.getCpf());//Verifico se Cpf já existe
        Client emailClienteEncontrado = repoClient.findByEmail(ClientNew.getEmail());// Verifico se o email já existe

        if( cpfClienteEncontrado == null && emailClienteEncontrado == null){
            Client clientInserid = repoClient.save(ClientNew);
            return clientInserid;
        }

        return null;
    }
}
