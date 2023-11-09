package com.example.prueba1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Context;

public class SecondActivity extends MainActivity
{

    private EditText editText1;
    private EditText editText2;
    private EditText editText3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);

        SharedPreferences sharedPreferences = getSharedPreferences("preferencia", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String dato1 = sharedPreferences.getString("datoNombre", "Nombre");
        String dato2 = sharedPreferences.getString("datoRUT", "Rut");
        String dato3 = sharedPreferences.getString("datoEdad", "Edad");
        editText1.setText(dato1);
        editText2.setText(dato2);
        editText3.setText(dato3);

    }

    public void guardarDatos(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("preferencia", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String texto1 = editText1.getText().toString();
        String texto2 = editText2.getText().toString();
        String texto3 = editText3.getText().toString();

        editor.putString("datoNombre", texto1);
        editor.putString("datoRUT", texto2);
        editor.putString("datoEdad", texto3);

        editor.apply();

        if (!texto1.isEmpty() && !texto2.isEmpty() && !texto3.isEmpty()) {

            editText1.setText("");
            editText2.setText("");
            editText3.setText("");
            Toast.makeText(getApplicationContext(), "Consola agregada.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Todos los campos son obligatorios.", Toast.LENGTH_SHORT).show();
        }
    }
}
