package com.ecommerce.Mandarinit.useCases.clientes.domains;

import com.ecommerce.Mandarinit.entitys.ClientesEnderecos;
import com.ecommerce.Mandarinit.entitys.Pedidos;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class ClientesRequestDom {

    @NotNull(message = "O campo documento não pode ser nulo")
    private String documento;

    @NotNull(message = "O campo email não pode ser nulo")
    private String email;

    @NotNull(message = "O campo nome não pode ser nulo")
    private String nome;

    @NotNull(message = "O campo sobrenome não pode ser nulo")
    private String sobrenome;

    private String senha;

    private List<ClientesEnderecos> enderecos;

    private List<Pedidos> pedidos;

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<ClientesEnderecos> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<ClientesEnderecos> enderecos) {
        this.enderecos = enderecos;
    }

    public List<Pedidos> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedidos> pedidos) {
        this.pedidos = pedidos;
    }
}
