package com.example.tickets.tickets;

        import java.util.ArrayList;

        import android.app.Activity;
        import android.app.ListActivity;
        import android.content.SharedPreferences;
        import android.os.Bundle;
        import android.preference.PreferenceManager;
        import android.widget.ListView;

public class Main extends ListActivity {


    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        // if extending Activity
        //setContentView(R.layout.activity_main);

        // 1. pass context and data to the custom adapter
        MyAdapter adapter = new MyAdapter(this, generateData());

        // if extending Activity 2. Get ListView from activity_main.xml
        //ListView listView = (ListView) findViewById(R.id.listview);

        // 3. setListAdapter
        //listView.setAdapter(adapter); if extending Activity
        setListAdapter(adapter);
    }


    private ArrayList<Model> generateData(){

        Bundle bundle = getIntent().getExtras();
        int nTicketsGrandes = bundle.getInt(getResources().getString(R.string.parametroGrandes));
        int nTicketsPequenos =  bundle.getInt(getResources().getString(R.string.parametroPequenos));
        float nResto =  bundle.getFloat(getResources().getString(R.string.parametroResto));

        SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        String stringTamanoGrande = SP.getString("valorGrande", "7.5");
        String stringTamanoPequen = SP.getString("valorPequeno", "1.5");

        ArrayList<Model> models = new ArrayList<Model>();
        models.add(new Model("Resultado:"));
        models.add(new Model(R.drawable.icon_ticket1,"Tickets de "+stringTamanoGrande+" €",Integer.toString(nTicketsGrandes)));
        models.add(new Model(R.drawable.icon_ticket2,"Tickets de "+stringTamanoPequen+" €",Integer.toString(nTicketsPequenos)));
        models.add(new Model(R.drawable.icon_euro,"Métálico",Float.toString(nResto)));

        return models;
    }

}
