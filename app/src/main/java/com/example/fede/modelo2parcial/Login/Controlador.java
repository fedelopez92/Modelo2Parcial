package com.example.fede.modelo2parcial.Login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;

import com.example.fede.modelo2parcial.Hilo;
import com.example.fede.modelo2parcial.Noticias.Main2Activity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Fede on 28/11/2017.
 */

public class Controlador implements  Handler.Callback {

    public MainActivity mainActivity;
    public Modelo modelo;
    SharedPreferences sharedPreferences;
    public Handler handler;
    public Thread t1;
    public JSONObject jsonObject;

    public Controlador(MainActivity mainActivity, Modelo modelo, SharedPreferences sharedPreferences) {
        this.mainActivity = mainActivity;
        this.modelo = modelo;
        this.sharedPreferences = sharedPreferences;
        this.handler = new Handler(this);//Para crear el Handler hay que implementar Callback
        //para pasar datos de un hilo al hilo del MainActivity hay que crear un handler

        this.t1 = new Thread(new Hilo(handler, modelo), "hilo 1");
    }

    @Override
    public boolean handleMessage(Message message) {

        try{
            jsonObject = new JSONObject(message.obj.toString());
            Ingresar();

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return false;
    }

    public void Ingresar(){

        try {

            if(jsonObject.getString("type").equals("User") || jsonObject.getString("type").equals("Admin")){

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("email", modelo.getEmail());
                editor.putString("password", modelo.getPassword());
                editor.commit();

                Intent intent = new Intent(mainActivity, Main2Activity.class);
                intent.putExtra("tipo", jsonObject.getString("type"));//le paso valor a la otra activity
                mainActivity.startActivity(intent);
            }

            if(jsonObject.getString("type").equals("error")){

                MiDialogo miDialogo = new MiDialogo();
                miDialogo.show(mainActivity.getSupportFragmentManager(), "dialogo");
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
