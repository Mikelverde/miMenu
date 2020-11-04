package com.example.mimenu.Metodos;

import android.content.Context;

import androidx.room.Room;

import com.example.mimenu.DataBase;

public class Metodos {

    public static DataBase getDataBase(Context context){
        DataBase dataBase = Room.databaseBuilder(context,DataBase.class,"DataBase")
                .allowMainThreadQueries()
                .build();
        return dataBase;
    }
}
