package com.example.practicanoguiada.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.practicanoguiada.model.Compras;


@EnableJpaRepositories
public interface ComprasRepo extends JpaRepository<Compras,Long>{

}
