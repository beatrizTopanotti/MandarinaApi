package com.ecommerce.Mandarinit.useCases.pedidos.domains;

import com.ecommerce.Mandarinit.entitys.PagBoleto;
import com.ecommerce.Mandarinit.entitys.PagCartao;
import com.ecommerce.Mandarinit.entitys.PagPix;
import com.ecommerce.Mandarinit.entitys.PedidosItens;
import com.ecommerce.Mandarinit.entitys.enums.FormaPagamentoEnum;

import java.time.LocalDateTime;
import java.util.List;

public class PedidosResponseDom {

    private Long id;
    private Long clienteId;
    private LocalDateTime dataPedido;
    private Long enderecoId;
    private Double totalPedido;
    private List<PedidosItens> pedidoItens;
    private FormaPagamentoEnum formaPagamento;
    private PagBoleto boleto;
    private PagCartao cartao;
    private PagPix pix;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDateTime dataPedido) {
        this.dataPedido = dataPedido;
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
