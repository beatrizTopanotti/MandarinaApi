package com.ecommerce.Mandarinit.useCases.pedidos;

import com.ecommerce.Mandarinit.entitys.Clientes;
import com.ecommerce.Mandarinit.entitys.Pedidos;
import com.ecommerce.Mandarinit.entitys.Produtos;
import com.ecommerce.Mandarinit.useCases.clientes.implement.repositorys.ClientesRepository;
import com.ecommerce.Mandarinit.useCases.pedidos.domains.PedidosRequestDom;
import com.ecommerce.Mandarinit.useCases.pedidos.domains.PedidosResponseDom;
import com.ecommerce.Mandarinit.useCases.pedidos.implement.mappers.PedidosMappers;
import com.ecommerce.Mandarinit.useCases.pedidos.implement.repositorys.PedidosRepository;
import com.ecommerce.Mandarinit.useCases.produtos.domains.ProdutosResponseDom;
import com.ecommerce.Mandarinit.useCases.produtos.implement.mappers.ProdutosMappers;
import com.ecommerce.Mandarinit.utils.MandarinException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PedidosService {

    @Autowired
    private PedidosRepository pedidosRepository;

    @Autowired
    private ClientesRepository clientesRepository;

    public PedidosResponseDom criarPedido(PedidosRequestDom pedidoInput) throws MandarinException {
        Optional<Clientes> clienteValidacao = clientesRepository.findById(pedidoInput.getClienteId());
        if(clienteValidacao.isPresent()) {
            Pedidos pedidoResult = pedidosRepository.save(PedidosMappers.pedidosRequestDomToPedidos(pedidoInput));


            return PedidosMappers.pedidosToPedidosResponseDom(pedidoResult);
        }

        throw new MandarinException("Não foi possível gravar o pedido");
    }

    public List<PedidosResponseDom> carregarPedidosPorClienteId(Long clienteId) throws Exception {
        List<PedidosResponseDom> out = new ArrayList<>();
        if (clienteId == null){
          throw new MandarinException("Cliente não encontrado!");
        }

        Optional<List<Pedidos>> result = pedidosRepository.findByClienteId(clienteId);

        if(!result.isPresent()) {
            out = result.get().stream().map(PedidosMappers::pedidosToPedidosResponseDom).toList();
        }
        return out;
    }

}