package com.example.mimenu.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.mimenu.R;
import com.example.mimenu.Tablas.Plato;
import java.util.List;

/**
 * Clase Adapter, puente entre los datos, platos contenidos en la BD, y una listView
 * @author Mikel
 * @version 30/12/20
 */
public class PlatosArrayAdapter extends ArrayAdapter<Plato> {

    //Constructor
    public PlatosArrayAdapter(Context context, List<Plato> listPlatos) {
        super(context, 0,listPlatos);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Obtener inflater.
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //¿Existe el view actual?
        if (null == convertView) {
            convertView = inflater.inflate(
                    R.layout.item_plato,
                    parent,
                    false);
        }

        TextView nombrePlato =convertView.findViewById(R.id.txt_ItemNombrePlato);
        Plato plato = getItem(position);
        nombrePlato.setText(plato.nombrePlato);
        return convertView;
    }
}

