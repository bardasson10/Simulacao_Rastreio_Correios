package com.br.correios.services;

import com.br.correios.entities.Events;
import com.br.correios.entities.Products;
import com.br.correios.repositories.EventsRepository;
import com.br.correios.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service
public class TrackingService {

    @Autowired
    EventsRepository eventsRepository;

    @Autowired
    ProductsRepository productsRepository;

    public Products saveProduct(Products product) {
        return productsRepository.save(product);
    }

    public Events saveEvent(Events event) {



        return eventsRepository.save(event);
    }
}
