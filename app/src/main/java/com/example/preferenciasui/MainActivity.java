package com.example.preferenciasui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private RadioButton rb01,rb02,rb03;
    private EditText txtn;
    private Button btn1;
    private TextView tv;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "text";
    public static final String SWITCH1 = "switch1";
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtn = (EditText) findViewById(R.id.txtnombre);
        rb01 = (RadioButton) findViewById(R.id.rb01);
        rb02 = (RadioButton) findViewById(R.id.rb02);
        rb03 = (RadioButton) findViewById(R.id.rb03);
        btn1 = (Button) findViewById(R.id.btnaceptar);
        tv = (TextView) findViewById(R.id.nemsaje);
        sp = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);

        mostrar();
    }
    public void operar(View view){
        String nombre = txtn.getText().toString();
        if(rb01.isChecked()){
            guardarNombre(nombre);
        }
        if(rb02.isChecked()){
            mostrar();
        }
        if(rb03.isChecked()){
            clear();
        }
    }
    public void guardarNombre(String nombre){
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(TEXT, nombre);
        editor.apply();

        Toast.makeText(this, "Nombre Guardado...", Toast.LENGTH_SHORT).show();
    }
    public void clear(){
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(TEXT);
        editor.clear();
        editor.apply();
    }
    public void mostrar(){
        tv.setText(sp.getString(TEXT,"null..."));
    }
}
