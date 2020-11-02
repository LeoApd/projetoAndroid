package com.pokemon.domain.pokemonImpl;

import java.util.List;
import java.util.Optional;

import com.pokemon.domain.models.Pokemon;
import com.pokemon.domain.repository.PokemonRepository;
import com.pokemon.domain.service.PokemonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokemonServiceImpl implements PokemonService {

    @Autowired private PokemonRepository pokemonRepository;

    @Override
    public Pokemon save(Pokemon pokemon) throws Exception {
        return this.pokemonRepository.save(pokemon);
    }

    @Override
    public Pokemon getById(Long id) throws Exception {
        Optional<Pokemon> pokemon = this.pokemonRepository.findById(id);
        if(!pokemon.isPresent())
            throw new Exception("Pokemon não encontado");
        return pokemon.get();
    }

    @Override
    public List<Pokemon> getAll() throws Exception {
        return this.pokemonRepository.findAll();
    }

    @Override
    public void delete(Long id) throws Exception {
        this.pokemonRepository.deleteById(id);
    }

    @Override
    public Pokemon update(Pokemon pokemon) throws Exception {
       return this.pokemonRepository.save(pokemon);
    }
    
}
