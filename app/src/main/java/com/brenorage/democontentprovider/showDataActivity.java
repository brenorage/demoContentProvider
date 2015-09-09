package com.brenorage.democontentprovider;

import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CursorAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class showDataActivity extends AppCompatActivity {

    public DataBaseHelper helper;

    @Bind(R.id.showName)
    TextView showName;

    @Bind(R.id.showEmail)
    TextView showEmail;

    @Bind(R.id.showAge)
    TextView showAge;

    @Bind(R.id.showGender)
    TextView showGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);
        ButterKnife.bind(this);

        loadData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_show_data, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void loadData() {
        helper = new DataBaseHelper(this);

        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM client", null);
        cursor.moveToFirst();
        do {
            String name = cursor.getString(cursor.getColumnIndex(helper.NAMETABLE));
            String email = cursor.getString(cursor.getColumnIndex(helper.EMAILTABLE));
            String age = cursor.getString(cursor.getColumnIndex(helper.AGETABLE));
            String gender = cursor.getString(cursor.getColumnIndex(helper.GENDERTABLE));
            if (gender == "1") {
                showGender.setText("Masculino");
            }
            else {
                showGender.setText("Feminino");
            }

            showName.setText(name);
            showEmail.setText(email);
            showAge.setText(age);

        } while (cursor.moveToNext());

    }
}
