package com.example.VadarodProject.dto;

import com.example.VadarodProject.entity.Recipe;
import lombok.Data;

import java.util.List;

@Data
public class ClientDto {
    private Long id;
    private String name;
    private String surname;
    private int age;
    private String phone;
    private List<Recipe> recipe;
}
