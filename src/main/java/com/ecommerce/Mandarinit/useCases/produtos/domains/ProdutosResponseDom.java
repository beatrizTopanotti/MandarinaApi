package com.ecommerce.Mandarinit.useCases.produtos.domains;

import com.ecommerce.Mandarinit.entitys.ProdutosPrecos;
import com.ecommerce.Mandarinit.entitys.enums.CategoriasEnum;

import java.time.LocalDateTime;
import java.util.List;

public class ProdutosResponseDom {
    private Long id;
    private String codigoProduto;
    private String nome;
    private String descricao;
    private String imagemPequena;
    private String imagemGrande;
    private LocalDateTime createdAt;
    private LocalDateTime deletedAt;
    private List<ProdutosPrecos> precos;
    private CategoriasEnum categoria;

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
}
