package cat.paucasesnovescifp.interaccionbbddsqlite.activitys;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import cat.paucasesnovescifp.interaccionbbddsqlite.DBInterface;
import cat.paucasesnovescifp.interaccionbbddsqlite.R;

public class ConsultaActivity extends AppCompatActivity {

    EditText editTextIdConsulta;
    Button btnConsulta;
    DBInterface bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);

        editTextIdConsulta = findViewById(R.id.editTextIdConsulta);
        btnConsulta = findViewById(R.id.buttonConsultaConsulta);

        btnConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor c;
                bd = new DBInterface(getApplicationContext());
                bd.obre();

                long id = Long.parseLong(editTextIdConsulta.getText().toString());
                c = bd.obtenirContacte(id);

                if(c.getCount() != 0){
                    Toast.makeText(getApplicationContext(), "ID: " + c.getString(0) + "\n" + "Nom: " + c.getString(1) + "\n Email: " + c.getString(2),Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "ID inexistent!", Toast.LENGTH_SHORT).show();
                }

                bd.tanca();
                finish();
            }
        });

    }

}
