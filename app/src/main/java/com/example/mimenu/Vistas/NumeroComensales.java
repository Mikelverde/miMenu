package com.example.mimenu.Vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;

import com.example.mimenu.R;

/**
 * Activity para indicar el numero de comensales para elaborar la lista de la compra
 * @author Mikel
 * @version 30/12/20
 */
public class NumeroComensales extends AppCompatActivity {

    public EditText txt_comensales;
    public int comensales;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numero_comensales);

        txt_comensales=findViewById(R.id.txt_numeroComensales);

    }

    /**
     * Metodo para leer el numero de comensales al pulsar el boton
     * @param view
     */
    public void numeroComensales(View view){
        try {
            comensales=Integer.parseInt(txt_comensales.getText().toString());
            SharedPreferences preferences= PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor myEditor = preferences.edit();
            myEditor.putInt("comensales",comensales);
            myEditor.commit();
            Intent intent=new Intent(this,ListaCompra.class);
            startActivity(intent);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

    }
}