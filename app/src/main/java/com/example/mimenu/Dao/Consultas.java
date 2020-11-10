package com.example.mimenu.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.mimenu.Tablas.Ingrediente;
import com.example.mimenu.Tablas.Plato;
import com.example.mimenu.Tablas.Receta;

import java.util.List;

@Dao
public interface Consultas {
    @Insert
    long insertPlato(Plato plato);
    @Insert
    long insertIngrediente(Ingrediente ingrediente);
    @Query("SELECT * FROM Plato")
    List<Plato> getPlato();
    @Query("SELECT * FROM Ingrediente")
    List<Ingrediente> getIngrediente();
    @Insert
    long insertReceta(Receta receta);
    @Query("SELECT * FROM Receta WHERE idPlato=:plato")
    List<Receta> getReceta(int plato);
    @Query("SELECT idIngrediente FROM Ingrediente WHERE nombreIngrediente LIKE :nombreIngrediente")
    int buscarIdIngrediente(String nombreIngrediente);
    @Query("SELECT * FROM Plato WHERE nombrePlato LIKE :nombrePlato")
    Plato buscarPlato(String nombrePlato);
    @Query("DELETE FROM Plato ")
    void borrarTablaPlato();
    @Query("DELETE FROM Ingrediente ")
    void borrarTablaIngrediente();
    @Query("DELETE FROM Receta ")
    void borrarTablaReceta();
}
