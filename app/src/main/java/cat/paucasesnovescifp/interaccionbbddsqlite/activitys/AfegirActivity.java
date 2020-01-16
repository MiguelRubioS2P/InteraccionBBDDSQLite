package cat.paucasesnovescifp.interaccionbbddsqlite.activitys;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import cat.paucasesnovescifp.interaccionbbddsqlite.DBInterface;
import cat.paucasesnovescifp.interaccionbbddsqlite.R;

public class AfegirActivity extends AppCompatActivity {

    Button btnAfegir;
    EditText editTextNombre, editTextEmail;
    DBInterface bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afegir);

        btnAfegir = findViewById(R.id.buttonAñadir);
        editTextNombre = findViewById(R.id.editTextNombre);
        editTextEmail = findViewById(R.id.editTextEmail);

        btnAfegir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bd = new DBInterface(getApplicationContext());
                bd.obre();

                if(bd.insereixContacte(editTextNombre.getText().toString(), editTextEmail.getText().toString()) != -1){
                    Toast.makeText(getApplicationContext(), "Afegit correctament",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Error a l'afegir",Toast.LENGTH_SHORT).show();
                }
                bd.tanca();
                finish();
            }
        });

    }
}
