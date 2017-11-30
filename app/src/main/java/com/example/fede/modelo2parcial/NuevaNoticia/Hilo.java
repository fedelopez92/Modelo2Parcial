package com.example.fede.modelo2parcial.NuevaNoticia;

import android.net.Uri;
import android.os.Handler;
import android.os.Message;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Fede on 28/11/2017.
 */

public class Hilo implements Runnable {

    Handler handler;
    Message message;
    Modelo modelo;

    public Hilo(Handler handler, Modelo modelo) {
        this.handler = handler;
        this.modelo = modelo;
        this.message = new Message();
    }

    @Override
    public void run() {
        byte[] bytes = getBytesDatabyPOST("http://192.168.1.38:3000/nuevaNoticia");
        message.obj = new String(bytes);//crea un string a traves de un array de bytes
        handler.sendMessage(message);
    }

    public byte[] getBytesDatabyPOST (String strUrl){

        byte[] datos = null;

        Uri.Builder param = new Uri.Builder();
        param.appendQueryParameter("fecha", modelo.getFecha());
        param.appendQueryParameter("tema", modelo.getTema());
        param.appendQueryParameter("titulo", modelo.getTitulo());
        param.appendQueryParameter("noticia", modelo.getNoticia());
        String s = param.build().getEncodedQuery();//convierte el Uri.Builder en una query para enviar al servidor

        try{
            URL url = new URL(strUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setDoOutput(true);//se usa para permitir que pueda usar el OutputStream. Por defecto esta en false
            OutputStream os = urlConnection.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            writer.write(s);
            writer.flush();//Limpia el BufferedWriter
            //Para enviar la información hay que esperar que el BufferedWriter se llene
            //El flush() al limpiar el BufferedWriter va a hacer que se envie la informacion a pesar de que no este lleno
            writer.close();
            os.close();

            int response = urlConnection.getResponseCode();
            InputStream is = urlConnection.getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            if(response == 200){

                byte[] buffer = new byte[1024];
                int length = 0;
                while((length = is.read(buffer)) != -1){
                    baos.write(buffer, 0, length);
                }
                is.close();
                datos = baos.toByteArray();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return datos;
    }
}
