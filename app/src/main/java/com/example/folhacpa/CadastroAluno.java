package com.example.folhacpa;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CadastroAluno extends AppCompatActivity {


    private EditText edtNome;
    private EditText edtEmail;
    private EditText edtMatricula;
    private EditText edtPeriodo;
    private EditText editLoginUsuario;
    private Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_aluno);

        edtNome = findViewById(R.id.edtNome);
        edtEmail = findViewById(R.id.edtEmail);
        edtMatricula = findViewById(R.id.edtMatricula);
        edtPeriodo = findViewById(R.id.edtPeriodo);
        editLoginUsuario = findViewById(R.id.edtLoginUsuario);
        btnSalvar = findViewById(R.id.btnSalvar);

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

    public void validaCampos() {


    }


}