package com.example.fede.modelo2parcial.Login;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.fede.modelo2parcial.R;

/**
 * Created by Fede on 28/11/2017.
 */

public class Vista {

    public EditText email;
    public EditText password;
    public Button btnIngresar;

    public Vista(Activity activity){
        this.email = (EditText) activity.findViewById(R.id.email);
        this.password = (EditText) activity.findViewById(R.id.password);
        this.btnIngresar = (Button) activity.findViewById(R.id.btnIngresar);
    }

    public void setearListener(View.OnClickListener myListener){
        this.btnIngresar.setOnClickListener(myListener);
    }
}
