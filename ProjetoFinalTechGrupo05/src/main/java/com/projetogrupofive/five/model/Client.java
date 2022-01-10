package com.projetogrupofive.five.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity //indica que esta classe sera armazenada no banco de dados
@Table(name = "tb_cliente")
public class Client {
    
    @Id // Chave primária
    // BD gera este código automaticamente, em sequencia: 1, 2, 3....
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private long codigo;

    @Column(name = "nome", length = 200, nullable = false) //nullable campo obrigatorio
    private String nome;

    @Column(name = "cpf", length = 12, nullable = false, unique = true) // unique = não pode ter 2 cpfs iguais
    private String cpf;

    @Column(name = "telefone", length = 15, nullable = false)
    private String telefone;

    @Column(name = "email", length = 50, nullable = false, unique = true)
    private String email;

    // Um cliente pode ter várias contas
    @OneToMany(mappedBy = "titular")
    @JsonIgnoreProperties("titular")
    private List<AccountBank> contas;

        /*public Client() {
            
        }

        public Client(String nome, String cpf, String telefone, String email) {
            this.nome = nome;
            this.cpf = cpf;
            this.telefone = telefone;
            this.email = email;
        }*/

        public long getCodigo() {
            return codigo;
        }

        public void setCodigo(long codigo) {
            this.codigo = codigo;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getCpf() {
            return cpf;
        }

        public void setCpf(String cpf) {
            this.cpf = cpf;
        }

        public String getTelefone() {
            return telefone;
        }

        public void setTelefone(String telefone) {
            this.telefone = telefone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public List<AccountBank> getContas() {
            return contas;
        }

        public void setContas(List<AccountBank> contas) {
            this.contas = contas;
        }
}
