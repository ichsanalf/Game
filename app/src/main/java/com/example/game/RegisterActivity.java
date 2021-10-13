package com.example.game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    Button btnRegister;
    EditText edUser, edPhone, edEmail, edPass, edFullname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnRegister = findViewById(R.id.btnRegister);
        edUser = findViewById(R.id.edUser);
        edPhone = findViewById(R.id.edPhone);
        edEmail = findViewById(R.id.edEmail);
        edPass = findViewById(R.id.edPass);
        edFullname = findViewById(R.id.edFullname);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiClient.getService().registerUsers(new RegisterRequest(edUser.getText().toString(),edPass.getText().toString(),edFullname.getText().toString(),edEmail.getText().toString(),edPhone.getText().toString())).enqueue(new Callback<RegisterResponse>() {
                    @Override
                    public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                        Log.d("TAG", "onResponse: ");
                    }

                    @Override
                    public void onFailure(Call<RegisterResponse> call, Throwable t) {
                        Log.d("TAG", "onFailure: ");
                    }
                });
            }
        });
    }
}