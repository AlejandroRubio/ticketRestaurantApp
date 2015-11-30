package com.example.tickets.tickets;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ActividadResultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultado);

        //Recuperación de los parámetros
        Bundle bundle = getIntent().getExtras();
        int nTicketsGrandes = bundle.getInt(getResources().getString(R.string.parametroGrandes));
        int nTicketsPequenos =  bundle.getInt(getResources().getString(R.string.parametroPequenos));
        float nResto =  bundle.getFloat(getResources().getString(R.string.parametroResto));

        //Creación del textview de tickets grandes
        final TextView textGrandes = (TextView) findViewById(R.id.resultadoGrandes);
        String textoTicketsGrandes = getResources().getString(R.string.textTicketsGrandes);
        textoTicketsGrandes=textoTicketsGrandes+" "+Integer.toString(nTicketsGrandes);
        textGrandes.setText(textoTicketsGrandes);

        //Creación del textview de tickets grandes
        final TextView textPequenos = (TextView) findViewById(R.id.resultadoPequenos);
        String textoTicketsPequenos = getResources().getString(R.string.textTicketsPequenos);
        textoTicketsPequenos=textoTicketsPequenos+" "+Integer.toString(nTicketsPequenos);
        textPequenos.setText(textoTicketsPequenos);

        //Creación del textview de tickets grandes
        final TextView textResto = (TextView) findViewById(R.id.resultadoResto);
        String textoRestoAPagar = getResources().getString(R.string.textResto);
        textoRestoAPagar=textoRestoAPagar+" "+Float.toString(nResto);
        textResto.setText(textoRestoAPagar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
