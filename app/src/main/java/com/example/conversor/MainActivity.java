package com.example.conversor;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    valoresTodos traer=new valoresTodos() ;

    TabHost SelecConversores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SelecConversores = (TabHost) findViewById(R.id.tbhSelecConversores);
        SelecConversores.setup();

        SelecConversores.addTab(SelecConversores.newTabSpec("Moneda").setContent(R.id.Moneda).setIndicator("Monedas"));
        SelecConversores.addTab(SelecConversores.newTabSpec("Longitud").setContent(R.id.Longitud).setIndicator("Longitud"));
    }

    public void Convertir(View view){
        try {
            TextView tmpVal = (TextView) findViewById(R.id.IngreseCantidadTV);
            double cantidad = Double.parseDouble(tmpVal.getText().toString());



            int de = 0, a = 0;
            double resp = 0;
            switch (SelecConversores.getCurrentTabTag()) {

                case "Moneda":
                    traer.val   = (Spinner ) findViewById(R.id.MonedaActualSP);
                    de = traer.val .getSelectedItemPosition();
                    traer.val  = (Spinner) findViewById(R.id.MonedaCambiarSP);
                    a = traer.val .getSelectedItemPosition();
                    resp = traer .valores  [0][a] / traer .valores [0][de] * cantidad;
                    break;
                case "Longitud":
                    traer.val = (Spinner) findViewById(R.id.longitudActualSP );
                    de = traer.val.getSelectedItemPosition();
                    traer.val  = (Spinner) findViewById(R.id.LongitudCambiarSP );
                    a = traer .val.getSelectedItemPosition();
                    resp = traer.valores  [1][a] / traer.valores [1][de] * cantidad;
                    break;

            }




            tmpVal = (TextView) findViewById(R.id.ResultadoTV);
            tmpVal.setText(String.format("Por la cantidad de: "+ cantidad  + " Usted recivira " + resp  ));
        }catch (Exception err){
            TextView temp = (TextView) findViewById(R.id.ResultadoTV);
            temp.setText("Porfavor Ingrese solo Numeros.");

            Toast.makeText(getApplicationContext(),"Por Favor Ingrese Solamente Numeros",Toast.LENGTH_LONG).show();


        }
    }


}


