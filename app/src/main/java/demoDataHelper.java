import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by brenorage on 18/08/15.
 */
public class demoDataHelper extends SQLiteOpenHelper {

    public static final String DATABASENAME = "database";
    public static final int DATABASEVERSION = 1;

    public demoDataHelper(Context context){
        super(context, DATABASENAME, null, DATABASEVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){

        db.execSQL("CREATE TABLE client (_id INTEGER PRIMARY KEY, name TEXT, age INTEGER, sexo INTEGER");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){


    }

}
