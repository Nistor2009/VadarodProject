package com.example.VadarodProject.controller;

import com.example.VadarodProject.dto.PriceDto;
import com.example.VadarodProject.service.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

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
    public ResponseEntity<List<PriceDto>> getAllPrice(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "asc") String direction) {
        Sort.Direction sortDirection;
        if (Objects.equals(direction, "asc")) {
            sortDirection = Sort.Direction.ASC;
        } else sortDirection = Sort.Direction.DESC;
        List<PriceDto> priceDto = priceService.findAll(page, size, sort, sortDirection);
        return new ResponseEntity<>(priceDto, HttpStatus.OK);
    }

    @PostMapping("/add")
    public PriceDto addPrice(@RequestBody @Validated PriceDto priceDto) {
        return priceService.addPrice(priceDto);
    }

    @PostMapping("/delete")
    public PriceDto deletePrice(@RequestBody PriceDto priceDto) {
        return priceService.deletePrice(priceDto);
    }
}
