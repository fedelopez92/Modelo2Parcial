package com.example.fede.modelo2parcial.Noticias;

import android.content.Intent;
import android.view.View;

import com.example.fede.modelo2parcial.NuevaNoticia.Main3Activity;
import com.example.fede.modelo2parcial.R;

/**
 * Created by Fede on 30/11/2017.
 */

public class MyListener implements View.OnClickListener {

    public Main2Activity main2Activity;

    public MyListener(Main2Activity main2Activity) {
        this.main2Activity = main2Activity;
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnAgregar){
            Intent intent = new Intent(main2Activity, Main3Activity.class);
            main2Activity.startActivity(intent);
        }
    }
}
