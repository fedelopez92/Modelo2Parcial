package com.example.fede.modelo2parcial.NuevaNoticia;

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
    public Main3Activity main3Activity;
    public Modelo modelo;
    public JSONObject jsonObject;

    public Controlador(Main3Activity main3Activity, Modelo modelo) {
        this.main3Activity = main3Activity;
        this.modelo = modelo;
        this.handler = new Handler(this);//Para crear el Handler hay que implementar Callback
        //para pasar datos de un hilo al hilo del MainActivity hay que crear un handler

        this.t1 = new Thread(new Hilo(handler, modelo));
    }

    @Override
    public boolean handleMessage(Message message) {

        try{
            jsonObject = new JSONObject(message.obj.toString());
            Intent intent = new Intent(main3Activity, Main2Activity.class);
            main3Activity.startActivity(intent);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return false;
    }
}
