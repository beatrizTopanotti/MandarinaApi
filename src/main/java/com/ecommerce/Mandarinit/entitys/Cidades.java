package com.ecommerce.Mandarinit.entitys;

import com.ecommerce.Mandarinit.entitys.enums.EstadosEnum;
import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.List;

@Entity
public class Cidades  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Enumerated(EnumType.STRING)
    private EstadosEnum Estado;

    @OneToMany(mappedBy = "cidade")
    private List<ClientesEnderecos> clientesEnderecos;

    public Cidades() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public EstadosEnum getEstado() {
        return Estado;
    }

    public void setEstado(EstadosEnum estado) {
        Estado = estado;
    }

    public List<ClientesEnderecos> getClientesEnderecos() {
        return clientesEnderecos;
    }

    public void setClientesEnderecos(List<ClientesEnderecos> clientesEnderecos) {
        this.clientesEnderecos = clientesEnderecos;
    }

    @Override
    public String toString() {
        return "Cidades{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", Estado=" + Estado +
                ", clientesEnderecos=" + clientesEnderecos +
                '}';
    }

}
