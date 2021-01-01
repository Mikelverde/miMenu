package com.example.mimenu.Tablas;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Clase @Entity Menu, la tabla Menu de la BD
 * @author Mikel
 * @version 30/12/20
 */
@Entity
public class Menu {

    //region Campos
    @PrimaryKey(autoGenerate = true)
    public int orden;
    public int idPlato;
    //endregion

    //Contructor
    public Menu(int idPlato) {
        this.idPlato = idPlato;
    }
}
