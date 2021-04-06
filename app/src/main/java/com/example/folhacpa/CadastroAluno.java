package com.example.folhacpa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class CadastroAluno extends AppCompatActivity {


    private EditText edtNome;
    private EditText edtEmail;
    private EditText edtMatricula;

    private EditText edtPeriodo;
    private EditText editLoginUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_aluno);

        edtNome = (EditText)findViewById(R.id.edtNome);
        edtEmail = (EditText)findViewById(R.id.edtEmail);
        edtMatricula = (EditText)findViewById(R.id.edtMatricula);
        edtPeriodo = (EditText)findViewById(R.id.edtPeriodo);
        editLoginUsuario = (EditText)findViewById(R.id.edtLoginUsuario);
    }

    public void validaCampos() {



    }


}