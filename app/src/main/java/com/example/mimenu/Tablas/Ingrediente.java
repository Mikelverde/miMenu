package com.example.mimenu.Tablas;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Ingrediente {
    @PrimaryKey(autoGenerate = true)
    public int idIngrediente;
    public String unidades;
    public String nombreIngrediente;

    public Ingrediente(String unidades, String nombreIngrediente) {
        this.unidades = unidades;
        this.nombreIngrediente = nombreIngrediente;
    }

    public Ingrediente() {

    }
}
