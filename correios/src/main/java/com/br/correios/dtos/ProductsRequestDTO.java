package com.br.correios.dtos;

import lombok.Data;

@Data
public class ProductsRequestDTO {
    private String category;
    private String Service;
    private Integer quantity;
}
