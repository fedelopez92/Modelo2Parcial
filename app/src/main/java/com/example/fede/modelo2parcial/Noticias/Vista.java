package com.example.fede.modelo2parcial.Noticias;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.fede.modelo2parcial.R;

/**
 * Created by Fede on 30/11/2017.
 */

public class Vista {

    public Button btnAgregar;
    public RecyclerView recyclerView;
    public RecyclerView.LayoutManager layoutManager;

    public Vista(Main2Activity main2Activity){
        this.btnAgregar = (Button) main2Activity.findViewById(R.id.btnAgregar);
        this.recyclerView = (RecyclerView) main2Activity.findViewById(R.id.recyclerView);
        this.layoutManager = new GridLayoutManager(main2Activity, 2);//2 es el numero de columnas que va a tener

        this.recyclerView.setLayoutManager(layoutManager);
    }

    public void setearListener(View.OnClickListener myListener){
        this.btnAgregar.setOnClickListener(myListener);
    }

    public void setearAdapter(RecyclerView.Adapter adapter){
        this.recyclerView.setAdapter(adapter);
    }
}
