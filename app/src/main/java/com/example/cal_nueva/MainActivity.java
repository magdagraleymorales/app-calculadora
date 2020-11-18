package com.example.cal_nueva;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    TextView v, v1;
    DecimalFormat format = new DecimalFormat("0.##");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        v = (TextView) findViewById(R.id.operacion);
        v1 = (TextView) findViewById(R.id.resultado);
    }

    public void un (View view){
        ingresd('1');
    }
    public void dos (View view){
        ingresd('2');
    }
    public void tres (View view){
        ingresd('3');
    }
    public void cuatro (View view){
        ingresd('4');
    }
    public void cinco (View view){
        ingresd('5');
    }
    public void seis (View view){
        ingresd('6');
    }
    public void siete (View view){
        ingresd('7');
    }
    public void ocho (View view){
        ingresd('8');
    }
    public void nueve (View view){
        ingresd('9');
    }
    public void cero (View view){
        ingresd('0');
    }
    public void mas (View view){
        ingresm('+');
    }
    public void menos (View view){
        ingresm('-');
    }
    public void mul (View view){
        ingresm('x');
    }
    public void div (View view){
        ingresm('/');
    }
    public void punt (View view){
        ingresd('.');
    }
    public void del (View view){
        Button click = (Button) findViewById(R.id.eliminar);
        click.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) { shortclick(); }
        });
        click.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View v) { longclick(); return true; }
        });
    }

    public void shortclick() {
        try {

            String val = v.getText().toString();
            String res = val.substring(0, val.length() - 1);
            v.setText(res);
        }catch (Exception ex){

        }
    }

    public void longclick() {
        v.setText("");
        v1.setText("");
    }

    public void ingresd(char valor) {
        String val = v.getText().toString();
        if(val.isEmpty()){
            v.setText(val+valor);
        }
        else{
            if(valor == '.'){
                char aux = val.charAt(val.length()-1);
                if(aux == '.'){
                    v.setText(val);
                }
                else{
                    v.setText(val+valor);
                }
            }
            else{
                v.setText(val+valor);
            }
        }
    }

    public void ingresm (char valor){
        String val = v.getText().toString();
        if(val.isEmpty()){
            v.setText(val);
        }
        else{
            char aux = val.charAt(val.length()-1);
            if(!Character.isDigit(aux)){
                v.setText(val);
            }
            if(Character.isDigit(aux)){
                v.setText(val+valor);
            }
        }
    }

    public void resul (View view){
        String val = v.getText().toString();
        char [] aux = val.toCharArray();
        for(int i=0; i<val.length();i++){
            if(aux[i] == '+'){
                double res;
                res= Double.parseDouble(String.valueOf(aux[i-1]))+Double.parseDouble(String.valueOf(aux[i+1]));
                v1.setText(String.valueOf(format.format((res))));
            }
            if(aux[i] == '-'){
                double res;
                res= Double.parseDouble(String.valueOf(aux[i-1]))-Double.parseDouble(String.valueOf(aux[i+1]));
                v1.setText(String.valueOf(format.format((res))));
            }
            if(aux[i] == 'x'){
                double res;
                res= Double.parseDouble(String.valueOf(aux[i-1]))*Double.parseDouble(String.valueOf(aux[i+1]));
                v1.setText(String.valueOf(format.format((res))));
            }
            if(aux[i] == '/'){
                double res;
                res= Double.parseDouble(String.valueOf(aux[i-1]))/Double.parseDouble(String.valueOf(aux[i+1]));
                v1.setText(String.valueOf(format.format((res))));
            }
        }

    }


}
