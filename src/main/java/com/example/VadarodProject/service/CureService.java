package com.example.VadarodProject.service;

import com.example.VadarodProject.dto.CureDto;
import com.example.VadarodProject.entity.Cure;
import com.example.VadarodProject.mapper.CureMapper;
import com.example.VadarodProject.repository.CureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CureService {
    private final CureRepository cureRepository;
    private final CureMapper cureMapper;

    public CureDto addCure(CureDto cure) {
        return cureMapper.toDto(cureRepository.save(cureMapper.toEntity(cure)));
    }

    public CureDto deleteCure(CureDto cure) {
        cureRepository.delete(cureMapper.toEntity(cure));
        return cure;
    }

    public CureDto findById(Long id) {
        Optional<Cure> cure = cureRepository.findById(id);
        return cureMapper.toDto(cure.orElse(new Cure()));
    }

    public List<CureDto> findAll(
        int page,
        int size,
        String sort,
        Sort.Direction sortDirection){
            Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, sort));
            Page<Cure> pageClient = cureRepository.findAll(pageable);
            return cureMapper.toCureDtoList(pageClient.get().toList());
    }
}
