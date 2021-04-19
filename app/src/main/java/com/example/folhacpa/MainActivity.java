package com.example.folhacpa;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private Button btnLogin;
    private EditText txMatricula;
    private EditText txSenha;
    private Button btnRegistrer;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DBHelper(this);
        txSenha = findViewById(R.id.txSenha);
        txMatricula = findViewById(R.id.txMatricula);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegistrer = findViewById(R.id.btnRegistrer);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String matricula = txMatricula.getText().toString();
                String senha = txSenha.getText().toString();
                if(matricula.equals("")){
                    Toast.makeText(MainActivity.this,"Matricula nao inserida", Toast.LENGTH_SHORT).show();
                }
                else if (senha.equals("")){
                    Toast.makeText(MainActivity.this,"Senha nao inserida", Toast.LENGTH_SHORT).show();
                } else {
                    // OK
                    String res = db.ValidarLogin(matricula,senha);
                    if(res.equals("OK")){
                        Toast.makeText(MainActivity.this,"Login ok", Toast.LENGTH_SHORT).show();
                        startActivity((new Intent(MainActivity.this, Tela2.class)));
                    }else {
                        Toast.makeText(MainActivity.this,"Login errado", Toast.LENGTH_SHORT).show();

                    }
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