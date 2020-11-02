package com.pokemon.domain.service;

import java.util.List;

import com.pokemon.domain.models.Pokemon;

public interface PokemonService {
    Pokemon save (Pokemon pokemon) throws Exception;
    Pokemon getById (Long id) throws Exception;
    List<Pokemon> getAll() throws Exception;
    void delete (Long id) throws Exception;
    Pokemon update (Pokemon pokemon) throws Exception;
}
