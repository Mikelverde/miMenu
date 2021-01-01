package com.example.mimenu.Tablas;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Clase @Entity Ingrediente, la tabla Ingrediente de la BD
 * @author Mikel
 * @version 30/12/20
 */

@Entity
public class Ingrediente {
    //region Campos
    @PrimaryKey(autoGenerate = true)
    public int idIngrediente;
    public String unidades;
    public String nombreIngrediente;
    //endregion

    //region Constructores
    public Ingrediente(String unidades, String nombreIngrediente) {
        this.unidades = unidades;
        this.nombreIngrediente = nombreIngrediente;
    }

    public Ingrediente() {
    }

    public Ingrediente(int idIngrediente, String unidades, String nombreIngrediente) {
        this.idIngrediente = idIngrediente;
        this.unidades = unidades;
        this.nombreIngrediente = nombreIngrediente;
    }
    //endregion
}
