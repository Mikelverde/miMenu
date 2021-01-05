package com.example.mimenu.Vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.mimenu.DataBase;
import com.example.mimenu.Adapters.ListaCompraArrayAdapter;
import com.example.mimenu.Metodos.Metodos;
import com.example.mimenu.R;
import com.example.mimenu.Tablas.IngredienteListaCompra;

import java.util.List;

/**
 * Activity sobre la que se presenta la informacion de la lista de la compra asociada al menu semanal
 * @author Mikel
 * @version 30/12/20
 */
public class ListaCompra extends AppCompatActivity {

    DataBase dataBase;
    private List<IngredienteListaCompra> listaCompra ;
    ListView listListaCompra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_compra);

        //iniciamos la bbdd
        dataBase= Metodos.getDataBase(this);

        listListaCompra=findViewById(R.id.list_ListaCompra);
        listaCompra=dataBase.consultas().listaCompra();//todos los ingredientes de los platos del menu

        //iniciamos el arrayadapter para poder cargar el listView con la lista de platos
        ListaCompraArrayAdapter listaCompraArrayAdapter=new ListaCompraArrayAdapter(this, listaCompra);
        listListaCompra.setAdapter(listaCompraArrayAdapter);
    }

}