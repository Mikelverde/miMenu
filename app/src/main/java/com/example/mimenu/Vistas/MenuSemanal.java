package com.example.mimenu.Vistas;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.example.mimenu.DataBase;
import com.example.mimenu.MainActivity;
import com.example.mimenu.Metodos.Metodos;
import com.example.mimenu.R;
import com.example.mimenu.Tablas.Menu;
import com.example.mimenu.Tablas.Plato;
import java.util.ArrayList;
import java.util.List;

/**
 * Activity sobre la que se presenta la informacion del menu semanal generado
 * @author Mikel
 * @version 30/12/20
 */
public class MenuSemanal extends AppCompatActivity {

    DataBase dataBase;
    private List<Plato> verduras, legumbres, pastas, arrocesPatatas, segundos, ensaladas;
    private List<Menu> menuSemanal;
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



        // 2 legumbre y ensalada
        // 1  pasta y ensalada
        // 1  arroz y ensalada
        // 3  verdura y un segundo

        //si al iniciciar la aplicacion no existe un menu generado anteriormente genera uno
        if(dataBase.consultas().listarMenu().size()==0){
            menuSemanal= generarMenu();
            escribirMenu(menuSemanal);
        }else {
            menuSemanal=dataBase.consultas().listarMenu();
            escribirMenu(menuSemanal);
        }

    }

    /**
     * Metodo para recopilar por tipo de plato todos los platos de la bd
     */
    private void cragarPlatosXTipo() {
        verduras=buscarPlatoXTipo("Verdura");
        legumbres=buscarPlatoXTipo("Legumbre");
        pastas=buscarPlatoXTipo("Pasta");
        arrocesPatatas=buscarPlatoXTipo("Arroz-Patatas");
        ensaladas=buscarPlatoXTipo("Ensalada");
        segundos=dataBase.consultas().buscarPlatoXOrden("Segundo");
    }

    /**
     * Metodo que genera un menu a partir de las listas de plato por tipo
     * @return
     */
    private List<Menu> generarMenu() {
        cragarPlatosXTipo();
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

        //cargamos los platos anteriores en la tabla menu, mediante el uso de una List<Menu> menuSemanal
        menuSemanal= new ArrayList<>();
        try {
            menuSemanal.add(new Menu(legumbre1.idPlato));
            menuSemanal.add(new Menu(ensalada1.idPlato));
            menuSemanal.add(new Menu(verdura1.idPlato));
            menuSemanal.add(new Menu(segundo1.idPlato));
            menuSemanal.add(new Menu(pasta.idPlato));
            menuSemanal.add(new Menu(ensalada2.idPlato));
            menuSemanal.add(new Menu(legumbre2.idPlato));
            menuSemanal.add(new Menu(ensalada3.idPlato));
            menuSemanal.add(new Menu(verdura2.idPlato));
            menuSemanal.add(new Menu(segundo2.idPlato));
            menuSemanal.add(new Menu(verdura3.idPlato));
            menuSemanal.add(new Menu(segundo3.idPlato));
            menuSemanal.add(new Menu(arroz.idPlato));
            menuSemanal.add(new Menu(ensalada4.idPlato));

            for (int i = 0; i <menuSemanal.size(); i++) {
                dataBase.consultas().insertMenu(menuSemanal.get(i));
            }
        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return dataBase.consultas().listarMenu();
    }

    //Metodos para cargar en arrays los platos disponibles divididos por tipo de plato

    /**
     * Metodo para buscar platos segun su tipo
     * @param tipo (verdura, legumbre...)
     * @return lista con los platos
     */
    public List<Plato> buscarPlatoXTipo(String tipo){
        List<Plato> platoList= dataBase.consultas().buscarPlatoXTipo(tipo);
        return platoList;
    }

    /**
     * generamos un numero aleatorio entre dos valores num1 y num2
     * @param num1
     * @param num2
     * @return
     */
    public  int generarNumeroAleatorioEntre(int num1, int num2){
        int numAleatorio=(int)Math.floor(Math.random()*(num1-num2)+num2);
        return numAleatorio;
    }

    //cargamos los daos de la tabla menu para rellenar los TextView correspondientes

    /**
     * metodo para escribir el menu semanal en la activity
     * @param menusemanal
     */
    public void escribirMenu(List<Menu> menusemanal){
        //Para un futuro desarrollo donde habra distintos tipos de menus semanales
        int semana=generarNumeroAleatorioEntre(1,3);
        switch (1){
            case 1:
                pLu.setText(dataBase.consultas().buscarPlatoXId(menuSemanal.get(0).idPlato).nombrePlato);
                sLu.setText(dataBase.consultas().buscarPlatoXId(menuSemanal.get(1).idPlato).nombrePlato);
                pMa.setText(dataBase.consultas().buscarPlatoXId(menuSemanal.get(2).idPlato).nombrePlato);
                sMa.setText(dataBase.consultas().buscarPlatoXId(menuSemanal.get(3).idPlato).nombrePlato);
                pMi.setText(dataBase.consultas().buscarPlatoXId(menuSemanal.get(4).idPlato).nombrePlato);
                sMi.setText(dataBase.consultas().buscarPlatoXId(menuSemanal.get(5).idPlato).nombrePlato);
                pJu.setText(dataBase.consultas().buscarPlatoXId(menuSemanal.get(6).idPlato).nombrePlato);
                sJu.setText(dataBase.consultas().buscarPlatoXId(menuSemanal.get(7).idPlato).nombrePlato);
                pVi.setText(dataBase.consultas().buscarPlatoXId(menuSemanal.get(8).idPlato).nombrePlato);
                sVi.setText(dataBase.consultas().buscarPlatoXId(menuSemanal.get(9).idPlato).nombrePlato);
                pSa.setText(dataBase.consultas().buscarPlatoXId(menuSemanal.get(10).idPlato).nombrePlato);
                sSa.setText(dataBase.consultas().buscarPlatoXId(menuSemanal.get(11).idPlato).nombrePlato);
                pDo.setText(dataBase.consultas().buscarPlatoXId(menuSemanal.get(12).idPlato).nombrePlato);
                sDo.setText(dataBase.consultas().buscarPlatoXId(menuSemanal.get(13).idPlato).nombrePlato);
        }
    }

    /**
     * Al pulsar el boton "Generar menu" se realizan las operaciones necesarias para mostrarle al
     * usuario el menu semanal por pantalla
     * @param view
     */
    public void grabarMenu(View view){

        List<Menu> menuList=dataBase.consultas().listarMenu();
        if(menuList.size()==0){//no existe un menu previo, hay que generarlo
           try {
               generarMenu();
            }catch (Exception e){
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }else {
            menuSemanal=dataBase.consultas().listarMenu();
            dataBase.consultas().borrarPlatoMenu(menuSemanal);
            generarMenu();
            try {
            }catch (Exception e){
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }

            escribirMenu(menuSemanal);

        }
    }

    /**
     * Al pulsar el boton volvemos a la activity anterior
     * @param view
     */
    public void atras2(View view){
        Intent i=new Intent(this, MainActivity.class);
        startActivity(i);
    }

}