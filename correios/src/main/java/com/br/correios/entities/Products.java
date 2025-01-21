package com.br.correios.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "tracking_products")
@Data
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tracking_products_cd_id")
    private Integer id;

    @NotBlank
    @Size(max = 13)
    @Column(name = "tracking_products_tx_cod")
    private String code;

    @NotBlank
    @Size(max = 120)
    @Column(name = "tracking_products_tx_service")
    private String service;

    @NotNull
    @Min(1)
    @Column(name = "tracking_products_nm_quantity")
    private Integer quantity;

}
