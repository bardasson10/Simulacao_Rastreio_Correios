package com.br.correios.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "tracking_events")
@Data
public class Events {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "tracking_events_cd_id")
        private Integer id;

        @NotNull
        @Column(name = "tracking_events_dt_date")
        private Date date;

        @NotNull
        @Column(name = "tracking_events_hr_time")
        private LocalTime time;

        @NotBlank
        @Size(max = 80)
        @Column(name = "tracking_events_tx_city")
        private String city;

        @NotBlank
        @Size(max = 2)
        @Column(name = "tracking_events_tx_uf")
        private String uf;

        @NotBlank
        @Size(max = 120)
        @Column(name = "tracking_events_tx_status")
        private String status;

        @ManyToOne
        @JoinColumn(name="fk_tracking_products")
        private Products fkProducts;

}
