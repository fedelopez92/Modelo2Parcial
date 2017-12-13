package com.example.fede.modelo2parcial.Login;

import android.content.Context;
import android.content.SharedPreferences;
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

        SharedPreferences sharedPreferences = getSharedPreferences("datosLogin", Context.MODE_PRIVATE);
        modelo = new Modelo();
        controlador = new Controlador(this, modelo, sharedPreferences);
        vista = new Vista(this);
        MyListener myListener = new MyListener(modelo, vista, controlador);
        vista.setearListener(myListener);

        String email = sharedPreferences.getString("email", "default email");
        String password = sharedPreferences.getString("password", "default password");

        if(email != "default email" && password != "default password"){
            modelo.setEmail(email);
            modelo.setPassword(password);
            controlador.t1.start();
        }
    }

    @Override
    protected void onStop(){
        super.onStop();
        controlador.t1.interrupt();//ponemos interrupt() en el metodo onStop() para que cierre el hilo cuando cerremos la aplicacion
    }
}
