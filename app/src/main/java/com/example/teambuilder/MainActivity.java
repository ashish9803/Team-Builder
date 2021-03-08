package com.example.teambuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button go;
    ArrayList<String> addArray = new ArrayList<>();
    EditText txt;
    ListView show;
    Button shuffle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        txt = (EditText)(findViewById(R.id.name));
        show = (ListView)(findViewById(R.id.listview));
        go = (Button)(findViewById(R.id.go));
        shuffle = (Button)(findViewById(R.id.shuffle));

        ArrayList<String> strArray = new ArrayList<>();

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getInput = txt.getText().toString();

                if(addArray.contains(getInput))
                {
                    Toast.makeText(getBaseContext(),"Item Already Added",Toast.LENGTH_LONG).show();
                }
                else if(getInput==null || getInput.trim()=="")
                {
                    Toast.makeText(getBaseContext(),"Input Field Is Empty",Toast.LENGTH_LONG).show();
                }
                else
                {
                    addArray.add(getInput);
                    strArray.add(getInput);
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, R.layout.listcolor,addArray);
                    show.setAdapter(adapter);
                    ((EditText)findViewById(R.id.name)).setText("");
                }
            }
        });

        shuffle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int l = strArray.size();

                for(int i=0;i<l;i++)
                {
                    int s = i+(int)(Math.random()*(l-i));
                    Object temp = strArray.get(s);
                    strArray.set(s, strArray.get(i));
                    strArray.set(i, (String) temp);
                }

                String[] str = new String[l];

                for(int i=0;i<l;i++)
                {
                    String x=strArray.get(i);
                    str[i]=x;
                }

                Intent i = new Intent(MainActivity.this,TeamActivity.class);
                i.putExtra("array",str);
                startActivity(i);
            }
        });

    }
}