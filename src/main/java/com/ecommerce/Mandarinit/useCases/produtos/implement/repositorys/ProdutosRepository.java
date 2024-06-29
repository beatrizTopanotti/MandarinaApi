package com.ecommerce.Mandarinit.useCases.produtos.implement.repositorys;

import com.ecommerce.Mandarinit.entitys.Produtos;
import com.ecommerce.Mandarinit.entitys.enums.CategoriasEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutosRepository extends JpaRepository<Produtos, Long> {
    List<Produtos> findByCategoria(CategoriasEnum categoria);
    List<Produtos> findByNomeContainingIgnoreCase(String nome);
}
