package com.example.sharedpreferences01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AnotherActivity extends AppCompatActivity {

    TextView mNameTv, mMailTv;
    Button mLogoutBtn;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);

        mNameTv=findViewById(R.id.nameTv);
        mMailTv=findViewById(R.id.mailTv);
        mLogoutBtn=findViewById(R.id.logout);

        preferences = getSharedPreferences("SHARED_PREF",MODE_PRIVATE);

        String name =preferences.getString("NAME","");
        mNameTv.setText(name);
        String mail =preferences.getString("MAIL","");
        mMailTv.setText(mail);

        mLogoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor=preferences.edit();
                editor.clear();
                editor.apply();

                Intent intent=new Intent(AnotherActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}