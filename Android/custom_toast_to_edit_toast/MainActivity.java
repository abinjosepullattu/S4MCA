package com.example.cus_toast;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText email,pass;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        email = (EditText)findViewById(R.id.email);
        pass = (EditText)findViewById(R.id.pass);
        login = (Button)findViewById(R.id.logbtn);

        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.logbtn){
            if(email.getText().toString().equals("ni") && pass.getText().toString().equals("12")){
                //Toast.makeText(this,"Login Successful",Toast.LENGTH_SHORT).show();
                Toast t1 = Toast.makeText(this,"",Toast.LENGTH_SHORT);

                LayoutInflater lin = getLayoutInflater();
                View appear = lin.inflate(R.layout.toast_layout,(ViewGroup)findViewById(R.id.ll1));
                t1.setGravity(Gravity.TOP,10,100);
                t1.setView(appear);
                t1.show();
            }
            else
                Toast.makeText(this,"Login Failed",Toast.LENGTH_SHORT).show();
        }
    }
}