package com.example.codecore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText edUserName,edEmail, edPassword,edConfirm;
    Button btn;
    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edUserName=findViewById(R.id.editTextRegUserName);
        edPassword=findViewById(R.id.editTextRegPassword);
        edConfirm=findViewById(R.id.editTextRegConPassword);
        edEmail=findViewById(R.id.editTextRegEmail);

        btn=findViewById(R.id.buttonSignup);
        tv=findViewById(R.id.textViewExistUser);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edUserName.getText().toString();
                String password = edPassword.getText().toString();
                String confirm = edConfirm.getText().toString();
                String Email = edEmail.getText().toString();
                Database db = new Database(getApplicationContext(),"codecore",null,1);

                if(username.length()==0 || password.length()==0 || confirm.length() == 0 || Email.length() ==0 ){
                    Toast.makeText(getApplicationContext(),"plese fill the details",Toast.LENGTH_SHORT).show();
                }
                else{
                    if(password.compareTo(confirm)==0){
                        if(isvalid(password))
                        {
                            db.register(username,Email,password);
                            Toast.makeText(getApplicationContext(),"record is submited",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"password length should be at least 8 character, having digit, symbol",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Both password is not same",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }
    public static boolean isvalid(String pass){
        int f1=0,f2=0,f3=0;
        if(pass.length()<8){
            return false;
        }
        else{
            for(int p=0; p<pass.length();p++){
                if(Character.isLetter(pass.charAt(p))){
                    f1=1;
                }
            }
            for(int r=0;r<pass.length();r++){
                if(Character.isDigit(pass.charAt(r))){
                    f2=1;
                }
            }
            for(int s=0;s<pass.length();s++){
                char c=pass.charAt(s);
                if(c>=33 && c<= 46 || c==64){
                    f3=1;
                }
            }
            if(f1==1 && f2==1 && f3==1)
                return  true;
            return false;
        }


    }

}