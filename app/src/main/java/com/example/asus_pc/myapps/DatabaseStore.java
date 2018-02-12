package com.example.asus_pc.myapps;

//Creating databse for store link up weblink and app name

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseStore extends SQLiteOpenHelper {

    private static final String DatabaseName = "Database2.db";          //database name
    private static final String TableName = "Details2";                  //database table name
    private static final String ID = "ID";
    private static final String Name = "AppName";
    private static final String url = "URL";
    private static final int versionNo = 1;
    private Context context;
    private static final String string = "CREATE TABLE "+TableName+"( "+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+Name+" VARCHAR(255), "+url+" VARCHAR(255)); ";
    private static final String str = "DROP TABLE IF EXISTS "+TableName;

    public DatabaseStore(Context context) {
        super(context, DatabaseName, null, versionNo);
        this.context = context;
        //
    }

    //Override method for creating database

    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
            db.execSQL(string);
        }
        catch(Exception e){
        }
    }

    //Override method for upgrad database

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try{
            db.execSQL(str);
            onCreate(db);
        }catch(Exception e){

        }
    }

    //method created for insert value in database

    public void insertData(String name, String url1){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Name,name);
        contentValues.put(url,url1);

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+TableName,null);

        int count = 0;
        boolean isput = true;

        while(cursor.moveToNext())
        {
            count++;
            if(cursor.getString(1).equals("")) {
                String s = Integer.toString(count);
                updateData(s,name,url1);
                isput = false;
                break;
            }
        }
        if(isput){
            sqLiteDatabase.insert(TableName,null,contentValues);
        }
    }

    //method created for searching value in database

    public String search(int p)
    {
        return findPassward(p);
    }

    private String findPassward(int p) {

        int count = 0;
        int value = p;
        String name = "";

        SQLiteDatabase sq = this.getReadableDatabase();
        Cursor cursor = sq.rawQuery("SELECT * FROM "+TableName,null);

        while(cursor.moveToNext())
        {
            count++;
            if(count == value) {
                name = cursor.getString(1);
                break;
            }
        }
        return name;
    }

    public String search1(int p)
    {
        return findPassward1(p);
    }

    private String findPassward1(int p) {

        int count = 0;
        int value = p;
        String name = "";

        SQLiteDatabase sq = this.getReadableDatabase();
        Cursor cursor = sq.rawQuery("SELECT * FROM "+TableName,null);

        while(cursor.moveToNext())
        {
            count++;
            if(count == value) {
                name = cursor.getString(2);
                break;
            }
        }
        return name;
    }

    public long updateData(String id, String name, String url1){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID,id);
        contentValues.put(Name,name);
        contentValues.put(url,url1);
        long rowId = sqLiteDatabase.update(TableName,contentValues,"ID = ?",new String[] { id });
        return rowId;
    }

    public void setTable(String s) {
        set = s;
        Log.d("tag",set);
    }

}
