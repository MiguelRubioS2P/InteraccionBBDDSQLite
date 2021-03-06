package cat.paucasesnovescifp.interaccionbbddsqlite;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static cat.paucasesnovescifp.interaccionbbddsqlite.DBInterface.BD_CREATE;
import static cat.paucasesnovescifp.interaccionbbddsqlite.DBInterface.BD_NOM;
import static cat.paucasesnovescifp.interaccionbbddsqlite.DBInterface.BD_TAULA;
import static cat.paucasesnovescifp.interaccionbbddsqlite.DBInterface.TAG;
import static cat.paucasesnovescifp.interaccionbbddsqlite.DBInterface.VERSIO;

public class AjudaDB extends SQLiteOpenHelper {

    AjudaDB(Context con){
        super(con, BD_NOM, null, VERSIO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
            db.execSQL(BD_CREATE);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int VersioAntiga, int VersioNova) {
        Log.w(TAG, "Actualitzant Base de dades de la versió" + VersioAntiga + " a " + VersioNova + ". Destruirà totes les dades");
        db.execSQL("DROP TABLE IF EXISTS " + BD_TAULA);
        onCreate(db);
    }
}
