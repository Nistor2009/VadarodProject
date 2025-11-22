package com.example.VadarodProject.service;

import com.example.VadarodProject.entity.Cure;
import com.example.VadarodProject.repository.CureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CureService {
    private final CureRepository cureRepository;

    public Cure addCure(Cure cure) {
        return cureRepository.save(cure);
    }

    public void deleteCure(Cure cure){
        cureRepository.delete(cure);
    }

    public Cure findById(Long id){
        Optional<Cure> cure =  cureRepository.findById(id);
        return cure.orElse(new Cure());
    }

    public Page<Cure> findAll(Integer page, Integer size){
        return cureRepository.findAll(PageRequest.of(page, size));
    }


}
