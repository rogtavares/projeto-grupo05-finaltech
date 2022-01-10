package com.projetogrupofive.five.dto;

import java.util.List;

import com.projetogrupofive.five.model.AccountBank;
import com.projetogrupofive.five.repository.AccountRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountBankDto {
    
    @Autowired
    private AccountRepo repoAccount;

    public List<AccountBank> listAllAccount() {
        List<AccountBank> list = (List<AccountBank>) repoAccount.findAll();
        return list;
    }

    public AccountBank searchAccountPerCode(long accountNumber) {
        AccountBank accountBank = repoAccount.findById(accountNumber).orElse(null);
        return accountBank;
    }

    public AccountBank debtAccountBank(AccountBank accountDebt) {//Debito
        AccountBank accountBank = repoAccount.findById(accountDebt.getNumero()).orElse(null);

        if(accountBank != null){
            if(accountDebt.getSaldo() > 0){ //Verifico se valor que foi digitado é maior que 0
                if(accountBank.getSaldo() >= accountDebt.getSaldo()){

                    accountDebt.setSaldo(accountBank.getSaldo() - accountDebt.getSaldo()); // Diminuo o saldo da conta

                    //Deixar as variavel sem modificar
                    accountDebt.setAgencia(accountBank.getAgencia());
                    accountDebt.setTipoConta(accountBank.getTipoConta());
                    accountDebt.setTitular(accountBank.getTitular());

                    AccountBank accountUpdate = repoAccount.save(accountDebt);
                    return accountUpdate;
                }
            }
        }
        return null;        
    }

    public AccountBank creditAccountBank(AccountBank accountCredit) {//Credito
        AccountBank accountBank = repoAccount.findById(accountCredit.getNumero()).orElse(null);

        if(accountBank != null){
            if(accountCredit.getSaldo() > 0){

                accountCredit.setSaldo(accountBank.getSaldo() + accountCredit.getSaldo()); 

                //Deixar as variavel sem modificar
                accountCredit.setAgencia(accountBank.getAgencia());
                accountCredit.setTipoConta(accountBank.getTipoConta());
                accountCredit.setTitular(accountBank.getTitular());

                AccountBank accountUpdate = repoAccount.save(accountCredit);
                return accountUpdate;
            }
        }
        return null;        
    }

    public String deleteAccountBank(long accountNumber) {//excluir
        AccountBank accountBank = repoAccount.findById(accountNumber).orElse(null);

        if(accountBank != null){
            if(accountBank.getSaldo() == 0){
                try{
                    repoAccount.deleteById(accountNumber);
                    return "ok";
                }catch (Exception e) {
                    return "erro";
                }
            }
        }
        return null;        
    }
}
