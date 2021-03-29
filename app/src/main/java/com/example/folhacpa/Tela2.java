package com.example.folhacpa;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Tela2 extends AppCompatActivity {

    private Button btEnviarQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        btEnviarQ = (Button) findViewById(R.id.btEnviarQ);
        btEnviarQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int vl = 0;
                RadioGroup RdGrupo1 = (RadioGroup) findViewById(R.id.RdGrupo1);
                RadioGroup RdGrupo2 = (RadioGroup) findViewById(R.id.RdGrupo2);


                int op = RdGrupo1.getCheckedRadioButtonId() + RdGrupo2.getCheckedRadioButtonId();
                if(op==R.id.rd1+R.id.Rd1){
                    vl = 1;
                }else if(op==R.id.rd2+R.id.Rd2){
                    vl = 1;
                }else if (op==R.id.rd3){
                    vl = 1;
                }else if (op==R.id.rd4){
                    vl = 2;
                }else if(op==R.id.rd5){
                    vl = 2;
                }else if (op==R.id.rd6){
                    vl = 2;
                }else if (op==R.id.rd7){
                    vl = 3;
                }else if (op==R.id.rd8){
                    vl = 3;
                }else if (op==R.id.rd9){
                    vl = 5;
                }else if (op==R.id.rd10){
                    vl = 5;
                }else {

                }

                btEnviarQActivity();
                AlertDialog.Builder dialogo = new
                        AlertDialog.Builder(Tela2.this);
                dialogo.setTitle("Questionario Finalizado");
                dialogo.setMessage("SUA AV E:" + op+op );
                dialogo.setPositiveButton("finalizar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(Tela2.this, com.example.folhacpa.MainActivity.class));
                    }
                });

                dialogo.show();


            }



            private void btEnviarQActivity() {

            }
        });
    }
}