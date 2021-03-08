package com.example.teambuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class TeamActivity extends AppCompatActivity {

    ListView team1;
    ListView team2;


    ArrayList<String> str1 = new ArrayList<>();
    ArrayList<String> str2 = new ArrayList<>();
    ArrayList<String> totalString = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        team1 = (ListView)(findViewById(R.id.team1));
        team2 = (ListView)(findViewById(R.id.team2));

        Intent i = getIntent();
        String[] myArray = i.getStringArrayExtra("array");


        int l = myArray.length;

        for(int ind=0;ind<l;ind++)
        {
            if(ind<l/2)
            {
                str1.add(myArray[ind]);
            }
            else
            {
                str2.add(myArray[ind]);
            }
            totalString.add(myArray[ind]);
        }

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(TeamActivity.this, R.layout.listcolor,str1);
        team1.setAdapter(adapter1);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(TeamActivity.this, R.layout.listcolor,str2);
        team2.setAdapter(adapter2);


    }
}