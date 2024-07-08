package com.ecommerce.Mandarinit.useCases.clientes.implement.mappers;

import com.ecommerce.Mandarinit.entitys.Clientes;
import com.ecommerce.Mandarinit.useCases.clientes.domains.ClientesRequestDom;
import com.ecommerce.Mandarinit.useCases.clientes.domains.ClientesResponseDom;

public class ClientesMappers {
    public static Clientes clientesRequestDomToClientes(ClientesRequestDom in) {
        Clientes out = new Clientes();
        out.setDocumento(in.getDocumento());
        out.setEmail(in.getEmail());
        out.setNome(in.getNome());
        out.setSobrenome(in.getSobrenome());
        out.setEnderecos(in.getEnderecos());
        out.setPedidos(in.getPedidos());

        return out;
    }

    public static Clientes criarClientesRequestDomToClientes(ClientesRequestDom in) {
        Clientes out = clientesRequestDomToClientes(in);

        out.setSenha(in.getSenha());

        return out;
    }

    public static ClientesResponseDom clientesToClientesResponseDom(Clientes in) {
        ClientesResponseDom out = new ClientesResponseDom();
        out.setDocumento(in.getDocumento());
        out.setEmail(in.getEmail());
        out.setNome(in.getNome());
        out.setSobrenome(in.getSobrenome());
        out.setEnderecos(in.getEnderecos());
        out.setPedidos(in.getPedidos());

        return out;
    }

}
