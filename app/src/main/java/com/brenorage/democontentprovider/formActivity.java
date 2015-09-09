package com.brenorage.democontentprovider;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class formActivity extends Activity {

    public DataBaseHelper helper;

    @Bind(R.id.nameText) EditText name;
    @Bind(R.id.emailText) EditText email;
    @Bind(R.id.ageText) EditText age;
    @Bind(R.id.genderRadio) RadioGroup gender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        helper = new DataBaseHelper(getBaseContext());

        ButterKnife.bind(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_form, menu);
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

    @OnClick(R.id.showData)
    public void showData(View view){
        Intent intent = new Intent(this, showDataActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.submitData)
    public void submitData(View view) {
        int maleGenderID = R.id.maleRadio;

        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();

        try {
            values.put("name", name.getText().toString());
            values.put("email", email.getText().toString());
            values.put("age", age.getText().toString());

            int genderChecked = gender.getCheckedRadioButtonId();

            if(genderChecked == maleGenderID){
                values.put("gender", 1);
            }
            else {
                values.put("gender", 2);
            }

            db.insert("client", null, values);

            Toast.makeText(getApplicationContext(),"Dados gravados", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(),"Erro ao gravar dados" + e, Toast.LENGTH_SHORT).show();
        }
    }

}