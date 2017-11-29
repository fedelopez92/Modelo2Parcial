package com.example.fede.modelo2parcial.Login;

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
            modelo.setEmail(vista.email.getText().toString());
            modelo.setPassword(vista.password.getText().toString());
            controlador.t1.start();
        }
    }
}
