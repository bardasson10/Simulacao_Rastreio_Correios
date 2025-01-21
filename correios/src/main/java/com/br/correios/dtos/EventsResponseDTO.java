package com.br.correios.dtos;

import lombok.Data;

import java.time.LocalTime;
import java.util.Date;

@Data
public class EventsResponseDTO {
    private Date date;
    private LocalTime time;
    private String city;
    private String uf;
    private String status;

}
