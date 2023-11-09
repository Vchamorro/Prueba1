package com.example.prueba1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.app.Activity;
import java.util.List;
import java.util.ArrayList;
import android.widget.Toast;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


public class MainActivity extends AppCompatActivity {
    private EditText editText1;
    private EditText editText2;
    private ListView listView;
    private ArrayAdapter<String> adapter;

    private List<String> itemList = new ArrayList<String>();
    private Button botonNavegar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        listView = findViewById(R.id.listView);


        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,itemList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = itemList.get(position);
                Toast.makeText(getApplicationContext(), "Texto 1: " + item, Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void agregarElemento(View view) {
        String texto1 = editText1.getText().toString();
        String texto2 = editText2.getText().toString();

        if (!texto1.isEmpty() && !texto2.isEmpty()) {
            itemList.add(texto1);
            adapter.notifyDataSetChanged();
            editText1.setText("");
            editText2.setText("");
            Toast.makeText(getApplicationContext(), "Consola agregada.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Todos los campos son obligatorios.", Toast.LENGTH_SHORT).show();
        }
    }
}

