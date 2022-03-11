package com.example.sharedpreferences01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity<sharedPreferences> extends AppCompatActivity {

    EditText mNameEt, mMailEt;
    CheckBox mRemember;
    Button mBtn;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNameEt=findViewById(R.id.nameEt);
        mMailEt=findViewById(R.id.mailEt);
        mRemember=findViewById(R.id.checkBox);
        mBtn=findViewById(R.id.login);

        sharedPreferences = getSharedPreferences("SHARED_PREF", MODE_PRIVATE);

        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=mNameEt.getText().toString();
                String mail=mMailEt.getText().toString();
                boolean checked =mRemember.isChecked();
                boolean isRemembered=false;

                SharedPreferences.Editor editor=sharedPreferences.edit();
                isRemembered =sharedPreferences.getBoolean("CHECKBOX",false);

                if(isRemembered){

                    Intent intent=new Intent(MainActivity.this,AnotherActivity.class);
                    startActivity(intent);
                    finish();

                }

                editor.putString("NAME",name);
                editor.putString("MAIL", mail);
                editor.putBoolean("CHECKBOX", checked);
                editor.apply();

                Toast.makeText(MainActivity.this, "Información Guardada!", Toast.LENGTH_SHORT).show();


            }
        });


    }
}