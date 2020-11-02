package com.example.app_pokemon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.app_pokemon.model.Pokemon;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Listagem extends AppCompatActivity {


    ListView listView = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem);
        listView = findViewById(R.id.listview);
        this.enviarRequisicaoGET();

    }


    private void enviarRequisicaoGET() {
        String url = "http://192.168.100.8:8080/pokemon/getAll";
        RequestQueue queue = Volley.newRequestQueue(this);
        Context context = getApplicationContext();
        int duracao = Toast.LENGTH_LONG;

        JsonArrayRequest request = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        callBack(response);
                    }

                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast toast = Toast.makeText(context,  error.getMessage(), duracao);
                        toast.show();
                    }
                }
        );

        queue.add(request);
    }

    private void callBack(JSONArray response){
        List<Pokemon> pokemons = new ArrayList<>();
        try {
            for (int i = 0; i < response.length(); i++) {
                Pokemon pokemon = new Pokemon();
                pokemon.setId(response.getJSONObject(i).getLong("id"));
                pokemon.setNome(response.getJSONObject(i).getString("nome"));
                pokemon.setAtaque(response.getJSONObject(i).getLong("ataque"));
                pokemon.setDefesa(response.getJSONObject(i).getLong("defesa"));
                pokemons.add(pokemon);
            }

            ArrayAdapter<Pokemon> adapter = new ArrayAdapter<>(
                    this, android.R.layout.simple_list_item_1, pokemons
            );
            listView.setAdapter(adapter);

        }catch (Exception ex){
            Context context = getApplicationContext();
            Toast toast = Toast.makeText(context,  ex.getMessage(), Toast.LENGTH_LONG);
            toast.show();
        }
    }

}