package com.ecommerce.Mandarinit.useCases.clientes.domains;

import com.ecommerce.Mandarinit.entitys.ClientesEnderecos;
import com.ecommerce.Mandarinit.entitys.Pedidos;

import java.util.List;

public class ClientesResponseDom {

    private Long id;
    private String documento;
    private String email;
    private String nome;
    private String sobrenome;
    private List<ClientesEnderecos> enderecos;
    private List<Pedidos> pedidos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
