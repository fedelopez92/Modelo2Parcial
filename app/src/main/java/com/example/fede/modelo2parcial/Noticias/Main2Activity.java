package com.example.fede.modelo2parcial.Noticias;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.fede.modelo2parcial.R;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Modelo modelo = new Modelo();
        Vista vista = new Vista(this);
        Controlador controlador = new Controlador(this);
        MyListener myListener = new MyListener(this);
        MyAdapter myAdapter = new MyAdapter(controlador);

        vista.setearListener(myListener);
        vista.setearAdapter(myAdapter);
        //myAdapter.notifyDataSetChanged();
        //al agregar mas personas por ejemplo a traves de un metodo no se va a mostrar en el RecyclerView
        //con notifyDataSetChanged() se avisa al RecyclerView que cambio la informacion para que agregue en este caso a las personas

        controlador.t1.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){ //en en este metodo se crea el menu
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){ //en este metodo se pone lo que debe hacer cada opcion
        switch (item.getItemId()){
            case R.id.salir:
                finish();
                break;

            case R.id.nuevo:
                Intent intent = getIntent();//trae los datos del intent (No se pueden pasar objetos, solo datos primitivos)

                if(intent.getStringExtra("tipo").equals("User")){
                    MiDialogo miDialogo = new MiDialogo();
                    miDialogo.show(getSupportFragmentManager(), "dialogo");
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
