package com.meusestudos.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meusestudos.curso.entities.Product;
import com.meusestudos.curso.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired // serve para identificar a injeção que será usada em algum momento(não vai precisar do new)
	private ProductRepository productRepository;
	
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj  = productRepository.findById(id);//find retorna um optional
		return obj.get();
	}

}
