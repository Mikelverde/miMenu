package com.example.mimenu.Tablas;

import androidx.room.Entity;

@Entity(primaryKeys = {"idPlato","idIngrediente"})
public class Receta {
    public int idPlato;
    public int idIngrediente;
    public double cantidad;

    public Receta(int idPlato, int idIngrediente, double cantidad) {
        this.idPlato = idPlato;
        this.idIngrediente = idIngrediente;
        this.cantidad = cantidad;
    }

    public Receta() {

    }
}
