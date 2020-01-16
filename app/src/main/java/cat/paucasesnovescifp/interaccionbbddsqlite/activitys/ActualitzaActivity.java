package cat.paucasesnovescifp.interaccionbbddsqlite.activitys;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import cat.paucasesnovescifp.interaccionbbddsqlite.DBInterface;
import cat.paucasesnovescifp.interaccionbbddsqlite.R;

public class ActualitzaActivity extends AppCompatActivity {

    Button btnActualitza;
    EditText editId,editEmail,editNom;
    DBInterface bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualitza);

        editId = findViewById(R.id.editTextIdActualitza);
        editNom = findViewById(R.id.editTextNomActualitza);
        editEmail = findViewById(R.id.editTextEmailActualitza);

        btnActualitza = findViewById(R.id.buttonActualitzaActualitza);
        btnActualitza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long id;
                bd = new DBInterface(getApplicationContext());
                bd.obre();
                id = Long.parseLong(editId.getText().toString());
                boolean result = bd.actualitzarContacte(id,editNom.getText().toString(),editEmail.getText().toString());
                if(result){
                    Toast.makeText(getApplicationContext(), "Element modificat",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "No s'ha pogut modificar l'element",Toast.LENGTH_SHORT).show();
                }
                bd.tanca();
                finish();
            }
        });

    }

}
