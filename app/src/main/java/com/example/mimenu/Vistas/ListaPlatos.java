package com.example.mimenu.Vistas;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.mimenu.DataBase;
import com.example.mimenu.MainActivity;
import com.example.mimenu.Metodos.Metodos;
import com.example.mimenu.Adapters.PlatosArrayAdapter;
import com.example.mimenu.R;
import com.example.mimenu.Tablas.Plato;
import java.util.List;

/**
 * Activity sobre la que se presenta la informacion de la lista de platos disponibles en la BD
 * @author Mikel
 * @version 30/12/20
 */
public class ListaPlatos extends AppCompatActivity {

    DataBase dataBase;
    private List<Plato> platos;
    ListView listViewPlatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_platos);

        //iniciamos la bbdd
        dataBase= Metodos.getDataBase(this);

        listViewPlatos=findViewById(R.id.listV_Ingredientes);
        platos=dataBase.consultas().getPlatos();//todos los platos de la bbdd

        //iniciamos el arrayadapter para poder cargar el listView con la lista de platos
        PlatosArrayAdapter platosArrayAdapter=new PlatosArrayAdapter(this,platos);
        listViewPlatos.setAdapter(platosArrayAdapter);

        //hacemos las listView clicable para poder interaccionar con ella, de modo que al
        //seleccionar un plato pasamos a una nueva actividad donde se presentan los detalles sobre
        //ese plato
        listViewPlatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                int itemSeleccionado=listViewPlatos.getCheckedItemPosition();
                Intent intent=new Intent(getApplicationContext(), DetallesPlato.class);
                int identificador=platos.get(position).idPlato;
                intent.putExtra("idPlato",identificador);
                startActivity(intent);
            }
        });
    }

    /**
     * Metodo que se ejecuta al al pulsar el boton "ResetearBBDD" y que reinicia la bd a su estado inicial
     * @param view
     */
    public void cargarBBDD(View view){
        DataBase dataBase=Metodos.getDataBase(this);
        //borramos la bd
        Metodos.borrarBBDD(dataBase);
        //utilizamos los metodos de la clase metodos para recargar los datos
        Metodos.cargarIngredientes(dataBase);
        Metodos.cargarPlatos(dataBase);
        Metodos.cargarRecetas(dataBase);

        platos=dataBase.consultas().getPlatos();//todos los platos de la bbdd

        //iniciamos el arrayadapter para poder cargar el listView con la lista de platos
        PlatosArrayAdapter platosArrayAdapter=new PlatosArrayAdapter(this,platos);
        listViewPlatos.setAdapter(platosArrayAdapter);
    }

    /**
     * Metodo para volver a la ventana princiapal al pulsar el botos "Volver"
     * @param view
     */
    public void atras3(View view){
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}