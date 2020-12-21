package com.example.mimenu.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.mimenu.DataBase;
import com.example.mimenu.Metodos.Metodos;
import com.example.mimenu.R;
import com.example.mimenu.Tablas.Ingrediente;
import com.example.mimenu.Tablas.Plato;
import com.example.mimenu.Tablas.Receta;

import java.util.List;

public class RecetaArrayAdapter extends ArrayAdapter<Receta> {

    public RecetaArrayAdapter(@NonNull Context context, List<Receta> recetaList) {
        super(context, 0, recetaList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtener inflater.
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // ¿Existe el view actual?
        if (null == convertView) {
            convertView = inflater.inflate(
                    R.layout.item_receta,
                    parent,
                    false);
        }

        // Referencias UI.
        TextView nombreIngrediente = convertView.findViewById(R.id.txt_ItemReceta);

        // Lead actual.
        Receta receta = getItem(position);

        // Setup.

        //necesito los datos del plato y del ingrediente
        DataBase dataBase= Metodos.getDataBase(getContext());
        Plato plato=dataBase.consultas().buscarPlatoXId(receta.idPlato);
        Ingrediente ingrediente=dataBase.consultas().buscarIngredienteXId(receta.idIngrediente);
        nombreIngrediente.setText(ingrediente.nombreIngrediente+ ": "+receta.cantidad+" ("+ingrediente.unidades+")");
        return convertView;
    }
}