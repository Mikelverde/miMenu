package com.example.mimenu.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.mimenu.Tablas.Ingrediente;
import com.example.mimenu.Tablas.IngredienteListaCompra;
import com.example.mimenu.Tablas.Menu;
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
    List<Plato> getPlatos();
    @Query("SELECT * FROM Ingrediente")
    List<Ingrediente> getIngrediente();
    @Insert
    long insertReceta(Receta receta);
    @Query("SELECT * FROM Receta WHERE idPlato=:plato")
    List<Receta> buscarRecetaXIdPlato(int plato);
    @Query("SELECT idIngrediente FROM Ingrediente WHERE nombreIngrediente LIKE :nombreIngrediente")
    int buscarIdIngrediente(String nombreIngrediente);
    @Query("SELECT * FROM Plato WHERE nombrePlato LIKE :nombrePlato")
    Plato buscarPlatoXNombre(String nombrePlato);
    @Query("DELETE FROM Plato ")
    void borrarTablaPlato();
    @Query("DELETE FROM Ingrediente ")
    void borrarTablaIngrediente();
    @Query("DELETE FROM Receta ")
    void borrarTablaReceta();
    @Query("SELECT * FROM Plato WHERE idPlato = :idPlato")
    Plato buscarPlatoXId(int idPlato);
    @Query("SELECT * FROM Ingrediente WHERE idIngrediente=:idIngrediente")
    Ingrediente buscarIngredienteXId(int idIngrediente);
    @Query("SELECT * FROM Plato WHERE tipo LIKE :tipo")
    List<Plato> buscarPlatoXTipo(String tipo);
    @Query("SELECT * FROM Plato WHERE orden LIKE :orden")
    List<Plato> buscarPlatoXOrden(String orden);
    @Insert
    long insertMenu(Menu plato);
    @Query("SELECT * FROM Menu")
    List<Menu> listarMenu();
    @Delete
    void borrarPlatoMenu(List<Menu> menuList);

    @Query("SELECT nombreIngrediente, SUM(cantidad) as cantidad,MAX(unidades) as unidades FROM Menu INNER JOIN Receta ON menu.idPlato=Receta.idPlato INNER JOIN Ingrediente ON Receta.idIngrediente=Ingrediente.idIngrediente GROUP BY nombreIngrediente")
    List<IngredienteListaCompra> listaCompra();



}
