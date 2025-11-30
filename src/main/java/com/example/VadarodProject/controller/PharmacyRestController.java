package com.example.VadarodProject.controller;

import com.example.VadarodProject.dto.PharmacyDto;
import com.example.VadarodProject.service.PharmacyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/pharmacy")
public class PharmacyRestController {
    private final PharmacyService pharmacyService;

    @GetMapping("/find")
    public ResponseEntity<PharmacyDto> getPharmacyByParam(@RequestParam("id") Long id) {
        PharmacyDto pharmacyDto = pharmacyService.findById(id);
        return new ResponseEntity<>(pharmacyDto, HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<PharmacyDto>> getAllPharmacy() {
        List<PharmacyDto> pharmacyDto = pharmacyService.findAll();
        return new ResponseEntity<>(pharmacyDto, HttpStatus.OK);
    }

    @PostMapping("/add")
    public PharmacyDto addPharmacy(@RequestBody PharmacyDto pharmacyDto) {
        return pharmacyService.addPharmacy(pharmacyDto);
    }

    @PostMapping("/delete")
    public PharmacyDto deletePharmacy(@RequestBody PharmacyDto pharmacyDto) {
        return pharmacyService.deletePharmacy(pharmacyDto);
    }
}
