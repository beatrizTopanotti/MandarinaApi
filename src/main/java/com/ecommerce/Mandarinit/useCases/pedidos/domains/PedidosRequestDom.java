package com.ecommerce.Mandarinit.useCases.pedidos.domains;

import com.ecommerce.Mandarinit.entitys.*;
import com.ecommerce.Mandarinit.entitys.enums.FormaPagamentoEnum;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class PedidosRequestDom {

    @NotNull(message = "O cliente não pode ser nulo")
    private Long clienteId;

    @NotNull(message = "O campo endereço não pode ser nulo")
    private Long enderecoId;

    @NotNull(message = "O valor total não pode ser nulo")
    private Double totalPedido;

    @NotNull(message = "O pedido não pode continuar sem itens")
    private List<PedidosItens> pedidoItens;

    @NotNull(message = "O campo forma de pagamento não pode ser nulo")
    private FormaPagamentoEnum formaPagamento;

    private PagBoleto boleto;

    private PagCartao cartao;

    private PagPix pix;

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getEnderecoId() {
        return enderecoId;
    }

    public void setEnderecoId(Long enderecoId) {
        this.enderecoId = enderecoId;
    }

    public Double getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(Double totalPedido) {
        this.totalPedido = totalPedido;
    }

    public List<PedidosItens> getPedidoItens() {
        return pedidoItens;
    }

    public void setPedidoItens(List<PedidosItens> pedidoItens) {
        this.pedidoItens = pedidoItens;
    }

    public FormaPagamentoEnum getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamentoEnum formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public PagBoleto getBoleto() {
        return boleto;
    }

    public void setBoleto(PagBoleto boleto) {
        this.boleto = boleto;
    }

    public PagCartao getCartao() {
        return cartao;
    }

    public void setCartao(PagCartao cartao) {
        this.cartao = cartao;
    }

    public PagPix getPix() {
        return pix;
    }

    public void setPix(PagPix pix) {
        this.pix = pix;
    }
}
