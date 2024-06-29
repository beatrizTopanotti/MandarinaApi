package com.ecommerce.Mandarinit.controllers;

import com.ecommerce.Mandarinit.entitys.Clientes;
import com.ecommerce.Mandarinit.entitys.enums.CategoriasEnum;
import com.ecommerce.Mandarinit.useCases.clientes.domains.ClientesRequestDom;
import com.ecommerce.Mandarinit.useCases.clientes.domains.ClientesResponseDom;
import com.ecommerce.Mandarinit.useCases.pedidos.PedidosService;
import com.ecommerce.Mandarinit.useCases.pedidos.domains.PedidosRequestDom;
import com.ecommerce.Mandarinit.useCases.pedidos.domains.PedidosResponseDom;
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
@RequestMapping("/pedidos")
@CrossOrigin
public class PedidosController {

    @Autowired
    private PedidosService pedidosService;

    @PostMapping
    public ResponseEntity<?> criarPedido(@Valid @RequestBody PedidosRequestDom pedido) {
        try {
            PedidosResponseDom response = pedidosService.criarPedido(pedido);
            return ResponseEntity.status(201).body(response);
        } catch (MandarinException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(ResponseUtil.responseMap(e.getMessages()));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(ResponseUtil.responseMap("Erro não mapeado" + e.getMessage()));
        }
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<?> carregarPedidosByCliente(@PathVariable Clientes clientes) {
        try {
            List<PedidosResponseDom> out = pedidosService.carregarPedidosPorClienteId(clientes.getId());

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
