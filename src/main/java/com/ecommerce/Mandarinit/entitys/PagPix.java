package com.ecommerce.Mandarinit.entitys;

import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;

@Entity
@SQLDelete(sql = "UPDATE pag_pix SET deleted_at = now() WHERE id=?")
@Where(clause = "deleted_at is null")
public class PagPix {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomePagador;

    @Column(columnDefinition = "timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL")
    private LocalDateTime horaPagamento;

    public PagPix() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomePagador() {
        return nomePagador;
    }

    public void setNomePagador(String nomePagador) {
        this.nomePagador = nomePagador;
    }

    public LocalDateTime getHoraPagamento() {
        return horaPagamento;
    }

    public void setHoraPagamento(LocalDateTime horaPagamento) {
        this.horaPagamento = horaPagamento;
    }

    @Override
    public String toString() {
        return "PagPix{" +
                "id=" + id +
                ", nomePagador='" + nomePagador + '\'' +
                ", horaPagamento=" + horaPagamento +
                '}';
    }

}