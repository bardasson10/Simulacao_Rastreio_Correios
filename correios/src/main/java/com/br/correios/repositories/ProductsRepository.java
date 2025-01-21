package com.br.correios.repositories;

import com.br.correios.entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Integer> {

    Optional<Products> findByCode(String productCode);
}
