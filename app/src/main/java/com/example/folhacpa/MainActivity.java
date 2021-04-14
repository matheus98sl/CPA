package com.example.folhacpa;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.folhacpa.DataBase.DadosOpenHelper;
import com.google.android.material.snackbar.Snackbar;


public class MainActivity extends AppCompatActivity {

    private Button btnLogin;
    private EditText txMatricula;
    private EditText txSenha;
    private Button btnRegistrer;
    private ConstraintLayout layoutContentMain;
    private SQLiteDatabase conexao;
    private DadosOpenHelper dadosOpenHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txSenha = findViewById(R.id.txSenha);
        txMatricula = findViewById(R.id.txMatricula);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegistrer = findViewById(R.id.btnRegistrer);

        layoutContentMain = (ConstraintLayout) findViewById(R.id.layoutContentMain);
        criarConexao();


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

    /* TESTE DE CONEXAO COM O BANDO DE DADOS */
    private void criarConexao() {

        try {

            dadosOpenHelper = new DadosOpenHelper(this);
            conexao = dadosOpenHelper.getWritableDatabase();

            Snackbar.make(layoutContentMain, " Conexao criada com sucesso!", Snackbar.LENGTH_SHORT)
                    .setAction("OK", null).show();

        } catch (SQLException ex) {

            AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
            dialogo.setTitle("Erro");
            dialogo.setMessage(ex.getMessage());
            dialogo.setNeutralButton("OK", null);
            dialogo.show();


        }


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
