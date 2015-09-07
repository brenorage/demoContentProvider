package com.brenorage.democontentprovider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by breno on 29/08/2015.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

        public static final String DATABASENAME = "database";
        public static final int DATABASEVERSION = 1;

        public final String TABLENAME = "client";
        public final String NAMETABLE = "name";
        public final String EMAILTABLE = "email";
        public final String AGETABLE = "age";
        public final String GENDERTABLE = "gender";


        public DataBaseHelper(Context context){
            super(context, DATABASENAME, null, DATABASEVERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db){

            db.execSQL("CREATE TABLE client (_id INTEGER PRIMARY KEY, name TEXT, email TEXT, age TEXT, gender INTEGER);");

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){


        }

    }



