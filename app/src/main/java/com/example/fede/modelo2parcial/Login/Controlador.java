package com.example.fede.modelo2parcial.Login;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;

import com.example.fede.modelo2parcial.Noticias.Main2Activity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Fede on 28/11/2017.
 */

public class Controlador implements  Handler.Callback {

    public Handler handler;
    public Thread t1;
    public MainActivity mainActivity;
    public Modelo modelo;
    public JSONObject jsonObject;

    public Controlador(MainActivity mainActivity, Modelo modelo) {
        this.mainActivity = mainActivity;
        this.modelo = modelo;
        this.handler = new Handler(this);//Para crear el Handler hay que implementar Callback
        //para pasar datos de un hilo al hilo del MainActivity hay que crear un handler

        this.t1 = new Thread(new Hilo(handler, modelo));
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
