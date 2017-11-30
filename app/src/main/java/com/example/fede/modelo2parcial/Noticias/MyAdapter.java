package com.example.fede.modelo2parcial.Noticias;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fede.modelo2parcial.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fede on 30/11/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    public Controlador controlador;

    public MyAdapter(Controlador controlador) {
        this.controlador = controlador;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlayout, parent, false);
        //inflate convierte un xml de layout en una view

        MyViewHolder myViewHolder = new MyViewHolder(v);
        return myViewHolder;
    }//crea los rectangulos de RecyclerView
     //Solo va a crear la cantidad que entren en pantalla
     //a medida que vamos scrolleando solo se cambia la informacion. Los rectangulos del RecyclerView son siempre los mismos

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) { //carga con informacion el RecyclerView

        Modelo modelo = controlador.modelos.get(position);
        String fecha = modelo.getFecha();
        String tema = modelo.getTema();
        String titulo = modelo.getTitulo();
        String noticia = modelo.getNoticia();

        holder.tvFecha.setText(fecha);
        holder.tvTema.setText(tema);
        holder.tvTitulo.setText(titulo);
        holder.tvNoticia.setText(noticia);
    }

    @Override
    public int getItemCount() {
        return controlador.modelos.size();//si no le ponemos la cantidad de la lista el RecyclerView no muestra nada
    }
}
