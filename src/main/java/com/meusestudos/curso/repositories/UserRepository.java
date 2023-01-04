package com.meusestudos.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meusestudos.curso.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
