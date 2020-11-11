package com.example.mimenu.Metodos;

import android.content.Context;
import android.provider.ContactsContract;

import androidx.room.Database;
import androidx.room.Room;

import com.example.mimenu.DataBase;
import com.example.mimenu.Tablas.Ingrediente;
import com.example.mimenu.Tablas.Plato;
import com.example.mimenu.Tablas.Receta;

import java.util.ArrayList;
import java.util.List;

public class Metodos {

    public static DataBase getDataBase(Context context){
        DataBase dataBase = Room.databaseBuilder(context,DataBase.class,"DataBase")
                .allowMainThreadQueries()
                .build();
        return dataBase;
    }

    public static void borrarBBDD(DataBase dataBase){
        dataBase.clearAllTables();
    }

    public static void cargarPlatos(DataBase dataBase){
        ArrayList<Plato> platoArrayList = new ArrayList<>();
        platoArrayList.add(new Plato("Judías verdes","Verdura","Primero"));
        platoArrayList.add(new Plato("Brócoli al ajillo","Verdura","Primero"));
        platoArrayList.add(new Plato("Borraja con longaniza","Verdura","Primero"));
        platoArrayList.add(new Plato("Menestra de verduras","Verdura","Primero"));
        platoArrayList.add(new Plato("Berenjenas Rellenas","Verdura","Primero"));
        platoArrayList.add(new Plato("Acelga rehogada","Verdura","Primero"));
        platoArrayList.add(new Plato("Crema de verduras","Verdura","Primero"));
        platoArrayList.add(new Plato("Ensalada de rulo de cabra","Verdura","Primero"));
        platoArrayList.add(new Plato("Ensalada mixta","Verdura","Primero"));

        platoArrayList.add(new Plato("Lentejas estofadas","Lemgumbre","Primero"));
        platoArrayList.add(new Plato("Alubias blancas","Lemgumbre","Primero"));
        platoArrayList.add(new Plato("Cocido madrileño","Legumbre","Primero"));
        platoArrayList.add(new Plato("Guisantes salteados con jamón","Legumbre","Primero"));

        platoArrayList.add(new Plato("Espaguetis con atún","Pasta","Primero"));
        platoArrayList.add(new Plato("Macarrones boloñesa","Pasta","Primero"));
        platoArrayList.add(new Plato("Espaguetis carbonara","Pasta","Primero"));
        platoArrayList.add(new Plato("Lasaña","Pasta","Primero"));
        platoArrayList.add(new Plato("Sopa de cocido","Pasta","Primero"));
        platoArrayList.add(new Plato("Ensalada de pasta","Pasta","Primero"));

        platoArrayList.add(new Plato("Arroz a la cubana","Arroz-Patatas","Primero"));
        platoArrayList.add(new Plato("Arroz con pollo","Arroz-Patatas","Primero"));
        platoArrayList.add(new Plato("Risotto","Arroz-Patatas","Primero"));
        platoArrayList.add(new Plato("Patatas a la riojana","Arroz-Patatas","Primero"));
        platoArrayList.add(new Plato("Ensalilla Rusa","Arroz-Patatas","Primero"));
        platoArrayList.add(new Plato("Ensalada de Patata","Arroz-Patatas","Primero"));

        platoArrayList.add(new Plato("Filete de ternera a la plancha","Carne","Segundo"));
        platoArrayList.add(new Plato("Catxopo","Carne","Segundo"));
        platoArrayList.add(new Plato("Almóndigas con tomate","Carne","Segundo"));
        platoArrayList.add(new Plato("Hamburguesas","Carne","Segundo"));
        platoArrayList.add(new Plato("Ternera estofada","Carne","Segundo"));
        platoArrayList.add(new Plato("Pechugas de pollo a la plancha","Carne","Segundo"));
        platoArrayList.add(new Plato("Pollo empanado","Carne","Segundo"));
        platoArrayList.add(new Plato("pollo guisado","Carne","Segundo"));
        platoArrayList.add(new Plato("Salchichas","Carne","Segundo"));
        platoArrayList.add(new Plato("Salchichas a la cerveza","Carne","Segundo"));
        platoArrayList.add(new Plato("Chuletillas de pavo","Carne","Segundo"));
        platoArrayList.add(new Plato("Cinta de lomo","Carne","Segundo"));
        platoArrayList.add(new Plato("San Jacobos","Carne","Segundo"));

        platoArrayList.add(new Plato("Merluza a la bilbaina","Pescado","Segundo"));
        platoArrayList.add(new Plato("Merluza a la romana","Pescado","Segundo"));
        platoArrayList.add(new Plato("Lubina a la bilbaina","Pescado","Segundo"));
        platoArrayList.add(new Plato("Salmon a la plancha","Pescado","Segundo"));
        platoArrayList.add(new Plato("Sepia a la plancha","Pescado","Segundo"));

        for (int i = 0; i <platoArrayList.size(); i++) {
            dataBase.consultas().insertPlato(platoArrayList.get(i));
        }
    }

    public static   void cargarIngredientes(DataBase dataBase ){

        ArrayList<Ingrediente> ingredienteArrayList=new ArrayList<>();
        ingredienteArrayList.add(new Ingrediente("g","Judias verdes"));
        ingredienteArrayList.add(new Ingrediente("ud","Ajo"));
        ingredienteArrayList.add(new Ingrediente("ud","Cebolla"));
        ingredienteArrayList.add(new Ingrediente("g","Brocoli"));
        ingredienteArrayList.add(new Ingrediente("g","Jamón"));
        ingredienteArrayList.add(new Ingrediente("g","Borraja"));
        ingredienteArrayList.add(new Ingrediente("g","Menestra"));
        ingredienteArrayList.add(new Ingrediente("ud","Berenjena"));
        ingredienteArrayList.add(new Ingrediente("lata","Atun"));
        ingredienteArrayList.add(new Ingrediente("g","Queso"));
        ingredienteArrayList.add(new Ingrediente("g","Acelga"));
        ingredienteArrayList.add(new Ingrediente("g","Calabacín"));
        ingredienteArrayList.add(new Ingrediente("ud","Patata"));
        ingredienteArrayList.add(new Ingrediente("ud","Zanahoria"));
        ingredienteArrayList.add(new Ingrediente("ud","Lechuga"));
        ingredienteArrayList.add(new Ingrediente("g","Beicon"));
        ingredienteArrayList.add(new Ingrediente("g","Queso de cabra"));
        ingredienteArrayList.add(new Ingrediente("ud","Nueces"));
        ingredienteArrayList.add(new Ingrediente("ud","Tomate"));
        ingredienteArrayList.add(new Ingrediente("ud","Esparragos blancos"));
        ingredienteArrayList.add(new Ingrediente("ud","Huevo"));
        ingredienteArrayList.add(new Ingrediente("g","Lentejas"));
        ingredienteArrayList.add(new Ingrediente("ud","Chorizo"));
        ingredienteArrayList.add(new Ingrediente("ud","Morcilla"));
        ingredienteArrayList.add(new Ingrediente("g","Panceta"));
        ingredienteArrayList.add(new Ingrediente("g","Garbanzos"));
        ingredienteArrayList.add(new Ingrediente("ud","Hueso"));
        ingredienteArrayList.add(new Ingrediente("g","Guisantes"));
        ingredienteArrayList.add(new Ingrediente("g","Epaguetis"));
        ingredienteArrayList.add(new Ingrediente("g","Tomate frito"));
        ingredienteArrayList.add(new Ingrediente("g","Macarrones"));
        ingredienteArrayList.add(new Ingrediente("g","Carne picada"));
        ingredienteArrayList.add(new Ingrediente("g","Placas de lasaña"));
        ingredienteArrayList.add(new Ingrediente("g","Fideos"));
        ingredienteArrayList.add(new Ingrediente("l","Caldo"));
        ingredienteArrayList.add(new Ingrediente("g","Pasta para ensalada"));
        ingredienteArrayList.add(new Ingrediente("ud","Manzana"));
        ingredienteArrayList.add(new Ingrediente("g","Pollo"));
        ingredienteArrayList.add(new Ingrediente("g","Arroz"));
        ingredienteArrayList.add(new Ingrediente("ud","Esparragos trigueros"));
        ingredienteArrayList.add(new Ingrediente("g","Setas"));
        ingredienteArrayList.add(new Ingrediente("ml","Nata"));
        ingredienteArrayList.add(new Ingrediente("g","Mantequilla"));
        ingredienteArrayList.add(new Ingrediente("ud","Pimiento"));
        ingredienteArrayList.add(new Ingrediente("g","Tenera"));
        ingredienteArrayList.add(new Ingrediente("g","Pechugas"));
        ingredienteArrayList.add(new Ingrediente("g","Salchichas"));
        ingredienteArrayList.add(new Ingrediente("g","Pavo"));
        ingredienteArrayList.add(new Ingrediente("g","Cinta de lomo"));
        ingredienteArrayList.add(new Ingrediente("g","Lubina"));
        ingredienteArrayList.add(new Ingrediente("g","Salmon"));
        ingredienteArrayList.add(new Ingrediente("g","Merluza"));
        ingredienteArrayList.add(new Ingrediente("g","Sepia"));
        ingredienteArrayList.add(new Ingrediente("g","Alubias"));

        for (int i = 0; i <ingredienteArrayList.size(); i++) {
            dataBase.consultas().insertIngrediente(ingredienteArrayList.get(i));
        }
    }

    public static void cargarRecetas(DataBase dataBase){
        ArrayList<Receta> recetaArrayList=new ArrayList<>();
        recetaArrayList.add(new Receta(1,1,200));
        recetaArrayList.add(new Receta(1,14,0.5));
        recetaArrayList.add(new Receta(2,2,1));
        recetaArrayList.add(new Receta(2,4,250));
        recetaArrayList.add(new Receta(2,5,50));
        recetaArrayList.add(new Receta(3,2,1));
        recetaArrayList.add(new Receta(3,6,200));
        recetaArrayList.add(new Receta(4,2,1));
        recetaArrayList.add(new Receta(4,3,0.5));
        recetaArrayList.add(new Receta(4,5,50));
        recetaArrayList.add(new Receta(4,8,200));
        recetaArrayList.add(new Receta(5,2,1));
        recetaArrayList.add(new Receta(5,3,0.5));
        recetaArrayList.add(new Receta(5,9,1));
        recetaArrayList.add(new Receta(5,10,2));
        recetaArrayList.add(new Receta(5,11,20));
        recetaArrayList.add(new Receta(5,31,50));
        recetaArrayList.add(new Receta(6,2,1));
        recetaArrayList.add(new Receta(6,5,50));
        recetaArrayList.add(new Receta(6,12,200));
        recetaArrayList.add(new Receta(6,14,0.5));
        recetaArrayList.add(new Receta(7,11,20));
        recetaArrayList.add(new Receta(7,13,0.5));
        recetaArrayList.add(new Receta(7,14,1));
        recetaArrayList.add(new Receta(7,15,1));
        recetaArrayList.add(new Receta(8,16,50));
        recetaArrayList.add(new Receta(8,17,20));
        recetaArrayList.add(new Receta(8,18,50));
        recetaArrayList.add(new Receta(8,19,8));
        recetaArrayList.add(new Receta(9,3,0.2));
        recetaArrayList.add(new Receta(9,10,0.5));
        recetaArrayList.add(new Receta(9,20,0.5));
        recetaArrayList.add(new Receta(9,21,2));
        recetaArrayList.add(new Receta(9,22,0.5));
        recetaArrayList.add(new Receta(9,16,50));
        recetaArrayList.add(new Receta(10,2,1));
        recetaArrayList.add(new Receta(10,5,50));
        recetaArrayList.add(new Receta(10,3,0.3));
        recetaArrayList.add(new Receta(10,23,100));
        recetaArrayList.add(new Receta(10,24,0.5));
        recetaArrayList.add(new Receta(10,25,0.5));
        recetaArrayList.add(new Receta(11,2,1));
        recetaArrayList.add(new Receta(11,3,0.3));
        recetaArrayList.add(new Receta(11,5,50));
        recetaArrayList.add(new Receta(11,24,0.5));
        recetaArrayList.add(new Receta(11,25,0.5));
        recetaArrayList.add(new Receta(12,3,0.2));
        recetaArrayList.add(new Receta(12,5,50));
        recetaArrayList.add(new Receta(12,14,0.5));
        recetaArrayList.add(new Receta(12,15,0.5));
        recetaArrayList.add(new Receta(12,24,0.5));
        recetaArrayList.add(new Receta(12,25,0.5));
        recetaArrayList.add(new Receta(12,26,50));
        recetaArrayList.add(new Receta(12,27,80));
        recetaArrayList.add(new Receta(12,28,1));
        recetaArrayList.add(new Receta(12,29,50));
        recetaArrayList.add(new Receta(12,35,40));
        recetaArrayList.add(new Receta(13,2,1));
        recetaArrayList.add(new Receta(13,5,50));
        recetaArrayList.add(new Receta(13,29,100));

        for (int i = 0; i <recetaArrayList.size(); i++) {
            dataBase.consultas().insertReceta(recetaArrayList.get(i));
        }
    }
}
