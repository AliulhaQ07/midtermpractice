package com.example.midtermpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    Button Activitybtn, loginbtn, signupbtn;

    EditText etname, etpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();

        String un;
        String pass;

        SharedPreferences sPrefs = getSharedPreferences("USERDATA" , MODE_PRIVATE);
        un = sPrefs.getString("un", "");
        pass = sPrefs.getString("pass", "");

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                String username = etname.getText().toString().trim();
                String password = etpassword.getText().toString().trim();

                boolean flag = true;

                if (username.isEmpty())
                {
                    Toast.makeText(Login.this, "TOAST, USERNAME CANNOT BE EMPTY", Toast.LENGTH_SHORT).show();
                   etname.setError("PLEASE ENTER USERNAME");
                   flag = false;
                }

                if (password.isEmpty())
                {
                    Toast.makeText(Login.this, "TOAST, PASSWORD CANNOT BE EMTPY", Toast.LENGTH_SHORT).show();
                    etpassword.setError("PASSWORD CANNOT BE EMPTY");
                    flag = false;
                }

                if (flag==true)
                {
                    if (un.isEmpty())
                    {
                        Toast.makeText(Login.this, "PLEASE CREATE ACCOUNT FIRST", Toast.LENGTH_SHORT).show();
                    }
                    if (username.equalsIgnoreCase(un) && password.equalsIgnoreCase(pass))
                    {
                       Intent intent = new Intent(Login.this, MainActivity.class);
                       intent.putExtra("un" , un);
                       startActivity(intent);
                       finish();
                    }
                    else {
                        Toast.makeText(Login.this, "USERNAME OR PASSWORD INCORRECT", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });

        Activitybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, MainActivity.class));
                finish();
            }
        });

        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, signup.class));
                finish();
            }
        });

    }

    public void init()
    {
     Activitybtn = findViewById(R.id.Activitybtn);
     loginbtn = findViewById(R.id.btnlogin);
     signupbtn = findViewById(R.id.btnsignup);
     etname = findViewById(R.id.etname);
     etpassword = findViewById(R.id.etpassword);

    }
}

