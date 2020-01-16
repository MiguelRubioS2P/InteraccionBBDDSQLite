package cat.paucasesnovescifp.interaccionbbddsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cat.paucasesnovescifp.interaccionbbddsqlite.activitys.ActualitzaActivity;
import cat.paucasesnovescifp.interaccionbbddsqlite.activitys.AfegirActivity;
import cat.paucasesnovescifp.interaccionbbddsqlite.activitys.ConsultaActivity;
import cat.paucasesnovescifp.interaccionbbddsqlite.activitys.EsborraActivity;
import cat.paucasesnovescifp.interaccionbbddsqlite.activitys.LlistaActivity;

public class MainActivity extends AppCompatActivity {

    Button btnAfegir, btnConsulta,btnLlista,btnActualitza,btnEsBorra;
    DBInterface bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bd = new DBInterface(this);

        btnAfegir = findViewById(R.id.Afegir);
        btnAfegir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent i = new Intent(getApplicationContext(), AfegirActivity.class);
            startActivity(i);
            }
        });

        btnConsulta = findViewById(R.id.Consulta);
        btnConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ConsultaActivity.class);
                startActivity(i);
            }
        });

        btnLlista = findViewById(R.id.Llista);
        btnLlista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), LlistaActivity.class);
                startActivity(i);
            }
        });

        btnActualitza = findViewById(R.id.Actualitza);
        btnActualitza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ActualitzaActivity.class);
                startActivity(i);
            }
        });

        btnEsBorra = findViewById(R.id.Esborra);
        btnEsBorra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), EsborraActivity.class);
                startActivity(i);
            }
        });

    }
}
