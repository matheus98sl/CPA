package com.example.folhacpa;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BancoDados extends SQLiteOpenHelper {

    private static final int VERSAO_BANCO = 1;
    private static final String BANCO_ALUNO = "bd_alunos";

    private static final String TABELA_ALUNO = "tb_alunos";

    private static final String COLUNA_CODIGO = "codigo";
    private static final String COLUNA_NOME = "nome";
    private static final String COLUNA_MATRICULA = "matricula";
    private static final String COLUNA_EMAIL = "email";
    private static final String COLUNA_SENHA = "senha";

    public BancoDados(@Nullable Context context) {
        super(context, BANCO_ALUNO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String QUERY_COLUNA = "CREATE TABLE " + TABELA_ALUNO + "("
                + COLUNA_CODIGO + " INTEGER PRIMARY KEY, " + COLUNA_NOME + " TEXT, "
                + COLUNA_MATRICULA + " INTEGER, " + COLUNA_EMAIL + " TEXT, "
                + COLUNA_SENHA + " TEXT) ";

        db.execSQL(QUERY_COLUNA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    // TESTE DE LEITURA DE DADOS DB============================

   /* private EditText txMatricula;

    public String verificar(Aluno aluno) {
        SQLiteDatabase db = getReadableDatabase();
        String sq_busca = "SELECT * from TABELA_ALUNO where matricula = " + "'" + txMatricula;
        Cursor c = db.rawQuery(sq_busca, null);
        while (c.moveToNext()) {
            if (txMatricula.getText().equals(c.getString(c.getColumnIndex("matricula")))) ;

        }

    ===========================================================*/



    /*CRUD ABAIXO */

    void addAlunos (com.example.questionario.Aluno aluno){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUNA_NOME, aluno.getNome());
        values.put(COLUNA_MATRICULA, aluno.getMatricula());
        values.put(COLUNA_EMAIL, aluno.getEmail());
        values.put(COLUNA_SENHA, aluno.getSenha());

        db.insert(TABELA_ALUNO, null, values);
        db.close();
    }

}




