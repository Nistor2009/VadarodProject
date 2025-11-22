package com.example.VadarodProject.service;

import com.example.VadarodProject.entity.Cure;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TableService {
    private final CureService cureService;

    private void fillCure(){
        Cure cure = new Cure();
        cure.setId(null);
        cure.setName("Валидол");
        cure.setNeedRecipe(false);
        cureService.addCure(cure);
        Cure cure2 = new Cure();
        cure.setId(null);
        cure.setName("Аспирин");
        cure.setNeedRecipe(false);
        cureService.addCure(cure2);
    }
    public void fillTable(){
        fillCure();
    }

}
