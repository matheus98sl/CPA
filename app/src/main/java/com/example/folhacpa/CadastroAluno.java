package com.example.folhacpa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroAluno extends AppCompatActivity {


    private EditText edtNome;
    private EditText edtEmail;
    private EditText edtMatricula;
    private EditText edtPeriodo;
    private EditText editLoginUsuario;
    private Button btnSalvar;

    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_aluno);

        db = new DBHelper(this);


        edtMatricula = findViewById(R.id.edtMatricula);
        editLoginUsuario = findViewById(R.id.edtSenha);

        btnSalvar = findViewById(R.id.btnSalvar);


        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String matricula = edtMatricula.getText().toString();
                String senha = editLoginUsuario.getText().toString();
                if (matricula.equals("")) {
                    Toast.makeText(CadastroAluno.this, "Matricula não inserida", Toast.LENGTH_SHORT).show();
                } else if (senha.equals("")) {
                    Toast.makeText(CadastroAluno.this, "Senha não inserida", Toast.LENGTH_SHORT).show();
                } else {// TUDO CERTO
                    long res = db.CriarAluno(matricula, senha);
                    if (res > 0) {
                        Toast.makeText(CadastroAluno.this, "Registro OK", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(CadastroAluno.this, "Registro invalido", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    }

