package com.projetogrupofive.five.controller;

import java.util.List;

import com.projetogrupofive.five.dto.AccountBankDto;
import com.projetogrupofive.five.model.AccountBank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conta")
@CrossOrigin("*")
public class AccountController {
    
    @Autowired // Pede para implementar a classe e os métodos de acesso
    private AccountBankDto dtoAccountBank;

    @GetMapping("/contas") // Mostrar todas as contas
    public List<AccountBank> getAllAccount() {
        return dtoAccountBank.listAllAccount();
    }

    @GetMapping("/{numero}") // encontrar conta de acordo com {numero}
    public ResponseEntity<AccountBank> getByNumero(@PathVariable long numero) {
        AccountBank accountFound = dtoAccountBank.searchAccountPerCode(numero);

        if(accountFound !=null) {
            return ResponseEntity.ok(accountFound);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/debito") // Debitar na conta
    public ResponseEntity<AccountBank> debtAccountBank(@RequestBody AccountBank accountBank) {
        AccountBank accountInserid = dtoAccountBank.debtAccountBank(accountBank);
        if(accountInserid != null){
            return ResponseEntity.ok(accountInserid);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/credito") // Creditar na conta
    public ResponseEntity<AccountBank> creditAccountBank(@RequestBody AccountBank accountBank) {
        AccountBank accountInserid = dtoAccountBank.creditAccountBank(accountBank);
        if(accountInserid != null){
            return ResponseEntity.ok(accountInserid);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/excluir/{numero}")
    public ResponseEntity<Void> deleteAccountBank(@PathVariable long numero) {
        String accountDelete = dtoAccountBank.deleteAccountBank(numero);

        if(accountDelete == "ok"){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else if (accountDelete == "erro"){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
