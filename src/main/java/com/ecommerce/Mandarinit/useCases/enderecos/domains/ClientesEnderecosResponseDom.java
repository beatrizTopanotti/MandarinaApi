package com.ecommerce.Mandarinit.useCases.enderecos.domains;

import com.ecommerce.Mandarinit.entitys.Cidades;
import com.ecommerce.Mandarinit.entitys.Clientes;
import com.ecommerce.Mandarinit.entitys.Pedidos;

import java.util.List;

public class ClientesEnderecosResponseDom {

    private Cidades cidade;
    private String bairro;
    private String rua;
    private Clientes cliente;
    private List<Pedidos> pedidos;

    public Cidades getCidade() {
        return cidade;
    }

    public void setCidade(Cidades cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public List<Pedidos> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedidos> pedidos) {
        this.pedidos = pedidos;
    }
}
