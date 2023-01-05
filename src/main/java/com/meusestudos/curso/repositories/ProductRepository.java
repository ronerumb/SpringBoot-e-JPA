package com.meusestudos.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meusestudos.curso.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
