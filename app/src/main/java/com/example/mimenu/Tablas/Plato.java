package com.example.mimenu.Tablas;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Plato {
    @PrimaryKey(autoGenerate = true)
    public int idPlato;
    public String nombrePlato;
    public String tipo;
    public int orden;
}
