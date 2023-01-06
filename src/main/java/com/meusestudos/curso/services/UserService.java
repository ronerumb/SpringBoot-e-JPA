package com.meusestudos.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meusestudos.curso.entities.User;
import com.meusestudos.curso.repositories.UserRepository;

@Service
public class UserService {
	@Autowired // serve para identificar a injeção que será usada em algum momento(não vai precisar do new)
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj  = userRepository.findById(id);//find retorna um optional
		return obj.get();
	}
	
	public User insert(User obj) {
		return userRepository.save(obj);
	}
	
	public void delete(Long id) {
		userRepository.deleteById(id);
	}

}
