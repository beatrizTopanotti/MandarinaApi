package com.ecommerce.Mandarinit.entitys;

import com.ecommerce.Mandarinit.entitys.enums.FormaPagamentoEnum;
import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@SQLDelete(sql = "UPDATE pedidos SET deleted_at = now() WHERE id=?")
@Where(clause = "deleted_at is null")
public class Pedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "clientes_id")
    private Clientes cliente;

    @ManyToOne
    @JoinColumn(name = "enderecos_id")
    private ClientesEnderecos endereco;

    @Column(columnDefinition = "timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL")
    private LocalDateTime dataPedido;

    @Column
    private Double totalPedido;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.REMOVE)
    private List<PedidosItens> pedidoItens;

    @Enumerated(EnumType.STRING)
    private FormaPagamentoEnum formaPagamento;

    @OneToOne
    @JoinColumn(name = "boleto_id")
    private PagBoleto boleto;

    @OneToOne
    @JoinColumn(name = "cartao_id")
    private PagCartao cartao;

    @OneToOne
    @JoinColumn(name = "pix_id")
    private PagPix pix;

    public Pedidos() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public ClientesEnderecos getEndereco() { return endereco; }

    public void setEndereco(ClientesEnderecos endereco) { this.endereco = endereco; }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDateTime dataPedido) {
        this.dataPedido = dataPedido;
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

    @Override
    public String toString() {
        return "Pedidos{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", dataPedido=" + dataPedido +
                ", totalPedido=" + totalPedido +
                ", pedidoItens=" + pedidoItens +
                ", formaPagamento=" + formaPagamento +
                ", boleto=" + boleto +
                ", cartao=" + cartao +
                ", pix=" + pix +
                '}';
    }

}
