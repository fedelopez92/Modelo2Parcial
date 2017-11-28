package com.example.fede.modelo2parcial.Login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.fede.modelo2parcial.R;

public class MainActivity extends AppCompatActivity {

    Modelo modelo;
    Controlador controlador;
    Vista vista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        modelo = new Modelo();
        controlador = new Controlador(this, modelo);
        vista = new Vista(this);

    }

    @Override
    protected void onStop(){
        super.onStop();
        controlador.t1.interrupt();//ponemos interrupt() en el metodo onStop() para que cierre el hilo cuando cerremos la aplicacion
    }
}
