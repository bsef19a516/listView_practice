package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity<arrayAdapter> extends AppCompatActivity {
    ArrayList<String> friendsArrayList =new ArrayList<String>();
    ListView listView;
    EditText name;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        friendsArrayList.add("Fizza");
        friendsArrayList.add("Amna");
        friendsArrayList.add("Iffah");
        friendsArrayList.add("Rida");
        friendsArrayList.add("Alishba");

        ArrayAdapter arrayAdapter=new ArrayAdapter<String >(this, android.R.layout.simple_list_item_1, friendsArrayList);

        listView=(ListView) findViewById(R.id.listView);
        name= findViewById(R.id.name);
        button= findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Editable temp=name.getText();
                friendsArrayList.add(temp.toString());
                arrayAdapter.notifyDataSetChanged();
            }
        });

        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("You Selected", friendsArrayList.get(i));
            }
        });
    }
}