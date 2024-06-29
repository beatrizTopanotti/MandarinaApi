package com.ecommerce.Mandarinit.entitys;

import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;

@Entity
@SQLDelete(sql = "UPDATE produtos_precos SET deleted_at = now() WHERE id=?")
@Where(clause = "deleted_at is null")
public class ProdutosPrecos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double preco;

    @ManyToOne
    @JoinColumn(name = "produtos_id", nullable = false)
    private Produtos produto;

    @Column(columnDefinition = "timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL")
    private LocalDateTime createdAt;

    @Column()
    private LocalDateTime deletedAt;

    public ProdutosPrecos() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Produtos getProduto() {
        return produto;
    }

    public void setProduto(Produtos produto) {
        this.produto = produto;
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
        return "ProdutosPrecos{" +
                "id=" + id +
                ", preco=" + preco +
                ", produto=" + produto +
                ", createdAt=" + createdAt +
                ", deletedAt=" + deletedAt +
                '}';
    }

}
