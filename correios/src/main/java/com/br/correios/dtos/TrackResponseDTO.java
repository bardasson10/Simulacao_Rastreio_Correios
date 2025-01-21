package com.br.correios.dtos;

import lombok.Data;

import java.util.List;

@Data
public class TrackResponseDTO {
    private String code;
    private String service;
    private Integer quantity;
    private List<EventsResponseDTO> events;
}
