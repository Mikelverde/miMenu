package com.example.mimenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mimenu.Metodos.Metodos;
import com.example.mimenu.Vistas.ListaPlatos;
import com.example.mimenu.Vistas.NuevoPlato;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

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
        }
    }

    public void cargarBBDD(View view){
      DataBase dataBase=Metodos.getDataBase(this);
        Metodos.borrarBBDD(dataBase);
        Metodos.cargarIngredientes(dataBase);
        Metodos.cargarPlatos(dataBase);
        Metodos.cargarRecetas(dataBase);
    }
}