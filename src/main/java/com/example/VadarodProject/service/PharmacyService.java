package com.example.VadarodProject.service;

import com.example.VadarodProject.dto.PharmacyDto;
import com.example.VadarodProject.entity.Pharmacy;
import com.example.VadarodProject.mapper.PharmacyMapper;
import com.example.VadarodProject.repository.PharmacyRepository;
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
public class PharmacyService {
    private final PharmacyRepository pharmacyRepository;
    private final PharmacyMapper pharmacyMapper;

    public PharmacyDto addPharmacy(PharmacyDto pharmacy) {
        return pharmacyMapper.toDto(pharmacyRepository.save(pharmacyMapper.toEntity(pharmacy)));
    }

    public PharmacyDto deletePharmacy(PharmacyDto pharmacy) {
        pharmacyRepository.delete(pharmacyMapper.toEntity(pharmacy));
        return pharmacy;
    }

    public PharmacyDto findById(Long id) {
        Optional<Pharmacy> pharmacy = pharmacyRepository.findById(id);
        return pharmacyMapper.toDto(pharmacy.orElse(new Pharmacy()));
    }

    public List<PharmacyDto> findAll(int page,
                                     int size,
                                     String sort,
                                     Sort.Direction sortDirection) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, sort));
        Page<Pharmacy> pageClient = pharmacyRepository.findAll(pageable);
        return pharmacyMapper.toPharmacyDtoList(pageClient.get().toList());
    }
}
