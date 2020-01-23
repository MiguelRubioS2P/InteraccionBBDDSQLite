package cat.paucasesnovescifp.interaccionbbddsqlite.activitys;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

import cat.paucasesnovescifp.interaccionbbddsqlite.DBInterface;
import cat.paucasesnovescifp.interaccionbbddsqlite.R;

public class LlistaActivity extends AppCompatActivity {

    SimpleAdapter adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_llista);

        listView = findViewById(R.id.lista_activity);

        llistaContactes();

    }

    //No funciona poniendo esta clase con ListActivity
    /*public void llistaContactes(){

        DBInterface bd;
        bd = new DBInterface(getApplicationContext());
        bd.obre();
        Cursor c = bd.obtenirTotsElsContactes();
        c.moveToFirst();
        ArrayList<HashMap<String,String>> llista = new ArrayList<HashMap<String, String>>();
        while(!c.isAfterLast()){
            HashMap<String,String> map = new HashMap<String, String>();
            map.put("id",c.getString(0));
            map.put("nom",c.getString(1));
            map.put("email",c.getString(2));
            llista.add(map);
            c.moveToNext();
        }

        bd.tanca();
        adapter = new SimpleAdapter(getApplicationContext(), llista, R.layout.activity_item_lista, new String[]{"id","nom","email"},new int[]{R.id.id_item_lista,R.id.nombre_item_lista,R.id.email_item_lista});
        setListAdapter(adapter);

    }*/

    public void llistaContactes(){
        DBInterface bd;
        bd = new DBInterface(getApplicationContext());
        bd.obre();
        Cursor c = bd.obtenirTotsElsContactes();
        c.moveToFirst();
        ArrayList<HashMap<String,String>> llista = new ArrayList<HashMap<String, String>>();
        while(!c.isAfterLast()){
            HashMap<String,String> map = new HashMap<String, String>();
            map.put("id",c.getString(0));
            map.put("nom",c.getString(1));
            map.put("email",c.getString(2));
            llista.add(map);
            c.moveToNext();
        }

        bd.tanca();
        adapter = new SimpleAdapter(getApplicationContext(), llista, R.layout.activity_item_lista, new String[]{"id","nom","email"},new int[]{R.id.id_item_lista,R.id.nombre_item_lista,R.id.email_item_lista});
        listView.setAdapter(adapter);
    }

}
