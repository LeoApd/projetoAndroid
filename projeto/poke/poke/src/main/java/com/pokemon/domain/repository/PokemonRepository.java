package com.pokemon.domain.repository;

import com.pokemon.domain.models.Pokemon;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long>{
    
}
