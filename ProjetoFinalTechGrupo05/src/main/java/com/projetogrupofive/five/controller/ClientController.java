package com.projetogrupofive.five.controller;

import java.util.List;

import com.projetogrupofive.five.dto.ClientDto;
import com.projetogrupofive.five.model.Client;
import com.projetogrupofive.five.repository.ClientRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
@CrossOrigin("*")
public class ClientController {
    
    @Autowired // Pede para implementar a classe e os métodos de acesso
    private ClientDto dtoClient;

    @PostMapping("/novo") // Cadastrar novos clientes
    public ResponseEntity<Client> newClient(@RequestBody Client client) {
        Client clientInserid = dtoClient.newClient(client);
        if(clientInserid != null){
            return ResponseEntity.ok(clientInserid);
        }
        return ResponseEntity.notFound().build();
    }

    @Autowired
    private ClientRepo repo;

    public List<Client> listarTodos(){  // metodo para buscar todos os clientes
        List<Client> lista = (List<Client>) repo.findAll();

        return lista;
    }

}
