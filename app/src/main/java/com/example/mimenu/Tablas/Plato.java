package com.example.mimenu.Tablas;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Clase @Entity Plato, la tabla Plato de la BD
 * @author Mikel
 * @version 30/12/20
 */
@Entity
public class Plato {
    //region Campos
    @PrimaryKey(autoGenerate = true)
    public int idPlato;
    public String nombrePlato;
    public String tipo;
    public String orden;
    //endregion

    //region Constructores
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
    //endregion
}
