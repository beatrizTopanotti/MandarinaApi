package com.ecommerce.Mandarinit.entitys;

import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;
import java.util.List;

@Entity
//@SQLDelete(sql = "UPDATE clientes_enderecos SET deleted_at = now() WHERE id=?")
//@Where(clause = "deleted_at is null")
public class ClientesEnderecos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cidades_id")
    private Cidades cidade;

    @Column
    private String bairro;

    @Column
    private String rua;

    @ManyToOne
    @JoinColumn(name = "clientes_id")
    private Clientes cliente;

    @OneToMany(mappedBy = "endereco")
    private List<Pedidos> pedidos;

    @Column(columnDefinition = "timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL")
    private LocalDateTime createdAt;

    @Column()
    private LocalDateTime deletedAt;

    public ClientesEnderecos() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    @Override
    public String toString() {
        return "ClientesEnderecos{" +
                "id=" + id +
                ", cidade=" + cidade +
                ", bairro='" + bairro + '\'' +
                ", rua='" + rua + '\'' +
                ", cliente=" + cliente +
                ", pedidos=" + pedidos +
                '}';
    }

}
