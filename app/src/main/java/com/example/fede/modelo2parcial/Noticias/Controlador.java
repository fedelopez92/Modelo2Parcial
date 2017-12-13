package com.example.fede.modelo2parcial.Noticias;

import android.os.Handler;
import android.os.Message;

import com.example.fede.modelo2parcial.Hilo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fede on 30/11/2017.
 */

public class Controlador implements Handler.Callback{

    public Main2Activity main2Activity;
    public Handler handler;
    public Thread t1;
    public JSONArray jsonArray;
    public List<Modelo> modelos;

    public Controlador(Main2Activity main2Activity){
        this.main2Activity = main2Activity;
        this.handler = new Handler(this);
        this.t1 = new Thread(new Hilo(handler), "hilo 2");
        this.modelos = new ArrayList<Modelo>();
    }

    @Override
    public boolean handleMessage(Message message) {

        try {
            jsonArray = new JSONArray(message.obj.toString());

            for(int i=0; i<jsonArray.length(); i++){

                JSONObject jsonObject = jsonArray.getJSONObject(i);

                Modelo modelo = new Modelo();
                modelo.setFecha(jsonObject.getString("fecha"));
                modelo.setTema(jsonObject.getString("tema"));
                modelo.setTitulo(jsonObject.getString("titulo"));
                modelo.setNoticia(jsonObject.getString("noticia"));

                this.modelos.add(modelo);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return false;
    }
}
