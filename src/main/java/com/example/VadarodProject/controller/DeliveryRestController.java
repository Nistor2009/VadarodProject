package com.example.VadarodProject.controller;

import com.example.VadarodProject.dto.DeliveryDto;
import com.example.VadarodProject.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@RestController
@RequestMapping("/delivery")
public class DeliveryRestController {
    private final DeliveryService deliveryService;

    @GetMapping("/find")
    public ResponseEntity<DeliveryDto> getDeliveryByParam(@RequestParam("id") Long id) {
        DeliveryDto deliveryDto = deliveryService.findById(id);
        return new ResponseEntity<>(deliveryDto, HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<DeliveryDto>> getAllDelivery(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "asc") String direction) {
        Sort.Direction sortDirection;
        if (Objects.equals(direction, "asc")) {
            sortDirection = Sort.Direction.ASC;
        } else sortDirection = Sort.Direction.DESC;
        List<DeliveryDto> deliveryDto = deliveryService.findAll(page, size, sort, sortDirection);
        return new ResponseEntity<>(deliveryDto, HttpStatus.OK);
    }

    @PostMapping("/add")
    public DeliveryDto addDelivery(@RequestBody DeliveryDto deliveryDto) {
        return deliveryService.addDelivery(deliveryDto);
    }

    @PostMapping("/delete")
    public DeliveryDto deleteDelivery(@RequestBody DeliveryDto deliveryDto) {
        return deliveryService.deleteDelivery(deliveryDto);
    }
}
