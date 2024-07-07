package com.ecommerce.Mandarinit.entitys;

import com.ecommerce.Mandarinit.entitys.enums.CategoriasEnum;
import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@SQLDelete(sql = "UPDATE produtos SET deleted_at = now() WHERE id=?")
@Where(clause = "deleted_at is null")
public class Produtos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String codigoProduto;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private String imagemPequena;

    @Column(nullable = false)
    private String imagemGrande;

    @Column()
    private LocalDateTime createdAt;

    @Column()
    private LocalDateTime deletedAt;

    @OneToMany(mappedBy = "produto")
    private List<ProdutosPrecos> precos;

    @Enumerated(EnumType.STRING)
    private CategoriasEnum categoria;

    public Produtos() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagemPequena() {
        return imagemPequena;
    }

    public void setImagemPequena(String imagemPequena) {
        this.imagemPequena = imagemPequena;
    }

    public String getImagemGrande() {
        return imagemGrande;
    }

    public void setImagemGrande(String imagemGrande) {
        this.imagemGrande = imagemGrande;
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

    public List<ProdutosPrecos> getPrecos() {
        return precos;
    }

    public void setPrecos(List<ProdutosPrecos> precos) {
        this.precos = precos;
    }

    public CategoriasEnum getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriasEnum categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Produtos{" +
                "id=" + id +
                ", codigoProduto='" + codigoProduto + '\'' +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", imagemPequena='" + imagemPequena + '\'' +
                ", imagemGrande='" + imagemGrande + '\'' +
                ", createdAt=" + createdAt +
                ", deletedAt=" + deletedAt +
                ", precos=" + precos +
                ", categoria=" + categoria +
                '}';
    }

}
