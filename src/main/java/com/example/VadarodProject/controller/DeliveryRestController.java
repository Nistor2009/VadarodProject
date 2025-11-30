package com.example.VadarodProject.controller;

import com.example.VadarodProject.dto.DeliveryDto;
import com.example.VadarodProject.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<List<DeliveryDto>> getAllDelivery() {
        List<DeliveryDto> deliveryDto = deliveryService.findAll();
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
