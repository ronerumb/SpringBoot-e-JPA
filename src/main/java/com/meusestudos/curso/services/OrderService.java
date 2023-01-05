package com.meusestudos.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meusestudos.curso.entities.Order;
import com.meusestudos.curso.repositories.OrderRepository;

@Service
public class OrderService {
	@Autowired // serve para identificar a injeção que será usada em algum momento(não vai precisar do new)
	private OrderRepository userRepository;
	
	public List<Order> findAll(){
		return userRepository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj  = userRepository.findById(id);//find retorna um optional
		return obj.get();
	}

}
