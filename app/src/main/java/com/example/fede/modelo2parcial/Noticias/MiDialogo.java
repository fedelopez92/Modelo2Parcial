package com.example.fede.modelo2parcial.Noticias;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

/**
 * Created by Fede on 29/11/2017.
 */

public class MiDialogo extends DialogFragment {

    public ListenerDialogo listenerDialogo;

    @NonNull
    @Override
    public Dialog onCreateDialog (Bundle savedInstanceState){ //hay que sobreescribir este metodo

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //getActivity() toma la activity que genero el dialogo

        builder.setTitle("Atencion");
        builder.setMessage("Usted no tiene los permisos para ver esto");

        //para crear un dialogo con un layout propio:
        //View v = LayoutInflater.from(this).inflate(R.layout.layout);
        //builder.setView(v);

        builder.setPositiveButton("Aceptar", listenerDialogo);//setPositiveButton significa que va a mostrar un boton positivo. Tambien esta el negativo y el neutral

        return builder.create();
    }
}
