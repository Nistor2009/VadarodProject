package com.example.VadarodProject.dto;

import com.example.VadarodProject.entity.Recipe;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ClientRequest {
    private Long id;
    private String name;
    private String surname;
    private int age;
    private String phone;
    private List<Recipe> recipe;
}
