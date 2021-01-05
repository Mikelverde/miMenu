package com.example.mimenu.Vistas;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.example.mimenu.DataBase;
import com.example.mimenu.MainActivity;
import com.example.mimenu.Metodos.Metodos;
import com.example.mimenu.R;
import com.example.mimenu.Tablas.Ingrediente;
import com.example.mimenu.Tablas.Plato;
import com.example.mimenu.Tablas.Receta;
import java.util.ArrayList;
import java.util.List;

/**
 * Activity para rellenar los datos sobre la composicion de un plato nuevo
 * @author Mikel
 * @version 30/12/20
 */
public class NuevaReceta extends AppCompatActivity {

    private TextView txtPlato;
    private EditText txtnombreIngrediente,txtUnidades,txtCantidad;
    DataBase dataBase;
    private Plato plato;
    private Bundle datosPlato;
    private String nombrePlatoGuardado;
    ArrayList<String> arrayListIngredientes;
    private AutoCompleteTextView spinnerIngredientes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_receta);

        //Cargamos la BBDD con el metodo
        dataBase= Metodos.getDataBase(this);
        //Cargamos los elementos de la pantalla con lo que vamos a interactuar
        txtPlato=findViewById(R.id.txt_plato);
        txtnombreIngrediente=findViewById(R.id.txt_nombreIngrediente);
        txtUnidades=findViewById(R.id.txt_unidades);
        spinnerIngredientes=findViewById(R.id.spn_ingredientesReceta);
        txtCantidad=findViewById(R.id.txt_cantidad);
        //Recuperamos la informacion del intent para trabajar con el plato guardado en nuevoPlato.class
        nombrePlatoGuardado=getIntent().getStringExtra("plato");
        try{
            plato=dataBase.consultas().buscarPlatoXNombre(nombrePlatoGuardado);
         }catch (Exception e){
        Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
    }
        txtPlato.setText(plato.nombrePlato);

        //Los arrayList para cargar en los spiner
        arrayListIngredientes=generarArrayIngredientes();
        //Generamos los adapter para cargar los spinner
        ArrayAdapter<String> adapterIngredientesReceta=new ArrayAdapter(this, android.R.layout.simple_spinner_item,arrayListIngredientes);
        //Cargamos los datos en los spinner
        spinnerIngredientes.setAdapter(adapterIngredientesReceta);

    }

    /**
     * Funcion que retorna un arralist con todos los ingredientes existentes en la bd
     * @return arrailist de ingredientes
     */
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

    /**
     *Metodo que inserta en la bd un ingrediente en la tabla iNGREDIENTE al pulsar el boton "Guardar ingrediente"
     * @param view
     */
    public void insertarIngrediente(View view){
        Ingrediente ingrediente=new Ingrediente();
        try {
            if (txtnombreIngrediente.getText().toString().isEmpty() || txtUnidades.getText().toString().isEmpty()){
                Toast.makeText(this, "INTRODUZCA LOS DATOS CORRECTAMENTE", Toast.LENGTH_SHORT).show();
            }else{
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
            }

        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Metodo que iserta en la tabla Receta los ingredientes que componen un plato al pulsar el boton "Nuevo ingrediente"
     * @param view
     */
    public void insertarReceta(View view){
        Receta receta=new Receta();
        try {
            if(spinnerIngredientes.getText().toString().isEmpty()){
                Toast.makeText(this, "INTRODUZCA UN NOMBRE CORRECTO", Toast.LENGTH_SHORT).show();
            }else{
                receta.idPlato=plato.idPlato;
                receta.idIngrediente=dataBase.consultas().buscarIdIngrediente(spinnerIngredientes.getText().toString());
                receta.cantidad=Integer.parseInt(txtCantidad.getText().toString());
                long correcto=dataBase.consultas().insertReceta(receta);
                if(correcto>0){
                    Toast.makeText(this, "INGREDIENTE GUARDADO", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "HA OCURRIDO UN ERROR", Toast.LENGTH_SHORT).show();
                }
            }

        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    /**
     * Metodo para volver a la MainActivity
     * @param view
     */
    public void atras4(View view){
        Intent i=new Intent(this, MainActivity.class);
        startActivity(i);
    }
}