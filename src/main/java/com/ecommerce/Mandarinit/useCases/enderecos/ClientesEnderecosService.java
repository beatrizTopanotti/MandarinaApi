package com.ecommerce.Mandarinit.useCases.enderecos;

import com.ecommerce.Mandarinit.entitys.Clientes;
import com.ecommerce.Mandarinit.entitys.ClientesEnderecos;
import com.ecommerce.Mandarinit.useCases.clientes.implement.repositorys.ClientesRepository;
import com.ecommerce.Mandarinit.useCases.enderecos.domains.ClientesEnderecosRequestDom;
import com.ecommerce.Mandarinit.useCases.enderecos.domains.ClientesEnderecosResponseDom;
import com.ecommerce.Mandarinit.useCases.enderecos.implement.mappers.ClientesEnderecosMappers;
import com.ecommerce.Mandarinit.useCases.enderecos.implement.repositorys.ClientesEnderecosRepository;
import com.ecommerce.Mandarinit.utils.MandarinException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientesEnderecosService {

    @Autowired
    private ClientesEnderecosRepository clientesEnderecosRepository;

    @Autowired
    private ClientesRepository clientesRepository;

    public ClientesEnderecosResponseDom criarClientesEnderecos(ClientesEnderecosRequestDom enderecoInput) throws MandarinException {

        Optional<Clientes> clienteValidacao = clientesRepository.findById(enderecoInput.getCliente().getId());
        if(clienteValidacao.isPresent()){
            ClientesEnderecos enderecoResult = clientesEnderecosRepository.save(ClientesEnderecosMappers.
                    clientesEnderecosRequestDomToClientesEnderecos(enderecoInput));

            enderecoResult.setCliente(enderecoInput.getCliente());

            return ClientesEnderecosMappers.clientesEnderecosToClientesEnderecosResponseDom(enderecoResult);
        }


        throw new MandarinException("Endereço já existe ou não é válido");
    }

    public ClientesEnderecosResponseDom atualizarClientesEnderecos(Long id, ClientesEnderecosRequestDom enderecoInput) {
        Optional<ClientesEnderecos> resultado = clientesEnderecosRepository.findById(id).map(record ->{
            record.setCidade(enderecoInput.getCidade());
            record.setBairro(enderecoInput.getBairro());
            record.setRua(enderecoInput.getRua());

            return clientesEnderecosRepository.save(record);
        });


        return null;
    }

    public List<ClientesEnderecosResponseDom> carregarClientesEnderecos(Clientes cliente) {
        List<ClientesEnderecosResponseDom> out = new ArrayList<>();
        List<ClientesEnderecos> result = cliente == null ? clientesEnderecosRepository.findAll() :
                clientesEnderecosRepository.findByCliente(cliente);

        if(!result.isEmpty()) {
            return result.stream().map(ClientesEnderecosMappers::
                    clientesEnderecosToClientesEnderecosResponseDom).toList();
        }

        return null;
    }

}
