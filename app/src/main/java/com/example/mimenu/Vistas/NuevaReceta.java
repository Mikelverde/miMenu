package com.example.mimenu.Vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mimenu.DataBase;
import com.example.mimenu.Metodos.Metodos;
import com.example.mimenu.R;
import com.example.mimenu.Tablas.Ingrediente;
import com.example.mimenu.Tablas.Plato;

import java.util.ArrayList;
import java.util.List;

public class NuevaReceta extends AppCompatActivity {

    private TextView txtPlato,txtnombreIngrediente,txtUnidades;
    DataBase dataBase;
    private Plato plato;
    private Bundle datosPlato;
    private String nombrePlatoGuardado;
    ArrayList<String> arrayListIngredientes;
    private Spinner spinnerIngredientes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_receta);

        //Cargamos la BBDD con el metodo
        dataBase= Metodos.getDataBase(this);
        //Creamos un plato
        plato=new Plato();
        //Cargamos los elementos de la pantalla con lo que vamos a interactuar
        txtPlato=findViewById(R.id.txt_plato);
        txtnombreIngrediente=findViewById(R.id.txt_nombreIngrediente);
        txtUnidades=findViewById(R.id.txt_unidades);
        spinnerIngredientes=findViewById(R.id.spn_ingredientesReceta);
        //Recuperamos la informacion del intent para trabajar con el plato guardado en nuevoPlato.class
        nombrePlatoGuardado=getIntent().getStringExtra("nombrePlato");
        txtPlato.setText(nombrePlatoGuardado);
        //Los arrayList para cargar en los spiner
        arrayListIngredientes=generarArrayIngredientes();
        //Generamos los adapter para cargar los spinner
        ArrayAdapter<String> adapterIngredientesReceta=new ArrayAdapter(this, android.R.layout.simple_spinner_item,arrayListIngredientes);
        //Cargamos los datos en los spinner
        spinnerIngredientes.setAdapter(adapterIngredientesReceta);

    }
    private ArrayList<String> generarArrayIngredientes(){
        ArrayList<String> stringArrayList=new ArrayList<>();
        Ingrediente ingrediente;
        //cargamos todos los ingredientes de nuestra base de datos en una lista
        List<Ingrediente> ingredienteList = dataBase.consultas().getIngrediente();
        for (int i = 0; i <ingredienteList.size() ; i++) {
            ingrediente=(Ingrediente)ingredienteList.get(i);
            stringArrayList.add(ingrediente.nombreIngrediente);
        }
        return stringArrayList;
    }

    public void insertarIngrediente(View view){
        Ingrediente ingrediente=new Ingrediente();
        try {
            ingrediente.nombreIngrediente=txtnombreIngrediente.getText().toString();
            ingrediente.unidades=txtUnidades.getText().toString();
            long correcto=dataBase.consultas().insertIngrediente(ingrediente);
            if(correcto>0){
                Toast.makeText(this, "INGREDIENTE GUARDADO", Toast.LENGTH_SHORT).show();
                //Los arrayList para cargar en los spiner
                arrayListIngredientes=generarArrayIngredientes();
                //Generamos los adapter para cargar los spinner
                ArrayAdapter<String> adapterIngredientesReceta=new ArrayAdapter(this, android.R.layout.simple_spinner_item,arrayListIngredientes);
                //Cargamos los datos en los spinner
                spinnerIngredientes.setAdapter(adapterIngredientesReceta);
                //borramos los campos
                txtnombreIngrediente.setText("");
                txtUnidades.setText("");
            }else {
                Toast.makeText(this, "HA OCURRIDO UN ERROR", Toast.LENGTH_SHORT).show();
            }
        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }



    }
}