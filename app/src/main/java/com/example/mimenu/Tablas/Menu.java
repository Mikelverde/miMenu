package com.example.mimenu.Tablas;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Menu {

    @PrimaryKey(autoGenerate = true)
    public int orden;
    public int idPlato;

    public Menu(int idPlato) {
        this.idPlato = idPlato;
    }
}
