package com.ecommerce.Mandarinit.useCases.produtos;

import com.ecommerce.Mandarinit.entitys.Produtos;
import com.ecommerce.Mandarinit.entitys.enums.CategoriasEnum;
import com.ecommerce.Mandarinit.useCases.produtos.domains.ProdutosResponseDom;
import com.ecommerce.Mandarinit.useCases.produtos.implement.mappers.ProdutosMappers;
import com.ecommerce.Mandarinit.useCases.produtos.implement.repositorys.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutosService {

    @Autowired
    private ProdutosRepository produtosRepository;

    public List<ProdutosResponseDom> carregarProdutos(String nome){
        List<ProdutosResponseDom> out = new ArrayList<>();
        List<Produtos> result = nome == null ? produtosRepository.findAll() : produtosRepository.findByNomeContainingIgnoreCase(nome);

        if(!result.isEmpty()) {
            out = result.stream().map(ProdutosMappers::produtosParaProdutosResponseDom).toList();
        }

        return out;
    }

    public ProdutosResponseDom carregarProdutoById(Long id){
        Optional<Produtos> result = produtosRepository.findById(id);
        if(result.isPresent()){
            return ProdutosMappers.produtosParaProdutosResponseDom(result.get());
        }

        return null;
    }

    public List<ProdutosResponseDom> carregarProdutosByCategoria(CategoriasEnum categoria) {
        List<Produtos> result = produtosRepository.findByCategoria(categoria);
        if(!result.isEmpty()) {
            return result.stream().map(ProdutosMappers::produtosParaProdutosResponseDom).toList();
        }

        return null;
    }

}
