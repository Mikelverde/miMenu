package com.example.mimenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mimenu.Metodos.Metodos;
import com.example.mimenu.Vistas.ListaPlatos;
import com.example.mimenu.Vistas.MenuSemanal;
import com.example.mimenu.Vistas.NuevoPlato;
import com.example.mimenu.Vistas.NumeroComensales;

/**
 * Clase MainActivity contiene la actividad principal
 * @author Mikel
 * @version 30/12/20
 */

public class MainActivity extends AppCompatActivity {

    private DataBase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataBase=Metodos.getDataBase(this);
        if(dataBase.consultas().getPlatos().size()==0){
            Metodos.cargarIngredientes(dataBase);
            Metodos.cargarPlatos(dataBase);
            Metodos.cargarRecetas(dataBase);
        }


    }

    /**
     * Metodo para navegar de una actividad a otra segun el boton pulsado
     * @param view
     */
    public void PantallaInicio(View view){
        Intent i;
        switch (view.getId()){
            case R.id.btn_NuevoPlato:
                i=new Intent(this, NuevoPlato.class);
                startActivity(i);
                break;
            case R.id.btn_listaPlatos:
                i=new Intent(this, ListaPlatos.class);
                startActivity(i);
                break;
            case R.id.btn_menu:
                i=new Intent(this, MenuSemanal.class);
                startActivity(i);
                break;
            case R.id.btn_listaCompra:

                i=new Intent(this, NumeroComensales.class);
                startActivity(i);
                break;
        }
    }


}
