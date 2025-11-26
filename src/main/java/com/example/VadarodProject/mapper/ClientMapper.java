package com.example.VadarodProject.mapper;

import com.example.VadarodProject.dto.ClientDto;
import com.example.VadarodProject.dto.ClientUpdateRequest;
import com.example.VadarodProject.dto.RecipeDto;
import com.example.VadarodProject.entity.Client;
import com.example.VadarodProject.entity.Recipe;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    @Mapping(target = "id", source = "id")
    ClientDto toDto(Client client);

    Client toEntity(ClientDto clientDto);

    @Mapping(target = "id", ignore = true)
    void UpdateClient(@MappingTarget Client client, ClientUpdateRequest updateRequest);

    List<ClientDto> toClientDtoList(List<Client> clients);
    List<Client> toClientList(List<ClientDto> Dtos);

    }
