package com.example.mimenu.Vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mimenu.DataBase;
import com.example.mimenu.Metodos.Metodos;
import com.example.mimenu.R;
import com.example.mimenu.Tablas.Plato;

import java.util.ArrayList;

public class NuevoPlato extends AppCompatActivity {

    DataBase dataBase;
    private ArrayList<String> arrayListTipo,arrayListOrden;
    private Spinner spinnerTipo, spinnerOrden;
    private EditText nombrePlato;
    private Plato plato;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_plato);

        //Cargamos la BBDD con el metodo
        dataBase= Metodos.getDataBase(this);
        //Creamos un plato
        plato=new Plato();
        //Cargamos los elementos de la pantalla con lo que vamos a interactuar
        spinnerOrden=findViewById(R.id.spn_ordenPlato);
        spinnerTipo=findViewById(R.id.spn_tipoPlato);
        nombrePlato=findViewById(R.id.txt_nombrePlato);

        //Los arrayList para cargar en los spiner
        arrayListOrden=new ArrayList<>();
        arrayListOrden.add("Primero");
        arrayListOrden.add("Segundo");
        arrayListTipo=new ArrayList<>();
        arrayListTipo.add("Verdura");
        arrayListTipo.add("Legumbre");
        arrayListTipo.add("Pasta");
        arrayListTipo.add("Arroz-Patata");
        arrayListTipo.add("Carne");
        arrayListTipo.add("Pescado");
        //Generamos los adapter para cargar los spinner
        ArrayAdapter<String> adapterTipo=new ArrayAdapter(this, android.R.layout.simple_spinner_item,arrayListTipo);
        ArrayAdapter<String> adapterOrden=new ArrayAdapter(this, android.R.layout.simple_spinner_item,arrayListOrden);
        //Cargamos los datos en los spinner
        spinnerTipo.setAdapter(adapterTipo);
        spinnerOrden.setAdapter(adapterOrden);
    }

    public void insertarPlato(View view){
        Intent i=new Intent(this, NuevaReceta.class);
        try {
            //Cargamos los datos recogidos de la pantalla en el plato
            plato.nombrePlato=nombrePlato.getText().toString();
            plato.orden=spinnerOrden.getSelectedItem().toString();
            plato.tipo=spinnerTipo.getSelectedItem().toString();
            //cargamos el plato en la bbdd, si funciona correcto >0
            long correcto=dataBase.consultas().insertPlato(plato);
            if(correcto>0){
                Toast.makeText(this, "PLATO GUARDADO", Toast.LENGTH_SHORT).show();
                //si todo ha salido bien cambiamos de pantalla y pasamos la idPlato a la siguiente pantalla
                i.putExtra("plato",plato.nombrePlato);
                startActivity(i);
            }else {
                Toast.makeText(this, "HA OCURRIDO UN ERROR", Toast.LENGTH_SHORT).show();
            }
        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();

        }
    }
}