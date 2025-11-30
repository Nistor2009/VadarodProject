package com.example.VadarodProject.controller;

import com.example.VadarodProject.dto.ClientDto;
import com.example.VadarodProject.dto.RecipeDto;
import com.example.VadarodProject.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/client")
public class ClientRestController {
    private final ClientService clientService;

    @GetMapping("{id}")
    public ResponseEntity<ClientDto> getClientById(@PathVariable("id") Long id) {
        ClientDto clientDto = clientService.findById(id);
        return new ResponseEntity<>(clientDto, HttpStatus.OK);
    }

    @GetMapping("/find")
    public ResponseEntity<ClientDto> getClientByParam(@RequestParam("id") Long id) {
        ClientDto clientDto = clientService.findById(id);
        return new ResponseEntity<>(clientDto, HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<ClientDto>> getAllClient() {
        List<ClientDto> clientDto = clientService.findAll();
        return new ResponseEntity<>(clientDto, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ClientDto addClient(@RequestBody ClientDto clientDto) {
        return clientService.addClient(clientDto);
    }

    @PostMapping("/delete")
    public ClientDto deleteClient(@RequestBody ClientDto clientDto) {
        return clientService.deleteClient(clientDto);
    }

    @PostMapping("/addRecipe")
    public ClientDto addClient(@RequestParam("id") Long id, @RequestBody RecipeDto recipeDto) {
        return clientService.addRecipe(id, recipeDto);
    }
}
