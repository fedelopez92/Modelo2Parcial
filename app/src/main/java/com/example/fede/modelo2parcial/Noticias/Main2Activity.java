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

        Modelo modelo = new Modelo();
        Vista vista = new Vista(this);
        Controlador controlador = new Controlador(this);
        MyAdapter myAdapter = new MyAdapter(controlador);

        vista.setearAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
        //al agregar mas personas por ejemplo a traves de un metodo no se va a mostrar en el RecyclerView
        //con notifyDataSetChanged() se avisa al RecyclerView que cambio la informacion para que agregue en este caso a las personas

        controlador.t1.start();
    }
}
