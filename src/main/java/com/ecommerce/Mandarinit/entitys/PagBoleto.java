package com.ecommerce.Mandarinit.entitys;

import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;

@Entity
@SQLDelete(sql = "UPDATE pag_boleto SET deleted_at = now() WHERE id=?")
@Where(clause = "deleted_at is null")
public class PagBoleto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String codigoBarras;

    @Column(nullable = false, columnDefinition = "timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL")
    private LocalDateTime vencimento;

    @Column(nullable = false)
    private Double valor;

    public PagBoleto() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public LocalDateTime getVencimento() {
        return vencimento;
    }

    public void setVencimento(LocalDateTime vencimento) {
        this.vencimento = vencimento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "PagBoleto{" +
                "id=" + id +
                ", codigoBarras='" + codigoBarras + '\'' +
                ", vencimento=" + vencimento +
                ", valor=" + valor +
                '}';
    }

}
