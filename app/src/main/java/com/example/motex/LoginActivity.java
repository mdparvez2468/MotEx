package com.example.motex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Log In");
        editText = findViewById(R.id.phoneNumberET);
    }

    public void sendCode(View view) {
        String phone = editText.getText().toString().trim();
        if (phone.isEmpty()){
            editText.setError("Enter Your Phone Number Here");
        }else if (phone.length()!=11){
            editText.setError("Your Phone Number Have To 11 Digit");
        }else {
            Intent intent = new Intent(LoginActivity.this,NumberVerifyActivity.class);
            intent.putExtra("phone",phone);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }
}