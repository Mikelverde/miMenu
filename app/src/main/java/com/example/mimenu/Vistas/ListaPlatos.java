package com.example.mimenu.Vistas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.mimenu.DataBase;
import com.example.mimenu.PlatosArrayAdapter;
import com.example.mimenu.R;
import com.example.mimenu.Tablas.Plato;

import java.util.List;


public class ListaPlatos extends AppCompatActivity {

    DataBase dataBase;
    private List<Plato> platos;
    ListView listViewPlatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_platos);
        //iniciamos la bbdd
        dataBase= Room.databaseBuilder(getApplicationContext(),DataBase.class,"DataBase")
                .allowMainThreadQueries()
                .build();

        listViewPlatos=findViewById(R.id.listV_Ingredientes);
        platos=dataBase.consultas().getPlato();//todos los platos de la bbdd

        //iniciamos el arrayadapter para poder cargar el listView con la lista de platos
        PlatosArrayAdapter platosArrayAdapter=new PlatosArrayAdapter(this,platos);
        listViewPlatos.setAdapter(platosArrayAdapter);

        listViewPlatos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                int itemSeleccionado=listViewPlatos.getCheckedItemPosition();
                Intent intent=new Intent(getApplicationContext(), DetallesPlato.class);
                intent.putExtra("idPlato",position+1);
                startActivity(intent);
                return false;
            }
        });
    }


}