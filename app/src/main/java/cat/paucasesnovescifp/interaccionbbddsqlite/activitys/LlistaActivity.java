package cat.paucasesnovescifp.interaccionbbddsqlite.activitys;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

import cat.paucasesnovescifp.interaccionbbddsqlite.DBInterface;
import cat.paucasesnovescifp.interaccionbbddsqlite.R;

public class LlistaActivity extends ListActivity {

    SimpleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_llista);

        llistaContactes();

    }

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
        adapter = new SimpleAdapter(getApplicationContext(), llista, R.layout.activity_llista, new String[]{"id","nom","email"},new int[]{R.id.textViewIdLlista,R.id.textViewNomLlista,R.id.textViewEmailLlista});
        setListAdapter(adapter);

    }

}
