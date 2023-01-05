package com.meusestudos.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meusestudos.curso.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
