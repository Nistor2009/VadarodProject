package com.example.VadarodProject.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ErrorResponse {
    private Integer code;
    private String message;
    private List<String> messages;
}
