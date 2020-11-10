package com.example.mimenu.Tablas;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Plato {
    @PrimaryKey(autoGenerate = true)
    public int idPlato;
    public String nombrePlato;
    public String tipo;
    public String orden;

    public Plato(String nombrePlato, String tipo, String orden) {
        this.nombrePlato = nombrePlato;
        this.tipo = tipo;
        this.orden = orden;
    }

    public Plato() {

    }

    public Plato(int idPlato, String nombrePlato, String tipo, String orden) {
        this.idPlato = idPlato;
        this.nombrePlato = nombrePlato;
        this.tipo = tipo;
        this.orden = orden;
    }
}
