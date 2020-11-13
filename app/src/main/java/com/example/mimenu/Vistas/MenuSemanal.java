package com.example.mimenu.Vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.mimenu.DataBase;
import com.example.mimenu.Metodos.Metodos;
import com.example.mimenu.R;
import com.example.mimenu.Tablas.Plato;

import java.util.ArrayList;
import java.util.List;

public class MenuSemanal extends AppCompatActivity {

    DataBase dataBase;
    private List<Plato> verduras, legumbres, pastas, arrocesPatatas, segundos, ensaladas;
    private TextView pLu,sLu,pMa,sMa,pMi,sMi,pJu,sJu,pVi,sVi,pSa,sSa,pDo,sDo;
    Plato ensalada1, ensalada2,ensalada3,ensalada4;
    Plato segundo1, segundo2,segundo3;
    Plato verdura1, verdura2, verdura3;
    Plato pasta, arroz;
    Plato legumbre1, legumbre2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_semanal);

        pLu=findViewById(R.id.txt_primeroLu);
        sLu=findViewById(R.id.txt_segundoLu);
        pMa=findViewById(R.id.txt_primeroMa);
        sMa=findViewById(R.id.txt_segundoMa);
        pMi=findViewById(R.id.txt_primeroMi);
        sMi=findViewById(R.id.txt_segundoMi);
        pJu=findViewById(R.id.txt_primeroJu);
        sJu=findViewById(R.id.txt_segundoJu);
        pVi=findViewById(R.id.txt_primeroVi);
        sVi=findViewById(R.id.txt_segundoVi);
        pSa=findViewById(R.id.txt_primeroSa);
        sSa=findViewById(R.id.txt_segundoSa);
        pDo=findViewById(R.id.txt_primeroDo);
        sDo=findViewById(R.id.txt_segundoDo);


        dataBase= Metodos.getDataBase(this);

        verduras=buscarPlatoXTipo("Verdura");
        legumbres=buscarPlatoXTipo("Legumbre");
        pastas=buscarPlatoXTipo("Pasta");
        arrocesPatatas=buscarPlatoXTipo("Arroz-Patatas");
        ensaladas=buscarPlatoXTipo("Ensalada");
        segundos=dataBase.consultas().buscarPlatoXOrden("Segundo");

        int numeroDias=7;
        // 2 legumbre y ensalada
        // 1  pasta y ensalada
        // 1  arroz y ensalada
        // 3  verdura y un segundo


        int primeraLegumbre=generarNumeroAleatorioEntre(0,legumbres.size());
        legumbre1=legumbres.get(primeraLegumbre);
        legumbres.remove(primeraLegumbre);
        legumbre2=legumbres.get(generarNumeroAleatorioEntre(0,legumbres.size()));

        pasta=pastas.get(generarNumeroAleatorioEntre(0,pastas.size()));
        arroz=pastas.get(generarNumeroAleatorioEntre(0,arrocesPatatas.size()));

        int primeraVerdura=generarNumeroAleatorioEntre(0,verduras.size());
        verdura1=verduras.get(primeraVerdura);
        verduras.remove(primeraVerdura);
        int segundaVerdura=generarNumeroAleatorioEntre(0,verduras.size());
        verdura2=verduras.get(segundaVerdura);
        verduras.remove(segundaVerdura);
        verdura3=verduras.get(generarNumeroAleatorioEntre(0,verduras.size()));

        int primerSegundo=generarNumeroAleatorioEntre(0,segundos.size());
        segundo1=segundos.get(primerSegundo);
        segundos.remove(primerSegundo);
        int segundoSegundo=generarNumeroAleatorioEntre(0,segundos.size());
        segundo2=segundos.get(segundoSegundo);
        segundos.remove(segundoSegundo);
        segundo3=segundos.get(generarNumeroAleatorioEntre(0,segundos.size()));

        ensalada1=ensaladas.get(generarNumeroAleatorioEntre(0,ensaladas.size()));
        ensalada2=ensaladas.get(generarNumeroAleatorioEntre(0,ensaladas.size()));
        ensalada3=ensaladas.get(generarNumeroAleatorioEntre(0,ensaladas.size()));
        ensalada4=ensaladas.get(generarNumeroAleatorioEntre(0,ensaladas.size()));

        generarMenu();
    }

    //Metodos para cargar en arrays los platos disponibles divididos por tipo de plato

    public List<Plato> buscarPlatoXTipo(String tipo){
        List<Plato> platoList= dataBase.consultas().buscarPlatoXTipo(tipo);
        return platoList;
    }

    public  int generarNumeroAleatorioEntre(int num1, int num2){
        int numAleatorio=(int)Math.floor(Math.random()*(num1-num2)+num2);
        return numAleatorio;
    }

    public void generarMenu(){
        int semana=generarNumeroAleatorioEntre(1,3);
        switch (1){
            case 1:
                pLu.setText(legumbre1.nombrePlato);
                sLu.setText(ensalada1.nombrePlato);
                pMa.setText(verdura1.nombrePlato);
                sMa.setText(segundo1.nombrePlato);
                pMi.setText(pasta.nombrePlato);
                sMi.setText(ensalada2.nombrePlato);
                pJu.setText(legumbre2.nombrePlato);
                sJu.setText(ensalada2.nombrePlato);
                pVi.setText(verdura2.nombrePlato);
                sVi.setText(segundo2.nombrePlato);
                pSa.setText(verdura3.nombrePlato);
                sSa.setText(segundo3.nombrePlato);
                pDo.setText(arroz.nombrePlato);
                sDo.setText(ensalada4.nombrePlato);
        }
    }

}