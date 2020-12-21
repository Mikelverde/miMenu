package com.example.mimenu.Adapters;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
    import android.widget.TextView;

import com.example.mimenu.Metodos.Metodos;
import com.example.mimenu.R;
import com.example.mimenu.Tablas.IngredienteListaCompra;
import com.example.mimenu.Vistas.NumeroComensales;

import java.util.List;

    public class ListaCompraArrayAdapter extends ArrayAdapter<IngredienteListaCompra> {

        private int comensales;

    public ListaCompraArrayAdapter(Context context, List<IngredienteListaCompra> listaCompra) {
            super(context, 0,listaCompra);
            }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
            // Obtener inflater.
            LayoutInflater inflater = (LayoutInflater) getContext()
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            // ¿Existe el view actual?
            if (null == convertView) {
            convertView = inflater.inflate(
            R.layout.item_ingrediente,
            parent,
            false);
            }

            // Referencias UI.
            TextView ingredienteMenu =convertView.findViewById(R.id.txt_ItemNombreIngrediente);

            // Lead actual.
            IngredienteListaCompra ingrediente = getItem(position);

            //obtener el numero de comensales almacenado en la sharedPreferences
        SharedPreferences preferences= PreferenceManager.getDefaultSharedPreferences(ingredienteMenu.getContext());
        comensales=preferences.getInt("comensales",1);



        //necesito los datos del plato y del ingrediente
        ingredienteMenu.setText(ingrediente.nombreIngrediente+" "+(int)(ingrediente.cantidad*comensales)+" "+ingrediente.unidades);
        return convertView;
            }
            }