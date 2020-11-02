package com.pokemon.controller;

import java.util.Date;

import com.pokemon.domain.models.Pokemon;
import com.pokemon.domain.repository.PokemonRepository;
import com.pokemon.domain.service.PokemonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pokemon")
@CrossOrigin(origins = {"*"})
public class PokemonController {
    
    @Autowired private PokemonService pokemonService;
    @Autowired private PokemonRepository pr;

    @PostMapping("/save")
    public ResponseEntity<Object> save(@RequestBody Pokemon pokemon){
        try{
            return new ResponseEntity<>(
                this.pokemonService.save(pokemon),
                HttpStatus.OK
            );
        }catch(Exception ex){
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestBody Pokemon pokemon){
        try{
            return new ResponseEntity<>(
                this.pokemonService.update(pokemon),
                HttpStatus.OK
            );
        }catch(Exception ex){
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getById")
    public ResponseEntity<Object> getById(@RequestParam(value = "id", required = true) Long id){
        try{
            return new ResponseEntity<>(
                this.pokemonService.getById(id),
                HttpStatus.OK
            );
        }catch(Exception ex){
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<Object> getAll(){
        try{
            return new ResponseEntity<>(
                this.pokemonService.getAll(),
                HttpStatus.OK
            );
        }catch(Exception ex){
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/delete")
    public ResponseEntity<Object> delete(@RequestParam(value = "id", required = true) Long id){
        try{
            this.pokemonService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception ex){
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/getTest")
    public ResponseEntity<Object> getTest() {
        String teste = "TESTE API - " + new Date();
        return new ResponseEntity<>(teste, HttpStatus.OK);
    }
    
    

}
