package com.br.correios.dtos;

import lombok.Data;

@Data
public class ProductsRequestDTO {
    private String service;
    private Integer quantity;
}
