package com.example.fede.modelo2parcial.NuevaNoticia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.fede.modelo2parcial.R;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Modelo modelo = new Modelo();
        Vista vista = new Vista(this);
        Controlador controlador = new Controlador(this, modelo);
        MyListener myListener = new MyListener(modelo, vista, controlador);

        vista.setearListener(myListener);
    }
}
