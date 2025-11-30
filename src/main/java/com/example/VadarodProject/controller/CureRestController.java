package com.example.VadarodProject.controller;

import com.example.VadarodProject.dto.CureDto;
import com.example.VadarodProject.service.CureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cure")
public class CureRestController {
    private final CureService cureService;

    @GetMapping("/find")
    public ResponseEntity<CureDto> getCureByParam(@RequestParam("id") Long id) {
        CureDto cureDto = cureService.findById(id);
        return new ResponseEntity<>(cureDto, HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<CureDto>> getAllCure() {
        List<CureDto> cureDto = cureService.findAll();
        return new ResponseEntity<>(cureDto, HttpStatus.OK);
    }

    @PostMapping("/add")
    public CureDto addCure(@RequestBody CureDto cureDto) {
        return cureService.addCure(cureDto);
    }

    @PostMapping("/delete")
    public CureDto deleteCure(@RequestBody CureDto cureDto) {
        return cureService.deleteCure(cureDto);
    }
}
