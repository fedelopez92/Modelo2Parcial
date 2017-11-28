package com.example.fede.modelo2parcial.Login;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Fede on 28/11/2017.
 */

public class Controlador implements  Handler.Callback {

    public Handler handler;
    public Thread t1;
    public Activity activity;
    public Modelo modelo;
    public JSONObject jsonObject;

    public Controlador(Activity activity, Modelo modelo) {
        this.activity = activity;
        this.modelo = modelo;
        this.t1 = new Thread(new Hilo(handler, modelo));
        this.handler = new Handler(this);//Para crear el Handler hay que implementar Callback
        //para pasar datos de un hilo al hilo del MainActivity hay que crear un handler
    }

    @Override
    public boolean handleMessage(Message message) {

        try{
            jsonObject = new JSONObject(message.obj.toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return false;
    }

    public void Ingresar(){

        if(jsonObject.getString("type").equals("User")){


        }

        if(jsonObject.getString("type").equals("Admin")){


        }

        if(jsonObject.getString("type").equals("error")){


        }

    }
}
