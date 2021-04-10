package com.example.folhacpa;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.PasswordAuthentication;


public class MainActivity extends AppCompatActivity {

    private Button btnLogin;
    private EditText txMatricula;
    private EditText txSenha;
    private Button btnRegistrer;
    BancoDados db = new BancoDados(this);

    /* public void telaCadastro(View view){
        Intent intent = new Intent(getApplicationContext(), CadastroAluno.class);
        startActivity(intent);
    } */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txSenha = findViewById(R.id.txSenha);
        txMatricula = findViewById(R.id.txMatricula);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegistrer = findViewById(R.id.btnRegistrer);


        /* db.addAlunos(new com.example.questionario.Aluno("Matheus","201908008083","mat@outllok.com","123456")); */
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txMatricula.getText().toString().equals("") || (txSenha.getText().toString().equals(""))) {

                    AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
                    dialogo.setMessage("Matricula ou Senha invalido");
                    dialogo.setCancelable(false);
                    dialogo.setNeutralButton("OK", null);
                    dialogo.show();

                } else {
                    btEnviarQActivity();

                }

            }

            private void btEnviarQActivity() {
                startActivity(new Intent(MainActivity.this, Tela2.class));
            }

        });
        btnRegistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnRegistrerActivity();
            }

            private void btnRegistrerActivity() {
                startActivity(new Intent(MainActivity.this, CadastroAluno.class));
            }
        });
    }

    private Toast toast;
    private long lastBackPressTime = 0;

    @Override
    public void onBackPressed() {
        if (this.lastBackPressTime < System.currentTimeMillis() - 6000) {
            toast = Toast.makeText(this, "Pressione o Botão Voltar novamente para fechar o Aplicativo.", 6000);
            toast.show();
            this.lastBackPressTime = System.currentTimeMillis();
        } else {
            if (toast != null) {
                toast.cancel();
            }
            super.onBackPressed();
        }
    }

}
