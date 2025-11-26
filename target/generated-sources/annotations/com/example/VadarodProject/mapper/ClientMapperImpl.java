package com.example.VadarodProject.mapper;

import com.example.VadarodProject.dto.ClientDto;
import com.example.VadarodProject.dto.ClientUpdateRequest;
import com.example.VadarodProject.entity.Client;
import com.example.VadarodProject.entity.Recipe;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-26T21:08:10+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class ClientMapperImpl implements ClientMapper {

    @Override
    public ClientDto toDto(Client client) {
        if ( client == null ) {
            return null;
        }

        ClientDto clientDto = new ClientDto();

        clientDto.setId( client.getId() );
        clientDto.setName( client.getName() );
        clientDto.setSurname( client.getSurname() );
        clientDto.setAge( client.getAge() );
        clientDto.setPhone( client.getPhone() );
        List<Recipe> list = client.getRecipe();
        if ( list != null ) {
            clientDto.setRecipe( new ArrayList<Recipe>( list ) );
        }

        return clientDto;
    }

    @Override
    public Client toEntity(ClientDto clientDto) {
        if ( clientDto == null ) {
            return null;
        }

        Client client = new Client();

        client.setId( clientDto.getId() );
        client.setName( clientDto.getName() );
        client.setSurname( clientDto.getSurname() );
        client.setAge( clientDto.getAge() );
        client.setPhone( clientDto.getPhone() );
        List<Recipe> list = clientDto.getRecipe();
        if ( list != null ) {
            client.setRecipe( new ArrayList<Recipe>( list ) );
        }

        return client;
    }

    @Override
    public void UpdateClient(Client client, ClientUpdateRequest updateRequest) {
        if ( updateRequest == null ) {
            return;
        }

        client.setName( updateRequest.getName() );
        client.setSurname( updateRequest.getSurname() );
        client.setAge( updateRequest.getAge() );
        client.setPhone( updateRequest.getPhone() );
        if ( client.getRecipe() != null ) {
            List<Recipe> list = updateRequest.getRecipe();
            if ( list != null ) {
                client.getRecipe().clear();
                client.getRecipe().addAll( list );
            }
            else {
                client.setRecipe( null );
            }
        }
        else {
            List<Recipe> list = updateRequest.getRecipe();
            if ( list != null ) {
                client.setRecipe( new ArrayList<Recipe>( list ) );
            }
        }
    }

    @Override
    public List<ClientDto> toClientDtoList(List<Client> clients) {
        if ( clients == null ) {
            return null;
        }

        List<ClientDto> list = new ArrayList<ClientDto>( clients.size() );
        for ( Client client : clients ) {
            list.add( toDto( client ) );
        }

        return list;
    }

    @Override
    public List<Client> toClientList(List<ClientDto> Dtos) {
        if ( Dtos == null ) {
            return null;
        }

        List<Client> list = new ArrayList<Client>( Dtos.size() );
        for ( ClientDto clientDto : Dtos ) {
            list.add( toEntity( clientDto ) );
        }

        return list;
    }
}
