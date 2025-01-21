package com.br.correios.services;

import com.br.correios.dtos.EventsRequestDTO;
import com.br.correios.dtos.EventsResponseDTO;
import com.br.correios.dtos.ProductsRequestDTO;
import com.br.correios.dtos.TrackResponseDTO;
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
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TrackingService {

    @Autowired
    EventsRepository eventsRepository;

    @Autowired
    ProductsRepository productsRepository;

    public Products saveProduct(ProductsRequestDTO productsRequestDTO) {
        Products product = new Products();
        String code = UUID.randomUUID().toString().replaceAll("[^A-Za-z]", "").substring(0, 2).toUpperCase() + UUID.randomUUID().toString().replaceAll("[^0-9]", "").substring(0, 9).toUpperCase()+"BR";

        product.setCode(code);
        product.setService(productsRequestDTO.getService());
        product.setQuantity(productsRequestDTO.getQuantity());

        return productsRepository.save(product);
    }

    public Events saveEvent(EventsRequestDTO eventsRequestDTO, String productCode) {
        Events event = new Events();

        Date date = new Date();
        LocalTime time = LocalTime.now(ZoneId.of("America/Sao_Paulo"));

        Products products = productsRepository.findByCode(productCode)
            .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        event.setDate(date);
        event.setTime(time);
        event.setCity(eventsRequestDTO.getCity());
        event.setUf(eventsRequestDTO.getUf());
        event.setStatus(eventsRequestDTO.getStatus());
        event.setFkProducts(products);


        return eventsRepository.save(event);
    }

    public TrackResponseDTO  getAllEvents(String productCode) {
        Optional<Products> products = productsRepository.findByCode(productCode);

        if(products.isEmpty()) {
            throw new RuntimeException("Produto não encontrado");
        }

        Products product = products.get();
        List<Events> events = eventsRepository.findByfkProducts(product);

        List<EventsResponseDTO> eventDTO = events.stream().map(event -> {
            EventsResponseDTO dto = new EventsResponseDTO();
            dto.setCity(event.getCity());
            dto.setDate(event.getDate());
            dto.setStatus(event.getStatus());
            dto.setTime(event.getTime());
            dto.setUf(event.getUf());
            return dto;
        }).collect(Collectors.toList());

        TrackResponseDTO trackResponseDTO = new TrackResponseDTO();
        trackResponseDTO.setCode(product.getCode());
        trackResponseDTO.setService(product.getService());
        trackResponseDTO.setQuantity(product.getQuantity());
        trackResponseDTO.setEvents(eventDTO);

        return trackResponseDTO;
    }
}
