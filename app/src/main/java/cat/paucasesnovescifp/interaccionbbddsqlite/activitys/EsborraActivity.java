package cat.paucasesnovescifp.interaccionbbddsqlite.activitys;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import cat.paucasesnovescifp.interaccionbbddsqlite.DBInterface;
import cat.paucasesnovescifp.interaccionbbddsqlite.R;

public class EsborraActivity extends AppCompatActivity {

    DBInterface bd;
    Button btnEsborra;
    EditText editId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esborra);

        editId = findViewById(R.id.editTextIdEsborra);
        btnEsborra = findViewById(R.id.buttonEsborraEsborra);
        btnEsborra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bd = new DBInterface(getApplicationContext());
                bd.obre();
                long id = Long.parseLong(editId.getText().toString());
                boolean result = bd.esborraContacte(id);
                if(result){
                    Toast.makeText(getApplicationContext(), "Elemet esborrat",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "No s'ha pogut esborrar l'element",Toast.LENGTH_SHORT).show();
                }
                bd.tanca();
                finish();
            }
        });
    }

}
