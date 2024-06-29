package com.ecommerce.Mandarinit.controllers;
import com.ecommerce.Mandarinit.entitys.enums.CategoriasEnum;
import com.ecommerce.Mandarinit.useCases.produtos.ProdutosService;
import com.ecommerce.Mandarinit.useCases.produtos.domains.ProdutosResponseDom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/produtos")
@CrossOrigin
public class ProdutosController {

    @Autowired
    private ProdutosService produtosService;

    @GetMapping("/")
    public ResponseEntity<?> carregarProdutos(@RequestParam(required = false) String nome) {
        try {
            List<ProdutosResponseDom> out = produtosService.carregarProdutos(nome);

            if (!out.isEmpty()) {
                return ResponseEntity.ok(out);
            }

            return ResponseEntity.noContent().build();
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Erro não mapeado: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> carregarProdutoById(@PathVariable Long id) {
        try {
            ProdutosResponseDom out = produtosService.carregarProdutoById(id);

            if (out != null) {
                return ResponseEntity.ok(out);
            }

            return ResponseEntity.noContent().build();
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Erro não mapeado: " + e.getMessage());
        }
    }

    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<?> carregarProdutosByCategoria(@PathVariable CategoriasEnum categoria) {
        try {
            List<ProdutosResponseDom> out = produtosService.carregarProdutosByCategoria(categoria);

            if (out != null) {
                return ResponseEntity.ok(out);
            }

            return ResponseEntity.noContent().build();
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Erro não mapeado: " + e.getMessage());
        }
    }

}
