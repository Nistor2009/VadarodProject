package com.example.VadarodProject.service;

import com.example.VadarodProject.dto.ClientDto;
import com.example.VadarodProject.dto.RecipeDto;
import com.example.VadarodProject.entity.Client;
import com.example.VadarodProject.mapper.ClientMapper;
import com.example.VadarodProject.mapper.RecipeMapper;
import com.example.VadarodProject.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    private final RecipeMapper recipeMapper;

    public ClientDto addClient(ClientDto client) {
        return clientMapper.toDto(clientRepository.save(clientMapper.toEntity(client)));
    }

    public ClientDto deleteClient(ClientDto client) {
        clientRepository.delete(clientMapper.toEntity(client));
        return client;
    }

    public ClientDto findById(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        return clientMapper.toDto(client.orElse(new Client()));
    }

    public List<ClientDto> findAll() {
        return clientMapper.toClientDtoList((List<Client>) clientRepository.findAll());
    }

    public ClientDto addRecipe(Long clientId, RecipeDto recipeDto){
        ClientDto client = clientMapper.toDto(clientRepository.findById(clientId).orElseThrow(()->new RuntimeException("No such client")));
        client.getRecipe().add(recipeMapper.toEntity(recipeDto));
        clientRepository.save(clientMapper.toEntity(client));
        return client;
    }

}
