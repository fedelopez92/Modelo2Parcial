package com.example.fede.modelo2parcial.NuevaNoticia;

import android.view.View;

import com.example.fede.modelo2parcial.R;

/**
 * Created by Fede on 29/11/2017.
 */

public class MyListener implements View.OnClickListener {

    public Modelo modelo;
    public Vista vista;
    public Controlador controlador;

    public MyListener(Modelo modelo, Vista vista, Controlador controlador) {
        this.modelo = modelo;
        this.vista = vista;
        this.controlador = controlador;
    }


    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.btnIngresar){
            modelo.setFecha(vista.fecha.getText().toString());
            modelo.setTema(vista.tema.getText().toString());
            modelo.setTitulo(vista.titulo.getText().toString());
            modelo.setNoticia(vista.noticia.getText().toString());
            controlador.t1.start();
        }
    }
}
