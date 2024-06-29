package com.ecommerce.Mandarinit.useCases.pedidos.implement.mappers;

import com.ecommerce.Mandarinit.entitys.Clientes;
import com.ecommerce.Mandarinit.entitys.ClientesEnderecos;
import com.ecommerce.Mandarinit.entitys.Pedidos;
import com.ecommerce.Mandarinit.useCases.clientes.ClientesService;
import com.ecommerce.Mandarinit.useCases.enderecos.ClientesEnderecosService;
import com.ecommerce.Mandarinit.useCases.pedidos.domains.PedidosRequestDom;
import com.ecommerce.Mandarinit.useCases.pedidos.domains.PedidosResponseDom;
import org.springframework.beans.factory.annotation.Autowired;

public class PedidosMappers {

    @Autowired
    private ClientesService clientesService;

    @Autowired
    private ClientesEnderecosService clienteEnderecosService;

    public static Pedidos pedidosRequestDomToPedidos(PedidosRequestDom in) {
        Pedidos out = new Pedidos();

        Clientes cliente = new Clientes();
        cliente.setId(in.getClienteId());

        ClientesEnderecos endereco = new ClientesEnderecos();
        endereco.setId(in.getEnderecoId());

        out.setCliente(cliente);
        out.setEndereco(endereco);
        out.setTotalPedido(in.getTotalPedido());
        out.setPedidoItens(in.getPedidoItens());
        out.setFormaPagamento(in.getFormaPagamento());
        out.setBoleto(in.getBoleto());
        out.setCartao(in.getCartao());
        out.setPix(in.getPix());

        return out;
    }

    public static PedidosResponseDom pedidosToPedidosResponseDom(Pedidos in) {


        PedidosResponseDom out = new PedidosResponseDom();
        out.setClienteId(in.getCliente().getId());
        out.setEnderecoId(in.getEndereco().getId());
        out.setTotalPedido(in.getTotalPedido());
        out.setPedidoItens(in.getPedidoItens());
        out.setFormaPagamento(in.getFormaPagamento());
        out.setBoleto(in.getBoleto());
        out.setCartao(in.getCartao());
        out.setPix(in.getPix());

        return out;
    }
}
