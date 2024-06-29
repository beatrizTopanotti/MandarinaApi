package com.ecommerce.Mandarinit.useCases.enderecos.implement.mappers;

import com.ecommerce.Mandarinit.entitys.ClientesEnderecos;
import com.ecommerce.Mandarinit.useCases.enderecos.domains.ClientesEnderecosRequestDom;
import com.ecommerce.Mandarinit.useCases.enderecos.domains.ClientesEnderecosResponseDom;

public class ClientesEnderecosMappers {
    public static ClientesEnderecos clientesEnderecosRequestDomToClientesEnderecos(ClientesEnderecosRequestDom in) {
        ClientesEnderecos out = new ClientesEnderecos();
        out.setCidade(in.getCidade());
        out.setBairro(in.getBairro());
        out.setRua(in.getRua());
        out.setCliente(in.getCliente());

        return out;
    }

    public static ClientesEnderecosResponseDom clientesEnderecosToClientesEnderecosResponseDom(ClientesEnderecos in) {
        ClientesEnderecosResponseDom out = new ClientesEnderecosResponseDom();
        out.setCidade(in.getCidade());
        out.setBairro(in.getBairro());
        out.setRua(in.getRua());
        out.setCliente(in.getCliente());
        out.setPedidos(in.getPedidos());

        return out;
    }

}
