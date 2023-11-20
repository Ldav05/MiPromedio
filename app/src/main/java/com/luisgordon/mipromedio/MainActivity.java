package com.luisgordon.mipromedio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public EditText campo_nota1;
    public EditText campo_nota2;
    public EditText campo_nota3;
    public EditText campo_nota4;
    public EditText campo_nota5;
    public EditText campo_credito1;
    public EditText campo_credito2;
    public EditText campo_credito3;
    public EditText campo_credito4;
    public EditText campo_credito5;
    public TextView campo_resultado;
    public Button btn_calcular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campo_nota1 = findViewById(R.id.campo_nota1);
        campo_nota2 = findViewById(R.id.campo_nota2);
        campo_nota3 = findViewById(R.id.campo_nota3);
        campo_nota4 = findViewById(R.id.campo_nota4);
        campo_nota5 = findViewById(R.id.campo_nota5);
        campo_credito1 = findViewById(R.id.campo_credito1);
        campo_credito2 = findViewById(R.id.campo_credito2);
        campo_credito3 = findViewById(R.id.campo_credito3);
        campo_credito4 = findViewById(R.id.campo_credito4);
        campo_credito5 = findViewById(R.id.campo_credito5);
        campo_resultado = findViewById(R.id.campo_resultado);
        btn_calcular = findViewById(R.id.btn_calcular);

        btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcular();
            }
        });

    }
    public void calcular(){
        boolean validado = true;
        String nota1 = campo_nota1.getText().toString();
        String nota2 = campo_nota2.getText().toString();
        String nota3 = campo_nota3.getText().toString();
        String nota4 = campo_nota4.getText().toString();
        String nota5 = campo_nota5.getText().toString();
        String credito1 = campo_credito1.getText().toString();
        String credito2 = campo_credito2.getText().toString();
        String credito3 = campo_credito3.getText().toString();
        String credito4 = campo_credito4.getText().toString();
        String credito5 = campo_credito5.getText().toString();

        if(nota1.isEmpty() || nota2.isEmpty() || nota3.isEmpty() || nota4.isEmpty() || nota5.isEmpty() || credito1.isEmpty() || credito2.isEmpty() || credito3.isEmpty() || credito4.isEmpty() || credito5.isEmpty()){
            campo_resultado.setText("Complete todos los campos");
        }else if(Double.parseDouble(nota1) > 5 || Double.parseDouble(nota2) > 5 || Double.parseDouble(nota3) > 5 || Double.parseDouble(nota4) > 5 || Double.parseDouble(nota5) > 5){
            campo_resultado.setText("Ingrese una nota valida");
        }else if(Double.parseDouble(credito1) > 7 || Double.parseDouble(credito2) > 7 || Double.parseDouble(credito3) > 7 || Double.parseDouble(credito4) > 7 || Double.parseDouble(credito5) > 7){
            campo_resultado.setText("El número maximo de creditos es 7");
        }else{
            Double total_creditos = Double.parseDouble(credito1) + Double.parseDouble(credito2) + Double.parseDouble(credito3) + Double.parseDouble(credito4) + Double.parseDouble(credito5);
            Double total_notas = (Double.parseDouble(credito1)*Double.parseDouble(nota1))+(Double.parseDouble(credito2)*Double.parseDouble(nota2))+(Double.parseDouble(credito3)*Double.parseDouble(nota3))+(Double.parseDouble(credito4)*Double.parseDouble(nota4))+(Double.parseDouble(credito5)*Double.parseDouble(nota5));
            Double resultado = total_notas/total_creditos;
            campo_resultado.setText("El promedio final es: " +resultado);
        }
    }
}