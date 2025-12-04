package com.example.VadarodProject.service;

import com.example.VadarodProject.dto.ClientDto;
import com.example.VadarodProject.entity.Client;
import com.example.VadarodProject.entity.Recipe;
import com.example.VadarodProject.mapper.ClientMapper;
import com.example.VadarodProject.mapper.RecipeMapper;
import com.example.VadarodProject.repository.ClientRepository;
import com.example.VadarodProject.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final RecipeRepository recipeRepository;
    private final ClientMapper clientMapper;

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

    public List<ClientDto> findAll(
            int page,
            int size,
            String sort,
            Sort.Direction sortDirection) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, sort));
        Page<Client> pageClient = clientRepository.findAll(pageable);
        return clientMapper.toClientDtoList(pageClient.get().toList());
    }

    public ClientDto addRecipe(Long clientId, Long recipeId){
        ClientDto client = clientMapper.toDto(clientRepository.findById(clientId).orElseThrow(()->new RuntimeException("No such client")));
        Recipe recipe = recipeRepository.findById(recipeId).orElseThrow(()->new RuntimeException("No such recipe"));
        client.getRecipe().add(recipe);
        clientRepository.save(clientMapper.toEntity(client));
        return client;
    }

}
