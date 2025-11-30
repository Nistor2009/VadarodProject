package com.example.VadarodProject.controller;

import com.example.VadarodProject.dto.PriceDto;
import com.example.VadarodProject.service.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/price")
public class PriceRestController {
    private final PriceService priceService;

    @GetMapping("/find")
    public ResponseEntity<PriceDto> getPriceByParam(@RequestParam("id") Long id) {
        PriceDto priceDto = priceService.findById(id);
        return new ResponseEntity<>(priceDto, HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<PriceDto>> getAllPrice() {
        List<PriceDto> priceDto = priceService.findAll();
        return new ResponseEntity<>(priceDto, HttpStatus.OK);
    }

    @PostMapping("/add")
    public PriceDto addPrice(@RequestBody PriceDto priceDto) {
        return priceService.addPrice(priceDto);
    }

    @PostMapping("/delete")
    public PriceDto deletePrice(@RequestBody PriceDto priceDto) {
        return priceService.deletePrice(priceDto);
    }
}
