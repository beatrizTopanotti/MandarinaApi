package com.ecommerce.Mandarinit.useCases.produtos.implement.mappers;

import com.ecommerce.Mandarinit.entitys.Produtos;
import com.ecommerce.Mandarinit.useCases.produtos.domains.ProdutosResponseDom;

public class ProdutosMappers {
    public static ProdutosResponseDom produtosParaProdutosResponseDom(Produtos in){
        ProdutosResponseDom out = new ProdutosResponseDom();
        out.setId(in.getId());
        out.setCodigoProduto(in.getCodigoProduto());
        out.setDescricao(in.getDescricao());
        out.setNome(in.getNome());
        out.setImagemPequena(in.getImagemPequena());
        out.setImagemGrande(in.getImagemGrande());
        out.setCreatedAt(in.getCreatedAt());
        out.setPrecos(in.getPrecos());

        return out;
    }
}
