package com.example.mimenu.Metodos;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.view.View;

import androidx.room.Database;
import androidx.room.Room;

import com.example.mimenu.DataBase;
import com.example.mimenu.MainActivity;
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
        platoArrayList.add(new Plato(1,"Judías verdes","Verdura","Primero"));
        platoArrayList.add(new Plato(2,"Brócoli al ajillo","Verdura","Primero"));
        platoArrayList.add(new Plato(3,"Borraja con longaniza","Verdura","Primero"));
        platoArrayList.add(new Plato(4,"Menestra de verduras","Verdura","Primero"));
        platoArrayList.add(new Plato(5,"Berenjenas Rellenas","Verdura","Primero"));
        platoArrayList.add(new Plato(6,"Acelga rehogada","Verdura","Primero"));
        platoArrayList.add(new Plato(7,"Crema de verduras","Verdura","Primero"));
        platoArrayList.add(new Plato(8,"Ensalada de rulo de cabra","Ensalada","Primero"));
        platoArrayList.add(new Plato(9,"Ensalada mixta","Ensalada","Primero"));

        platoArrayList.add(new Plato(10,"Lentejas estofadas","Legumbre","Primero"));
        platoArrayList.add(new Plato(11,"Alubias blancas","Legumbre","Primero"));
        platoArrayList.add(new Plato(12,"Cocido madrileño","Legumbre","Primero"));
        platoArrayList.add(new Plato(13,"Guisantes salteados con jamón","Legumbre","Primero"));

        platoArrayList.add(new Plato(14,"Espaguetis con atún","Pasta","Primero"));
        platoArrayList.add(new Plato(15,"Macarrones boloñesa","Pasta","Primero"));
        platoArrayList.add(new Plato(16,"Espaguetis carbonara","Pasta","Primero"));
        platoArrayList.add(new Plato(17,"Lasaña","Pasta","Primero"));
        platoArrayList.add(new Plato(18,"Sopa de cocido","Pasta","Primero"));
        platoArrayList.add(new Plato(19,"Ensalada de pasta","Ensalada","Primero"));

        platoArrayList.add(new Plato(20,"Arroz a la cubana","Arroz-Patatas","Primero"));
        platoArrayList.add(new Plato(21,"Arroz con pollo","Arroz-Patatas","Primero"));
        platoArrayList.add(new Plato(22,"Risotto","Arroz-Patatas","Primero"));
        platoArrayList.add(new Plato(23,"Patatas a la riojana","Arroz-Patatas","Primero"));
        platoArrayList.add(new Plato(24,"Ensalilla Rusa","Ensalada","Primero"));
        platoArrayList.add(new Plato(25,"Ensalada de Patata","Ensalada","Primero"));

        platoArrayList.add(new Plato(26,"Filete de ternera a la plancha","Carne","Segundo"));
        platoArrayList.add(new Plato(27,"Catxopo","Carne","Segundo"));
        platoArrayList.add(new Plato(28,"Almóndigas con tomate","Carne","Segundo"));
        platoArrayList.add(new Plato(29,"Hamburguesas","Carne","Segundo"));
        platoArrayList.add(new Plato(30,"Ternera estofada","Carne","Segundo"));
        platoArrayList.add(new Plato(31,"Pechugas de pollo a la plancha","Carne","Segundo"));
        platoArrayList.add(new Plato(32,"Pollo empanado","Carne","Segundo"));
        platoArrayList.add(new Plato(33,"pollo guisado","Carne","Segundo"));
        platoArrayList.add(new Plato(34,"Salchichas","Carne","Segundo"));
        platoArrayList.add(new Plato(35,"Salchichas a la cerveza","Carne","Segundo"));
        platoArrayList.add(new Plato(36,"Chuletillas de pavo","Carne","Segundo"));
        platoArrayList.add(new Plato(37,"Cinta de lomo","Carne","Segundo"));
        platoArrayList.add(new Plato(38,"San Jacobos","Carne","Segundo"));

        platoArrayList.add(new Plato(39,"Merluza a la bilbaina","Pescado","Segundo"));
        platoArrayList.add(new Plato(40,"Merluza a la romana","Pescado","Segundo"));
        platoArrayList.add(new Plato(41,"Lubina a la bilbaina","Pescado","Segundo"));
        platoArrayList.add(new Plato(42,"Salmon a la plancha","Pescado","Segundo"));
        platoArrayList.add(new Plato(43,"Sepia a la plancha","Pescado","Segundo"));

        for (int i = 0; i <platoArrayList.size(); i++) {
            dataBase.consultas().insertPlato(platoArrayList.get(i));
        }
    }

    public static   void cargarIngredientes(DataBase dataBase ){

        ArrayList<Ingrediente> ingredienteArrayList=new ArrayList<>();
        ingredienteArrayList.add(new Ingrediente(1,"g","Judias verdes"));
        ingredienteArrayList.add(new Ingrediente(2,"ud","Ajo"));
        ingredienteArrayList.add(new Ingrediente(3,"ud","Cebolla"));
        ingredienteArrayList.add(new Ingrediente(4,"g","Brocoli"));
        ingredienteArrayList.add(new Ingrediente(5,"g","Jamón"));
        ingredienteArrayList.add(new Ingrediente(6,"g","Borraja"));
        ingredienteArrayList.add(new Ingrediente(7,"g","Longaniza"));
        ingredienteArrayList.add(new Ingrediente(8,"g","Menestra"));
        ingredienteArrayList.add(new Ingrediente(9,"ud","Berenjena"));
        ingredienteArrayList.add(new Ingrediente(10,"lata","Atun"));
        ingredienteArrayList.add(new Ingrediente(11,"g","Queso"));
        ingredienteArrayList.add(new Ingrediente(12,"g","Acelga"));
        ingredienteArrayList.add(new Ingrediente(13,"g","Calabacín"));
        ingredienteArrayList.add(new Ingrediente(14,"ud","Patata"));
        ingredienteArrayList.add(new Ingrediente(15,"ud","Zanahoria"));
        ingredienteArrayList.add(new Ingrediente(16,"g","Lechuga"));
        ingredienteArrayList.add(new Ingrediente(17,"g","Beicon"));
        ingredienteArrayList.add(new Ingrediente(18,"g","Queso de cabra"));
        ingredienteArrayList.add(new Ingrediente(19,"ud","Nueces"));
        ingredienteArrayList.add(new Ingrediente(20,"ud","Tomate"));
        ingredienteArrayList.add(new Ingrediente(21,"ud","Esparragos blancos"));
        ingredienteArrayList.add(new Ingrediente(22,"ud","Huevo"));
        ingredienteArrayList.add(new Ingrediente(23,"g","Lentejas"));
        ingredienteArrayList.add(new Ingrediente(24,"ud","Chorizo"));
        ingredienteArrayList.add(new Ingrediente(25,"ud","Morcilla"));
        ingredienteArrayList.add(new Ingrediente(26,"g","Panceta"));
        ingredienteArrayList.add(new Ingrediente(27,"g","Garbanzos"));
        ingredienteArrayList.add(new Ingrediente(28,"ud","Hueso"));
        ingredienteArrayList.add(new Ingrediente(29,"g","Guisantes"));
        ingredienteArrayList.add(new Ingrediente(30,"g","Epaguetis"));
        ingredienteArrayList.add(new Ingrediente(31,"g","Tomate frito"));
        ingredienteArrayList.add(new Ingrediente(32,"g","Macarrones"));
        ingredienteArrayList.add(new Ingrediente(33,"g","Carne picada"));
        ingredienteArrayList.add(new Ingrediente(34,"g","Placas de lasaña"));
        ingredienteArrayList.add(new Ingrediente(35,"g","Fideos"));
        ingredienteArrayList.add(new Ingrediente(36,"l","Caldo"));
        ingredienteArrayList.add(new Ingrediente(37,"g","Pasta para ensalada"));
        ingredienteArrayList.add(new Ingrediente(38,"ud","Manzana"));
        ingredienteArrayList.add(new Ingrediente(39,"g","Pollo"));
        ingredienteArrayList.add(new Ingrediente(40,"g","Arroz"));
        ingredienteArrayList.add(new Ingrediente(41,"ud","Esparragos trigueros"));
        ingredienteArrayList.add(new Ingrediente(42,"g","Setas"));
        ingredienteArrayList.add(new Ingrediente(43,"ml","Nata"));
        ingredienteArrayList.add(new Ingrediente(44,"g","Mantequilla"));
        ingredienteArrayList.add(new Ingrediente(45,"ud","Pimiento"));
        ingredienteArrayList.add(new Ingrediente(46,"g","Tenera"));
        ingredienteArrayList.add(new Ingrediente(47,"g","Pechugas"));
        ingredienteArrayList.add(new Ingrediente(48,"g","Salchichas"));
        ingredienteArrayList.add(new Ingrediente(49,"g","Pavo"));
        ingredienteArrayList.add(new Ingrediente(50,"g","Cinta de lomo"));
        ingredienteArrayList.add(new Ingrediente(51,"g","Lubina"));
        ingredienteArrayList.add(new Ingrediente(52,"g","Salmon"));
        ingredienteArrayList.add(new Ingrediente(53,"g","Merluza"));
        ingredienteArrayList.add(new Ingrediente(54,"g","Sepia"));
        ingredienteArrayList.add(new Ingrediente(55,"g","Alubias"));
        ingredienteArrayList.add(new Ingrediente(56,"g","Pavo"));


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
        recetaArrayList.add(new Receta(3,7,100));
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
        recetaArrayList.add(new Receta(6,7,100));
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
        recetaArrayList.add(new Receta(14,2,1));
        recetaArrayList.add(new Receta(14,3,0.3));
        recetaArrayList.add(new Receta(14,10,0.5));
        recetaArrayList.add(new Receta(14,22,0.5));
        recetaArrayList.add(new Receta(14,30,100));
        recetaArrayList.add(new Receta(14,31,100));
        recetaArrayList.add(new Receta(15,2,1));
        recetaArrayList.add(new Receta(15,3,0.3));
        recetaArrayList.add(new Receta(15,15,0.5));
        recetaArrayList.add(new Receta(15,31,100));
        recetaArrayList.add(new Receta(15,32,100));
        recetaArrayList.add(new Receta(15,33,100));
        recetaArrayList.add(new Receta(16,11,100));
        recetaArrayList.add(new Receta(16,22,1));
        recetaArrayList.add(new Receta(16,26,100));
        recetaArrayList.add(new Receta(16,30,100));
        recetaArrayList.add(new Receta(16,43,100));
        recetaArrayList.add(new Receta(17,2,1));
        recetaArrayList.add(new Receta(13,3,0.3));
        recetaArrayList.add(new Receta(17,15,0.5));
        recetaArrayList.add(new Receta(17,26,50));
        recetaArrayList.add(new Receta(17,31,150));
        recetaArrayList.add(new Receta(17,33,150));
        recetaArrayList.add(new Receta(17,34,100));
        recetaArrayList.add(new Receta(17,42,50));
        recetaArrayList.add(new Receta(18,35,50));
        recetaArrayList.add(new Receta(18,36,330));
        recetaArrayList.add(new Receta(19,10,0.5));
        recetaArrayList.add(new Receta(19,11,50));
        recetaArrayList.add(new Receta(19,20,0.5));
        recetaArrayList.add(new Receta(19,37,50));
        recetaArrayList.add(new Receta(19,38,0.3));
        recetaArrayList.add(new Receta(19,39,100));
        recetaArrayList.add(new Receta(20,2,1));
        recetaArrayList.add(new Receta(20,3,0.3));
        recetaArrayList.add(new Receta(20,5,50));
        recetaArrayList.add(new Receta(20,17,50));
        recetaArrayList.add(new Receta(20,22,2));
        recetaArrayList.add(new Receta(20,31,100));
        recetaArrayList.add(new Receta(20,40,100));
        recetaArrayList.add(new Receta(21,2,1));
        recetaArrayList.add(new Receta(21,3,0.3));
        recetaArrayList.add(new Receta(21,20,0.3));
        recetaArrayList.add(new Receta(31,36,330));
        recetaArrayList.add(new Receta(21,39,100));
        recetaArrayList.add(new Receta(21,40,100));
        recetaArrayList.add(new Receta(21,45,0.5));
        recetaArrayList.add(new Receta(22,3,0.3));
        recetaArrayList.add(new Receta(22,11,100));
        recetaArrayList.add(new Receta(22,17,100));
        recetaArrayList.add(new Receta(22,20,0.3));
        recetaArrayList.add(new Receta(22,36,330));
        recetaArrayList.add(new Receta(22,42,50));
        recetaArrayList.add(new Receta(22,44,25));
        recetaArrayList.add(new Receta(23,2,1));
        recetaArrayList.add(new Receta(23,3,0.3));
        recetaArrayList.add(new Receta(23,24,1));
        recetaArrayList.add(new Receta(23,36,330));
        recetaArrayList.add(new Receta(24,14,2));
        recetaArrayList.add(new Receta(24,15,0.5));
        recetaArrayList.add(new Receta(24,22,1));
        recetaArrayList.add(new Receta(24,39,100));
        recetaArrayList.add(new Receta(25,3,0.3));
        recetaArrayList.add(new Receta(25,10,0.5));
        recetaArrayList.add(new Receta(25,14,2));
        recetaArrayList.add(new Receta(25,16,50));
        recetaArrayList.add(new Receta(25,20,0.3));
        recetaArrayList.add(new Receta(25,21,2));
        recetaArrayList.add(new Receta(26,46,250));
        recetaArrayList.add(new Receta(27,5,0.25));
        recetaArrayList.add(new Receta(27,11,50));
        recetaArrayList.add(new Receta(27,22,0.2));
        recetaArrayList.add(new Receta(27,46,200));
        recetaArrayList.add(new Receta(28,2,0.5));
        recetaArrayList.add(new Receta(2,3,0.5));
        recetaArrayList.add(new Receta(28,22,0.2));
        recetaArrayList.add(new Receta(28,31,150));
        recetaArrayList.add(new Receta(28,33,300));
        recetaArrayList.add(new Receta(29,3,0.1));
        recetaArrayList.add(new Receta(29,11,25));
        recetaArrayList.add(new Receta(29,16,20));
        recetaArrayList.add(new Receta(29,17,25));
        recetaArrayList.add(new Receta(29,20,0.2));
        recetaArrayList.add(new Receta(29,33,150));
        recetaArrayList.add(new Receta(30,2,0.5));
        recetaArrayList.add(new Receta(30,3,0.3));
        recetaArrayList.add(new Receta(30,14,1));
        recetaArrayList.add(new Receta(30,15,1));
        recetaArrayList.add(new Receta(30,20,0.3));
        recetaArrayList.add(new Receta(30,36,330));
        recetaArrayList.add(new Receta(30,46,200));
        recetaArrayList.add(new Receta(31,47,250));
        recetaArrayList.add(new Receta(32,22,0.5));
        recetaArrayList.add(new Receta(32,47,200));
        recetaArrayList.add(new Receta(33,2,0.5));
        recetaArrayList.add(new Receta(33,3,0.3));
        recetaArrayList.add(new Receta(33,14,1));
        recetaArrayList.add(new Receta(33,15,1));
        recetaArrayList.add(new Receta(33,20,0.3));
        recetaArrayList.add(new Receta(33,39,200));
        recetaArrayList.add(new Receta(33,42,50));
        recetaArrayList.add(new Receta(34,48,250));
        recetaArrayList.add(new Receta(35,2,0.5));
        recetaArrayList.add(new Receta(35,3,0.3));
        recetaArrayList.add(new Receta(35,14,2));
        recetaArrayList.add(new Receta(35,20,0.3));
        recetaArrayList.add(new Receta(35,36,330));
        recetaArrayList.add(new Receta(35,48,150));
        recetaArrayList.add(new Receta(36,56,250));
        recetaArrayList.add(new Receta(37,50,250));
        recetaArrayList.add(new Receta(38,5,0.25));
        recetaArrayList.add(new Receta(38,11,50));
        recetaArrayList.add(new Receta(38,22,0.5));
        recetaArrayList.add(new Receta(38,50,200));
        recetaArrayList.add(new Receta(39,2,1));
        recetaArrayList.add(new Receta(39,53,200));
        recetaArrayList.add(new Receta(40,53,200));
        recetaArrayList.add(new Receta(40,22,0.5));
        recetaArrayList.add(new Receta(41,2,1));
        recetaArrayList.add(new Receta(41,55,200));
        recetaArrayList.add(new Receta(42,52,200));
        recetaArrayList.add(new Receta(43,2,1));
        recetaArrayList.add(new Receta(43,54,250));

        for (int i = 0; i <recetaArrayList.size(); i++) {
            dataBase.consultas().insertReceta(recetaArrayList.get(i));
        }
    }


}
