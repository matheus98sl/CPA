package com.example.folhacpa;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

public class DBHelper extends SQLiteOpenHelper {

    private static int versao = 1;
    private static String nome = "Cadastro_Alunos.bd";

    public DBHelper(@Nullable Context context) {
        super(context, nome, null, versao);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String str = "CREATE TABLE Aluno(ID VARCHAR PRIMARY KEY, matricula VARCHAR(50), senha VARCHAR(20));";
        db.execSQL(str);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Aluno;");
        onCreate(db);
    }

    public long CriarAluno(String matricula, String senha) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("matricula", matricula);
        cv.put("senha", senha);
        long result = db.insert("Aluno", null, cv);
        return result;

    }

    public String ValidarLogin(String matricula, String senha) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM Aluno WHERE matricula=? AND senha=?", new String[]{matricula,senha});
        if(c.getCount()>0){
            return "OK";
        }
        return "ERRO";
    }
}
