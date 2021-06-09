package com.example.studentdatasave;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.studentdatasave.model.Student;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {

    static SQLiteDatabase db;

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "StudentData.db";
    private static final String TABLE_STUDENT = "Student";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_SURNAME= "surname";
    public static final String COLUMN_EMAIL= "email";
    public static final String COLUMN_PASSWORD= "password";
    public static final String COLUMN_CONFIRMPASSWORD= "confirm_password";
    public static final String COLUMN_COUNTRY= "country";
    public static final String COLUMN_STATE= "state";
    public static final String COLUMN_CITY= "city";
    public static final String COLUMN_PINCODE= "pincode";
    public static final String COLUMN_PHONE= "phone_no";
    public static final String COLUMN_IMAGE= "image";

    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_STUDENT + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_NAME + " TEXT,"
            + COLUMN_SURNAME +  " TEXT,"
            + COLUMN_EMAIL + " TEXT,"
            + COLUMN_PASSWORD + " TEXT,"
            + COLUMN_CONFIRMPASSWORD + " TEXT,"
            + COLUMN_COUNTRY + " TEXT,"
            + COLUMN_STATE + " TEXT,"
            + COLUMN_CITY + " TEXT,"
            + COLUMN_PINCODE + " INTEGER,"
            + COLUMN_PHONE + " INTEGER,"
            + COLUMN_IMAGE + " BLOB "
            + ")";

    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_STUDENT;

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_USER_TABLE);
        onCreate(db);
    }
    public void insertData(Student student){
        db=this.getWritableDatabase();
        ContentValues contentValue=new ContentValues();
        contentValue.put(COLUMN_ID, student.getId());
        contentValue.put(COLUMN_NAME, student.getName());
        contentValue.put(COLUMN_SURNAME, student.getSurname());
        contentValue.put(COLUMN_EMAIL, student.getEmail());
        contentValue.put(COLUMN_PASSWORD, student.getPassword());
        contentValue.put(COLUMN_CONFIRMPASSWORD, student.getConfirm_password());
        contentValue.put(COLUMN_COUNTRY, student.getCountry());
        contentValue.put(COLUMN_STATE, student.getState());
        contentValue.put(COLUMN_CITY, student.getCity());
        contentValue.put(COLUMN_PINCODE, student.getPin_code());
        contentValue.put(COLUMN_PHONE, student.getPhone_no());
        contentValue.put(COLUMN_IMAGE, student.getImage());

        db.insert(TABLE_STUDENT, null, contentValue);
        db.close();
    }
    public void updateData(Student student){
        db=this.getWritableDatabase();
        ContentValues contentValue=new ContentValues();
        contentValue.put(COLUMN_ID, student.getId());
        contentValue.put(COLUMN_NAME, student.getName());
        contentValue.put(COLUMN_SURNAME, student.getSurname());
        contentValue.put(COLUMN_EMAIL, student.getEmail());
        contentValue.put(COLUMN_PASSWORD, student.getPassword());
        contentValue.put(COLUMN_CONFIRMPASSWORD, student.getConfirm_password());
        contentValue.put(COLUMN_COUNTRY, student.getCountry());
        contentValue.put(COLUMN_STATE, student.getState());
        contentValue.put(COLUMN_CITY, student.getCity());
        contentValue.put(COLUMN_PINCODE, student.getPin_code());
        contentValue.put(COLUMN_PHONE, student.getPhone_no());
        contentValue.put(COLUMN_IMAGE, student.getImage());
        db.update(TABLE_STUDENT, contentValue, COLUMN_ID + " = ?", new String[]{String.valueOf(student.getId())});
        db.close();
    }
    public void deleteData(Student student) {
        db = this.getWritableDatabase();
        db.delete(TABLE_STUDENT, COLUMN_ID + " = ?", new String[]{String.valueOf(student.getId())});
        db.close();
    }
    public void open() {
        db = this.getWritableDatabase();
    }

    public Cursor fatchData()
    {
        db=this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+ TABLE_STUDENT,null);
        return res;
    }

//    public Boolean checkid() {
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery("Select * from TABLE_STUDENT where COLUMN_ID = ?",null);
//        return cursor.getCount() > 0;
//    }


//    Cursor res = db.rawQuery("SELECT * FROM TABLE_STUDENT WHERE COLUMN_ID = ?", new String[] {COLUMN_ID});
//        Cursor res = db.rawQuery("select * from " + TABLE_STUDENT+" where COLUMN_ID =?", null);
//        Cursor res = db.query(TABLE_STUDENT, new String[] {COLUMN_ID,COLUMN_NAME,COLUMN_SURNAME,COLUMN_EMAIL,COLUMN_PASSWORD, COLUMN_CONFIRMPASSWORD,COLUMN_COUNTRY, COLUMN_STATE,COLUMN_CITY,COLUMN_PINCODE,COLUMN_PHONE }, COLUMN_ID + "=?",
//                null, null, null, null, null);
//    public Cursor fetchData(Student student) {
//        db = this.getReadableDatabase();
//
//        String[] columns = new String[] { COLUMN_ID,COLUMN_NAME,COLUMN_SURNAME,COLUMN_EMAIL,COLUMN_PASSWORD,
//                COLUMN_CONFIRMPASSWORD,COLUMN_COUNTRY,
//                COLUMN_STATE,COLUMN_CITY,COLUMN_PINCODE,COLUMN_PHONE};
//        cursor = db.query(TABLE_STUDENT, columns, COLUMN_ID + " = ?", new String[]{String.valueOf(student.getId())},
//                null, null, null,null);
//        if (cursor != null) {
//            cursor.moveToFirst();
//        }
//        return cursor;
//    }
//    public void fetchData(Student student){
//        db= this.getReadableDatabase();
//        ContentValues contentValue=new ContentValues();
//        contentValue.put(COLUMN_ID, student.getId());
//        contentValue.put(COLUMN_NAME, student.getName());
//        contentValue.put(COLUMN_SURNAME, student.getSurname());
//        contentValue.put(COLUMN_EMAIL, student.getEmail());
//        contentValue.put(COLUMN_PASSWORD, student.getPassword());
//        contentValue.put(COLUMN_CONFIRMPASSWORD, student.getConfirm_password());
//        contentValue.put(COLUMN_COUNTRY, student.getCountry());
//        contentValue.put(COLUMN_STATE, student.getState());
//        contentValue.put(COLUMN_CITY, student.getCity());
//        contentValue.put(COLUMN_PINCODE, student.getPin_code());
//        contentValue.put(COLUMN_PHONE, student.getPhone_no());
//        contentValue.put(COLUMN_IMAGE, student.getImage());
//        String[] columns = new String[] { COLUMN_ID,COLUMN_NAME,COLUMN_SURNAME,COLUMN_EMAIL,COLUMN_PASSWORD,
//                COLUMN_CONFIRMPASSWORD,COLUMN_COUNTRY,
//                COLUMN_STATE,COLUMN_CITY,COLUMN_PINCODE,COLUMN_PHONE};
//        Cursor cursor=db.query(TABLE_STUDENT,columns,null,null, null, null,null);
//        if (cursor != null) {
//            cursor.moveToFirst();
//        }
//    }
}
