package com.ecommerce.Mandarinit.controllers;

import com.ecommerce.Mandarinit.entitys.Clientes;
import com.ecommerce.Mandarinit.useCases.enderecos.ClientesEnderecosService;
import com.ecommerce.Mandarinit.useCases.enderecos.domains.ClientesEnderecosRequestDom;
import com.ecommerce.Mandarinit.useCases.enderecos.domains.ClientesEnderecosResponseDom;
import com.ecommerce.Mandarinit.useCases.produtos.domains.ProdutosResponseDom;
import com.ecommerce.Mandarinit.utils.MandarinException;
import com.ecommerce.Mandarinit.utils.ResponseUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/enderecos")
@CrossOrigin
public class ClientesEnderecosController {

    @Autowired
    private ClientesEnderecosService clientesEnderecosService;

    @PostMapping("/")
    public ResponseEntity<?> criarEndereco(@Valid @RequestBody ClientesEnderecosRequestDom endereco) {
        try {
            ClientesEnderecosResponseDom response = clientesEnderecosService.criarClientesEnderecos(endereco);
            return ResponseEntity.status(201).body(response);
        } catch (MandarinException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(ResponseUtil.responseMap(e.getMessages()));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(ResponseUtil.responseMap("Erro não mapeado " + e.getMessage()));
        }
    }

    @PutMapping("/{cliente_id}")
    public ResponseEntity<?> atualizarEndereco(@PathVariable Long id, @Valid @RequestBody ClientesEnderecosRequestDom endereco) {
        try {
            ClientesEnderecosResponseDom response = clientesEnderecosService.atualizarClientesEnderecos(id, endereco);
            if (response == null) {
                return ResponseEntity.badRequest().body(null);
            }
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }


    @GetMapping("/")
    public ResponseEntity<?> carregarEnderecos(@RequestParam(required = false) Clientes cliente) {
        try {
            List<ClientesEnderecosResponseDom> out = clientesEnderecosService.carregarClientesEnderecos(cliente);

            if (!out.isEmpty()) {
                return ResponseEntity.ok(out);
            }

            return ResponseEntity.noContent().build();
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Erro não mapeado: " + e.getMessage());
        }
    }


}
