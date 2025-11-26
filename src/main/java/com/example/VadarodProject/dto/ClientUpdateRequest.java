package com.example.VadarodProject.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ClientUpdateRequest extends ClientCreateRequest{

    private Long id;
}
