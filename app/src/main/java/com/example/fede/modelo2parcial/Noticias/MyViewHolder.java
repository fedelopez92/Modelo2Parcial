package com.example.fede.modelo2parcial.Noticias;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.fede.modelo2parcial.R;

/**
 * Created by Fede on 30/11/2017.
 */

public class MyViewHolder extends RecyclerView.ViewHolder {

    public TextView tvFecha;
    public TextView tvTema;
    public TextView tvTitulo;
    public TextView tvNoticia;

    public MyViewHolder(View itemView) {
        super(itemView);

        tvFecha = (TextView) itemView.findViewById(R.id.fecha);
        tvTema = (TextView) itemView.findViewById(R.id.tema);
        tvTitulo = (TextView) itemView.findViewById(R.id.titulo);
        tvNoticia = (TextView) itemView.findViewById(R.id.noticia);
    }
}
