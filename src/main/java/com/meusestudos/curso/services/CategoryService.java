package com.meusestudos.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meusestudos.curso.entities.Category;
import com.meusestudos.curso.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired // serve para identificar a injeção que será usada em algum momento(não vai
				// precisar do new)
	private CategoryRepository userRepository;

	public List<Category> findAll() {
		return userRepository.findAll();
	}

	public Category findById(Long id) {
		Optional<Category> obj = userRepository.findById(id);// find retorna um optional
		return obj.get();
	}

}
