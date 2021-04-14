package com.example.folhacpa;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.folhacpa.DataBase.DadosOpenHelper;
import com.example.folhacpa.dominio.entidade.Aluno;
import com.example.folhacpa.dominio.repositorio.AlunoRepositorio;
import com.google.android.material.snackbar.Snackbar;

public class CadastroAluno extends AppCompatActivity {


    private EditText edtNome;
    private EditText edtEmail;
    private EditText edtMatricula;
    private EditText edtPeriodo;
    private EditText editLoginUsuario;
    private Button btnSalvar;
    private AlunoRepositorio alunoRepositorio;
    private SQLiteDatabase conexao;
    private DadosOpenHelper dadosOpenHelper;
    private ConstraintLayout layoutContentCadastro;
    private Aluno aluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_aluno);

        btnSalvar = findViewById(R.id.btnSalvar);
        edtNome = findViewById(R.id.edtNome);
        edtEmail = findViewById(R.id.edtEmail);
        edtMatricula = findViewById(R.id.edtMatricula);
        edtPeriodo = findViewById(R.id.edtPeriodo);
        editLoginUsuario = findViewById(R.id.edtLoginUsuario);
        layoutContentCadastro = (ConstraintLayout) findViewById(R.id.layoutContentCadastro);
        criarConexao();
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmar();
            }
        });
    }

    private void criarConexao() {

        try {

            dadosOpenHelper = new DadosOpenHelper(this);
            conexao = dadosOpenHelper.getWritableDatabase();

            Snackbar.make(layoutContentCadastro, " Conexao criada com sucesso!", Snackbar.LENGTH_SHORT)
                    .setAction("OK", null).show();

            alunoRepositorio = new AlunoRepositorio(conexao);

        } catch (SQLException ex) {

            AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
            dialogo.setTitle("Erro");
            dialogo.setMessage(ex.getMessage());
            dialogo.setNeutralButton("OK", null);
            dialogo.show();

        }
    }

    private void confirmar() {

        aluno = new Aluno();

        if (validaCampos() == false) {

            try {

                alunoRepositorio.inserir(aluno);

                finish();

            } catch (SQLException ex) {

                AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
                dialogo.setTitle("Erro");
                dialogo.setMessage(ex.getMessage());
                dialogo.setNeutralButton("OK", null);
                dialogo.show();

            }
        }
    }


    private boolean validaCampos() {

        boolean res = false;

        String nome = edtNome.getText().toString();
        String email = edtEmail.getText().toString();
        String matricula = edtMatricula.getText().toString();
        String periodo = edtPeriodo.getText().toString();
        String usuario = editLoginUsuario.getText().toString();

        aluno.nome = nome;
        aluno.email = email;
        aluno.matricula = matricula;
        aluno.periodo = periodo;
        aluno.usuario = usuario;

        if (res = isCampoVazio(nome)) {
            edtNome.requestFocus();

        } else if (res = isCampoVazio(email)) {
            edtEmail.requestFocus();

        } else if (res = isCampoVazio(matricula)) {
            edtMatricula.requestFocus();

        } else if (res = isCampoVazio(periodo)) {
            edtPeriodo.requestFocus();

        } else if (res = isCampoVazio(usuario)) {
            editLoginUsuario.requestFocus();

        }

        if (res) {
            AlertDialog.Builder dialogo = new AlertDialog.Builder(CadastroAluno.this);
            dialogo.setTitle("AVISO");
            dialogo.setMessage("CAMPOS EM BRANCO");
            dialogo.setNeutralButton("OK", null);
            dialogo.show();
        }
        return res;
    }

    private boolean isCampoVazio(String valor) {
        boolean resultado = (TextUtils.isEmpty(valor) || valor.trim().isEmpty());
        return resultado;

    }

    private boolean isEmailValido(String email) {

        boolean resultado = (!isCampoVazio(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
        return resultado;

    }

}


/* CODIGOS SEM UTILIZAÇAO ATE O MOMENTO VERIFICAR


    /*@Override
    public boolean onCreateOptionMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.layout.activity_cadastro_aluno, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelect(MenuItem item) {

        int id = item.getItemId();

        switch (id) {

            case R.id.btnSalvar:

                confirmar();

                break;

       case R.id.btnSalvar:
                finish();

                break;



*/
        /* VERIFICAR USO
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editLoginUsuario.getText().toString().equals("") ||
                        (edtEmail.getText().toString().equals("") ||
                                (edtMatricula.getText().toString().equals("") ||
                                        (edtNome.getText().toString().equals("") ||
                                                (edtPeriodo.getText().toString().equals("")))))) {
                    AlertDialog.Builder dialogo = new
                            AlertDialog.Builder(CadastroAluno.this);
                    dialogo.setMessage("Falta campos ");
                    dialogo.setNeutralButton("OK", null);
                    dialogo.show();

                } else {
                    btnSalvarActivity();
                }
            }

            private void btnSalvarActivity() {
                startActivity(new Intent(CadastroAluno.this, MainActivity.class));
            }
        });
    }
*/



