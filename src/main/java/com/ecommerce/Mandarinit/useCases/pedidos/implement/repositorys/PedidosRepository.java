package com.ecommerce.Mandarinit.useCases.pedidos.implement.repositorys;

import com.ecommerce.Mandarinit.entitys.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PedidosRepository extends JpaRepository<Pedidos, Long> {
    Optional<Pedidos> findById(Long id);
    Optional<List<Pedidos>> findByClienteId(Long clienteId);
}
