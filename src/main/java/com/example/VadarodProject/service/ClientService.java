package com.example.VadarodProject.service;

import com.example.VadarodProject.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
//    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
}
