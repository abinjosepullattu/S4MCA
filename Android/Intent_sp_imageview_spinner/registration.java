package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class registration extends AppCompatActivity implements View.OnClickListener {

    EditText name,phn;
    CheckBox sing,dance,draw,read,movie,music;
    Button reg;
    RadioGroup rg;
    RadioButton m,f,o;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registration);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        name = (EditText) findViewById(R.id.name);
        phn = (EditText) findViewById(R.id.phone);
        sing = (CheckBox) findViewById(R.id.sing);
        dance = (CheckBox) findViewById(R.id.dance);
        draw = (CheckBox) findViewById(R.id.draw);
        read = (CheckBox) findViewById(R.id.read);
        movie = (CheckBox) findViewById(R.id.movie);
        music = (CheckBox) findViewById(R.id.music);
        rg = (RadioGroup)findViewById(R.id.gender);


        reg = (Button) findViewById(R.id.regbtn);

        reg.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.regbtn){

            String n = name.getText().toString();
            int p = Integer.parseInt(phn.getText().toString());

            StringBuilder interest = new StringBuilder();


            if(sing.isChecked())
                interest.append("Singing").append("\n\n");
            if(dance.isChecked())
                interest.append("Dancing").append("\n\n");
            if(draw.isChecked())
                interest.append("Drawing").append("\n\n");
            if(read.isChecked())
                interest.append("Reading").append("\n\n");
            if(movie.isChecked())
                interest.append("Movies").append("\n\n");
            if(music.isChecked())
                interest.append("Music").append("\n\n");

            RadioButton genderSelected = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
            String gender = genderSelected.getText().toString();

            SharedPreferences sp = getSharedPreferences("MyPref",MODE_PRIVATE);

            SharedPreferences.Editor ed = sp.edit();
            ed.putString("Name",n);
            ed.putString("Phone",String.valueOf(p));

            ed.putString("Interest", String.valueOf(interest));

            ed.putString("Gender", gender);

            ed.apply();

            Intent i2  = new Intent(this,details.class);
            startActivity(i2);

        }
    }
}