package com.br.correios.dtos;

import lombok.Data;

@Data
public class EventsRequestDTO {

    private String city;
    private String uf;
    private String status;

}
