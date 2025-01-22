package com.br.correios.controllers;

import com.br.correios.dtos.EventsRequestDTO;
import com.br.correios.dtos.ProductsRequestDTO;
import com.br.correios.dtos.TrackResponseDTO;
import com.br.correios.entities.Events;
import com.br.correios.entities.Products;
import com.br.correios.services.TrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/simulation")
public class TrackingController {

    @Autowired
    TrackingService trackingService;

    @PostMapping("/products")
    public ResponseEntity<Products> saveProduct(@RequestBody ProductsRequestDTO productsRequestDTO) {
        Products products = trackingService.saveProduct(productsRequestDTO );
        return ResponseEntity.ok().body(products);
    }

    @PostMapping("/events")
    public ResponseEntity<Events> saveProduct(@RequestBody EventsRequestDTO eventsRequestDTO, @RequestParam String productCode) {
        Events events = trackingService.saveEvent(eventsRequestDTO, productCode);
        return ResponseEntity.status(201).body(events);
    }

    @GetMapping("/tracking")
    public ResponseEntity<TrackResponseDTO>getTracking(@RequestParam String productCode) {
        return ResponseEntity.status(200).body(trackingService.getAllEvents(productCode));
    }
}
