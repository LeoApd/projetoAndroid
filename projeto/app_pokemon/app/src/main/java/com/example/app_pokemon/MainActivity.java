package com.example.app_pokemon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button cadastrar;
    Button listar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cadastrar = findViewById(R.id.cadastrar_id);
        listar = findViewById(R.id.listar_id);
    }


    public void telaCadastro(View view) {
        Intent intent = new Intent(this, Cadastro.class);
        startActivity(intent);
    }

    public void listagem(View view) {
        Intent intent = new Intent(this, Listagem.class);
        startActivity(intent);
    }
}