package com.example.mimenu;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.mimenu.Dao.Consultas;
import com.example.mimenu.Tablas.Ingrediente;
import com.example.mimenu.Tablas.Plato;
import com.example.mimenu.Tablas.Receta;

@Database(entities = {Plato.class, Ingrediente.class, Receta.class},version = 1)
public abstract class DataBase extends RoomDatabase {
    public abstract Consultas consultas();
}
