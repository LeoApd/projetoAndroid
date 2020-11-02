package com.pokemon.domain.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "POKEMON")
public class Pokemon {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private Long ataque;

    private Long defesa;

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getAtaque() {
        return ataque;
    }
    
    public void setAtaque(Long ataque) {
        this.ataque = ataque;
    }

    public Long getDefesa() {
        return defesa;
    }

    public void setDefesa(Long defesa) {
        this.defesa = defesa;
    }
}
