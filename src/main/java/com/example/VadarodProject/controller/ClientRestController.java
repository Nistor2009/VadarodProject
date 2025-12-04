package com.example.VadarodProject.controller;

import com.example.VadarodProject.dto.ClientDto;
import com.example.VadarodProject.dto.RecipeDto;
import com.example.VadarodProject.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

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
    public ResponseEntity<List<ClientDto>> getAllClient(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "asc") String direction) {
        Sort.Direction sortDirection;
        if (Objects.equals(direction, "asc")){
            sortDirection = Sort.Direction.ASC;
        } else sortDirection = Sort.Direction.DESC;
        List<ClientDto> clientDto = clientService.findAll(page, size, sort, sortDirection);
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

    @PostMapping("/addRecipe/{id}/{recipeId}")
    public ClientDto addRecipe(@PathVariable("id") Long id, @PathVariable("recipeId") Long recipeId) {
        return clientService.addRecipe(id, recipeId);
    }
}
