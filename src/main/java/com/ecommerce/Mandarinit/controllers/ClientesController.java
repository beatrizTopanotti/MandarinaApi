package com.ecommerce.Mandarinit.controllers;

import com.ecommerce.Mandarinit.useCases.clientes.ClientesService;
import com.ecommerce.Mandarinit.useCases.clientes.domains.ClientesAutenticacaoRequestDom;
import com.ecommerce.Mandarinit.useCases.clientes.domains.ClientesRequestDom;
import com.ecommerce.Mandarinit.useCases.clientes.domains.ClientesResponseDom;
import com.ecommerce.Mandarinit.utils.MandarinException;
import com.ecommerce.Mandarinit.utils.ResponseUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clientes")
@CrossOrigin
public class ClientesController {

    @Autowired
    private ClientesService clientesService;

    @PostMapping("/")
    public ResponseEntity<?> criarCliente(@Valid @RequestBody ClientesRequestDom cliente){
        try {
            ClientesResponseDom response = clientesService.criarCliente(cliente);
            return ResponseEntity.status(201).body(response);
        } catch (MandarinException e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(ResponseUtil.responseMap(e.getMessages()));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(ResponseUtil.responseMap("Erro não Mapeado " + e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarCliente(@PathVariable Long id, @Valid @RequestBody ClientesRequestDom cliente){
        try {
            ClientesResponseDom response = clientesService.atualizarCliente(id, cliente);

            if (response == null){
                return ResponseEntity.badRequest().body(null);
            }

            return ResponseEntity.ok(response);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/autenticar/")
    public ResponseEntity<?> autenticarCliente(@Valid @RequestBody ClientesAutenticacaoRequestDom cliente){
        try {
            ClientesResponseDom response = clientesService.autenticarCliente(cliente.getEmail(), cliente.getSenha());
            return ResponseEntity.ok(response);
        } catch (MandarinException e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(ResponseUtil.responseMap(e.getMessages()));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(ResponseUtil.responseMap("Erro não Mapeado " + e.getMessage()));
        }
    }

}
