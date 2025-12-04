package com.example.VadarodProject.controller;

import com.example.VadarodProject.dto.DeliveryManDto;
import com.example.VadarodProject.service.DeliveryManService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@RestController
@RequestMapping("/deliveryMan")
public class DeliveryManRestController {
    private final DeliveryManService deliveryManService;

    @GetMapping("/find")
    public ResponseEntity<DeliveryManDto> getDeliveryManByParam(@RequestParam("id") Long id) {
        DeliveryManDto deliveryManDto = deliveryManService.findById(id);
        return new ResponseEntity<>(deliveryManDto, HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<DeliveryManDto>> getAllDeliveryMan(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "asc") String direction) {
        Sort.Direction sortDirection;
        if (Objects.equals(direction, "asc")) {
            sortDirection = Sort.Direction.ASC;
        } else sortDirection = Sort.Direction.DESC;
        List<DeliveryManDto> deliveryManDto = deliveryManService.findAll(page, size, sort, sortDirection);
        return new ResponseEntity<>(deliveryManDto, HttpStatus.OK);
    }

    @PostMapping("/add")
    public DeliveryManDto addDeliveryMan(@RequestBody DeliveryManDto deliveryManDto) {
        return deliveryManService.addDeliveryMan(deliveryManDto);
    }

    @PostMapping("/delete")
    public DeliveryManDto deleteDeliveryMan(@RequestBody DeliveryManDto deliveryManDto) {
        return deliveryManService.deleteDeliveryMan(deliveryManDto);
    }
}
