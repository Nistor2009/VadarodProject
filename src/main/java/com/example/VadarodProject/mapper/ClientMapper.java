package com.example.VadarodProject.mapper;

import com.example.VadarodProject.dto.ClientDto;
import com.example.VadarodProject.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    @Mapping(target = "id", source = "id")
    ClientDto toDto(Client client);

    Client toEntity(ClientDto clientDto);

    List<ClientDto> toClientDtoList(List<Client> clients);
    List<Client> toClientList(List<ClientDto> Dtos);



    }
