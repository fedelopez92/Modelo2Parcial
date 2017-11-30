package com.example.fede.modelo2parcial.NuevaNoticia;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.fede.modelo2parcial.R;

/**
 * Created by Fede on 28/11/2017.
 */

public class Vista {

    public EditText fecha;
    public EditText tema;
    public EditText titulo;
    public EditText noticia;
    public Button btnIngresar;

    public Vista(Activity activity){
        this.fecha = (EditText) activity.findViewById(R.id.fecha);
        this.tema = (EditText) activity.findViewById(R.id.tema);
        this.titulo = (EditText) activity.findViewById(R.id.titulo);
        this.noticia = (EditText) activity.findViewById(R.id.noticia);
        this.btnIngresar = (Button) activity.findViewById(R.id.btnIngresar);
    }

    public void setearListener(View.OnClickListener myListener){
        this.btnIngresar.setOnClickListener(myListener);
    }
}
