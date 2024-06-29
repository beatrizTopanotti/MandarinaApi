package com.ecommerce.Mandarinit.useCases.clientes;

import com.ecommerce.Mandarinit.entitys.Clientes;
import com.ecommerce.Mandarinit.useCases.clientes.domains.ClientesRequestDom;
import com.ecommerce.Mandarinit.useCases.clientes.domains.ClientesResponseDom;
import com.ecommerce.Mandarinit.useCases.clientes.implement.mappers.ClientesMappers;
import com.ecommerce.Mandarinit.useCases.clientes.implement.repositorys.ClientesRepository;
import com.ecommerce.Mandarinit.utils.MandarinException;
import com.ecommerce.Mandarinit.utils.SenhaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientesService {

    @Autowired
    private ClientesRepository clientesRepository;

    public ClientesResponseDom criarCliente(ClientesRequestDom clienteInput) throws MandarinException {
        Optional<Clientes> clienteValidacao = clientesRepository.findByEmail(clienteInput.getEmail());
        if(!clienteValidacao.isPresent()){

            Clientes clienteResult = clientesRepository.save(ClientesMappers.criarClientesRequestDomToClientes(clienteInput));

            return ClientesMappers.clientesToClientesResponseDom(clienteResult);
        }

        throw new MandarinException("Email do cliente já existe");
    }

    public ClientesResponseDom atualizarCliente(Long id, ClientesRequestDom clienteInput) {
        Optional<Clientes> resultado = clientesRepository.findById(id).map(record -> {
            record.setDocumento(clienteInput.getDocumento());
            record.setEmail(clienteInput.getEmail());
            record.setNome(clienteInput.getNome());
            record.setSobrenome(clienteInput.getSobrenome());
            record.setSenha(clienteInput.getSenha());
            record.setEnderecos(clienteInput.getEnderecos()); // talvez eu tire


            return clientesRepository.save(record);
        });

        if(resultado.isPresent()){
            Clientes clienteResult = resultado.get();

            return ClientesMappers.clientesToClientesResponseDom(clienteResult);
        }
        return null;
    }

    public ClientesResponseDom autenticarCliente(String email, String senha) throws MandarinException {
        Optional<Clientes> clienteResult = clientesRepository.findByEmail(email);
        if(clienteResult.isPresent()){
            if(SenhaUtil.validarSenha(senha, clienteResult.get().getSenha())){
                return ClientesMappers.clientesToClientesResponseDom(clienteResult.get());
            }

            throw new MandarinException("Senha invalida!");
        }

        throw new MandarinException("Cliente não encontrado!");
    }

}
