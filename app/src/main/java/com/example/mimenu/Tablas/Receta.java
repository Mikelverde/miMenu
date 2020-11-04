package com.example.mimenu.Tablas;

import androidx.room.Entity;

@Entity(primaryKeys = {"idPlato","idIngrediente"})
public class Receta {
    public int idPlato;
    public int idIngrediente;
    public int cantidad;
}
