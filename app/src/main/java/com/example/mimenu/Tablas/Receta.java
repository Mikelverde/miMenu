package com.example.mimenu.Tablas;

import androidx.room.Entity;

/**
 * Clase @Entity Receta, la tabla Receta de la BD
 * Tabla que permite asociar una lista de ingredientes que forman la receta de un plato
 * @author Mikel
 * @version 30/12/20
 */
@Entity(primaryKeys = {"idPlato","idIngrediente"})
public class Receta {
    //region Campos
    public int idPlato;
    public int idIngrediente;
    public double cantidad;
    //endregion


    //region Constructores
    public Receta(int idPlato, int idIngrediente, double cantidad) {
        this.idPlato = idPlato;
        this.idIngrediente = idIngrediente;
        this.cantidad = cantidad;
    }

    public Receta() {

    }
    //endregion

}
