package com.ecommerce.Mandarinit.useCases.clientes.implement.repositorys;

import com.ecommerce.Mandarinit.entitys.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Long> {
    Optional<Clientes> findByEmail(String email);
    Optional<Clientes> findById(Long id);
}
