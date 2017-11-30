package com.example.fede.modelo2parcial.Noticias;

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
 * Created by Fede on 30/11/2017.
 */

public class Hilo implements Runnable {

    Handler handler;
    Message message;

    public Hilo(Handler handler){
        this.handler = handler;
        this.message = new Message();
    }

    @Override
    public void run() {

        byte[] bytes = getBytesDataByGET("http://192.168.1.38:3000/noticias");
        message.obj = new String(bytes);
        handler.sendMessage(message);
    }

    public byte[] getBytesDataByGET (String strUrl){

        byte[] datos = null;

        try {
            URL url = new URL(strUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            int response = urlConnection.getResponseCode();
            InputStream is = urlConnection.getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            //el ByteArrayOutputStream es donde va a guardar la informacion que me trae el servidor

            if(response == 200){
                byte[] buffer = new byte[1024];
                int length = 0;
                while((length = is.read(buffer)) != -1){ //es != a -1 porque el metodo read() retorna -1 si termino de leer los bytes
                    //el metodo read lee los bytes del InputStream y los almacena en este caso en buffer

                    baos.write(buffer, 0, length);
                    //si por ejemplo tratamos de leer 1025 bytes va a leer primero los 1024 bytes
                    //y al leer el byte restante va a pasar ademas 1023 bytes de basura (porque el dato primitivo va a pasar siempre 1024 bytes)
                    //por lo tanto en el metodo write() ademas de buffer se va a pasar la cantidad que tiene que leer (0, length)
                }
                is.close();
                datos = baos.toByteArray();
            }


        } catch (IOException e){
            //se pone IOException porque va a capturar todas las excepciones que puede tirar la conexion
            e.printStackTrace();
        }
        return datos;
    }
}
