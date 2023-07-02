package com.example.midtermpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity {

    Button btnlogin, btnsignup;
    EditText etname, etpassword, etcpasswrod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        init();

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = etname.getText().toString().trim();
                String password = etpassword.getText().toString().trim();
                String confirmpassword = etcpasswrod.getText().toString().trim();

                boolean flag = true;

                if (username.isEmpty())
                {
                    etname.setError("CANNOT BE EMPTY");
                    flag = false;
                }

                if (password.isEmpty())
                {
                    etpassword.setError("CANNOT BE EMPTY");
                    flag = false;
                }

                if (confirmpassword.isEmpty())
                {
                    etcpasswrod.setError("CANNOT BE EMPTY");
                    flag = false;
                }

                if (flag)
                {
                    if (!password.equals(confirmpassword))
                    {
                        etcpasswrod.setError("mismatch password");
                    }
                    else
                    {
                        SharedPreferences sPrefs = getSharedPreferences("USERDATA" , MODE_PRIVATE);
                        SharedPreferences.Editor editor = sPrefs.edit();

                        editor.putString("un", username);
                        editor.putString("pass", password);
                        editor.commit();
                        Toast.makeText(signup.this, "ACCOUNT CREATED SUCCESFULLY", Toast.LENGTH_SHORT).show();
                        redirect();
                    }
                }

                btnlogin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view)
                    {
                        startActivity(new Intent(signup.this, Login.class));
                        finish();
                    }
                });
            }
        });


    }

    public void redirect()
    {
        startActivity(new Intent(signup.this, Login.class));
        finish();
    }
    public void init()
    {
        btnlogin = findViewById(R.id.btnlogin);
        btnsignup = findViewById(R.id.btnsignup);
        etname = findViewById(R.id.etname);
        etpassword = findViewById(R.id.etpassword);
        etcpasswrod = findViewById(R.id.etcpassword);
    }

}