package com.ecommerce.Mandarinit.useCases.enderecos.implement.repositorys;

import com.ecommerce.Mandarinit.entitys.Clientes;
import com.ecommerce.Mandarinit.entitys.ClientesEnderecos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientesEnderecosRepository extends JpaRepository<ClientesEnderecos, Long> {
    Optional<ClientesEnderecos> findById(Long id);
    Optional<ClientesEnderecos> findByRua(String rua);
    List<ClientesEnderecos> findByCliente(Clientes cliente);
}
