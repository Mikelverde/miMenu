package com.example.mimenu.Vistas;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.mimenu.DataBase;
import com.example.mimenu.Metodos.Metodos;
import com.example.mimenu.R;
import com.example.mimenu.Adapters.RecetaArrayAdapter;
import com.example.mimenu.Tablas.Ingrediente;
import com.example.mimenu.Tablas.Plato;
import com.example.mimenu.Tablas.Receta;
import java.util.List;




public class DetallesPlato extends AppCompatActivity {

    private TextView txtnombrePlato,txtTipoPlato, txtOrdenPLato;
    private ImageView icono;
    ListView listViewReceta;
    private DataBase dataBase;
    private Plato plato;
    private List<Ingrediente> ingredientes;
    private List<Receta> receta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_plato);

        txtnombrePlato=findViewById(R.id.txt_nombrePlatoDetalles);
        txtOrdenPLato=findViewById(R.id.txt_ordenPlatoDetalles);
        txtTipoPlato=findViewById(R.id.txt_tipoPlatoDetalles);
        icono=findViewById(R.id.imaV_icono);
        listViewReceta=findViewById(R.id.listV_detalles);

        //iniciamos la BBDD
        dataBase=Metodos.getDataBase(this);

        //Recuperamos la informacion del intent para trabajar con el plato seleccionado  en ListaPlatos.class
        int idPlato = getIntent().getIntExtra("idPlato",0);
        try{
            plato=dataBase.consultas().buscarPlatoXId(idPlato);
            txtnombrePlato.setText(plato.nombrePlato);
            txtTipoPlato.setText("Tipo de plato: "+plato.tipo);
            txtOrdenPLato.setText("Orden: "+plato.orden);

            //todos los ingredientes de la receta
            receta=dataBase.consultas().buscarRecetaXIdPlato(plato.idPlato);

            //iniciamos el arrayadapter para poder cargar el listView con la lista de platos
            RecetaArrayAdapter recetaArrayAdapter=new RecetaArrayAdapter(this,receta);
            listViewReceta.setAdapter(recetaArrayAdapter);

            switch (plato.tipo){
                case "Verdura":
                    icono.setImageResource(R.drawable.vegetables);
                    break;
                case "Legumbre":
                    icono.setImageResource(R.drawable.bean);
                    break;
                case "Pasta":
                    icono.setImageResource(R.drawable.pasta);
                    break;
                case "Arroz-Patatas":
                    icono.setImageResource(R.drawable.rice);
                    break;
                case "Carne":
                    icono.setImageResource(R.drawable.meat);
                    break;
                case "Pescado":
                    icono.setImageResource(R.drawable.fish);
                    break;
                case "Ensalada":
                    icono.setImageResource(R.drawable.ensalada);
                    break;
            }

        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    public void atras(View view){
        Intent i=new Intent(this, ListaPlatos.class);
        startActivity(i);
        }
        public void borrarPlato(View view){
        dataBase.consultas().borrarPlato(plato.idPlato);
        Intent intent=new Intent(this,ListaPlatos.class);
        startActivity(intent);
        }
    }
