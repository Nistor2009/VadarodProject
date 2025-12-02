package com.example.VadarodProject.controller;

import com.example.VadarodProject.dto.DeliveryManDto;
import com.example.VadarodProject.service.DeliveryManService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<List<DeliveryManDto>> getAllDeliveryMan() {
        List<DeliveryManDto> deliveryManDto = deliveryManService.findAll();
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
