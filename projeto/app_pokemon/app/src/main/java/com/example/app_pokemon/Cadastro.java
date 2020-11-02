package com.example.app_pokemon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Cadastro extends AppCompatActivity {

    EditText nome = null;
    EditText ataque = null;
    EditText defesa = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro3);

        nome = findViewById(R.id.nome);
        defesa = findViewById(R.id.defesa);
        ataque = findViewById(R.id.ataque);

    }

    public void cadastrar(View view) {
        if(this.validarCamposNumber()){
            try{
                JSONObject pokemon = this.montarJsonObject();

                this.enviarRequisicaoPOST(pokemon);

            }catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private void enviarRequisicaoPOST(JSONObject pokemon) {
        String url = "http://192.168.100.8:8080/pokemon/save";
        RequestQueue queue = Volley.newRequestQueue(this);
        Context context = getApplicationContext();
        int duracao = Toast.LENGTH_LONG;

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.POST,
                url,
                pokemon,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String message = "Card do pokemom " + response.getString("nome") + " cadastrado!";
                            Toast toast = Toast.makeText(context,  message, duracao);
                            toast.show();
                        } catch (JSONException e) {
                            Toast toast = Toast.makeText(context,  e.getMessage(), duracao);
                            toast.show();
                        }
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

    private JSONObject montarJsonObject() throws JSONException {

        JSONObject obj = new JSONObject();
        obj.put("id", null);
        obj.put("nome", String.valueOf(this.nome.getText()));
        obj.put("ataque", Long.valueOf(String.valueOf(this.ataque.getText())));
        obj.put("defesa", Long.valueOf(String.valueOf(this.ataque.getText())));

        return obj;

    }

    private boolean validarCamposNumber() {
        final String REGEX = "[0-9]+";
        String ataqueS = String.valueOf(ataque.getText());
        String defesaS = String.valueOf(defesa.getText());

        boolean ataqueNumber = ataqueS.matches(REGEX);
        boolean defesaNumber = defesaS.matches(REGEX);

        Context context = getApplicationContext();

        if(!ataqueNumber){
            Toast toast = Toast.makeText(context, "O campo ataque aceita apenas números", Toast.LENGTH_LONG);
            toast.show();
            return false;
        }

        if(!defesaNumber){
            Toast toast = Toast.makeText(context, "O campo defesa aceita apenas números", Toast.LENGTH_LONG);
            toast.show();
            return false;
        }

        return true;

    }


}