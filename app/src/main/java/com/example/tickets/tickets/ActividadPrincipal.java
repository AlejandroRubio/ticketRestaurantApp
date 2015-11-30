package com.example.tickets.tickets;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;

import com.example.tickets.calculator.Calculo;
import com.example.tickets.calculator.EstructuraResultados;
import com.example.tickets.database.DatabaseHelper;
import com.example.tickets.database.TamanoConfiguracion;

public class ActividadPrincipal extends AppCompatActivity {

    DatabaseHelper db= new DatabaseHelper(this);
    private Button btnPreferencias;
    private Button btnObtenerPreferencias;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);

        //Definición de los elementos gráficos
        final Button button = (Button) findViewById(R.id.button2);
        final EditText edittext = (EditText) findViewById(R.id.editText);

        //Listener del botón de cálculo
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //Recuperación del precio a calcular

                String input = edittext.getText().toString();
                float numero = Float.parseFloat(input);

                //Recuperamos las preferencias de tamaño de tickets
                SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                String stringTamanoGrande = SP.getString("valorGrande", "7.5");
                String stringTamanoPequen = SP.getString("valorPequeno", "1.5");

                //Cálculo de resultado
                Calculo cal = new Calculo();
                EstructuraResultados resultado = new EstructuraResultados();
                resultado = cal.calcular(numero, Float.parseFloat(stringTamanoGrande),Float.parseFloat(stringTamanoPequen));

                //Paso de parámetros a la segunda ventana
               // Intent myIntent = new Intent(ActividadPrincipal.this, ActividadResultado.class);
              //  Bundle b = new Bundle();
              //  b.putInt(getResources().getString(R.string.parametroGrandes), resultado.getNumTicketsGrandes());
              //  b.putInt(getResources().getString(R.string.parametroPequenos), resultado.getNumTicketsPequenos());
              //  b.putFloat(getResources().getString(R.string.parametroResto), resultado.getRestoAPagar());
              //  myIntent.putExtras(b);
              //  ActividadPrincipal.this.startActivity(myIntent);

                Intent myIntent = new Intent(ActividadPrincipal.this, Main.class);

                Bundle b = new Bundle();
                b.putInt(getResources().getString(R.string.parametroGrandes), resultado.getNumTicketsGrandes());
                b.putInt(getResources().getString(R.string.parametroPequenos), resultado.getNumTicketsPequenos());
                b.putFloat(getResources().getString(R.string.parametroResto), resultado.getRestoAPagar());
                myIntent.putExtras(b);
                ActividadPrincipal.this.startActivity(myIntent);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Intent i = new Intent(this, ActividadPreferencias.class);
                startActivity(i);
                return true;

            case R.id.action_about:
                Intent i2 = new Intent(this, ActividadSplashScreen.class);
                startActivity(i2);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}