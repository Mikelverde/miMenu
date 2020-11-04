package com.example.mimenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mimenu.Vistas.NuevoPlato;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void PantallaInicio(View view){
        Intent i;
        switch (view.getId()){
            case R.id.btn_NuevoPlato:
                i=new Intent(this, NuevoPlato.class);
                startActivity(i);
                break;
        }

    }
}