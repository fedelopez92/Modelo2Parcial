package com.example.fede.modelo2parcial.Noticias;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.fede.modelo2parcial.R;

import org.json.JSONObject;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();//trae los datos del intent (No se pueden pasar objetos, solo datos primitivos)
        String valor = intent.getStringExtra("tipo");
        Log.d("texto", valor);
    }
}
