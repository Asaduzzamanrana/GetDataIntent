package com.example.getdataintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {
    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        editText = findViewById(R.id.edittextid);
        button = findViewById(R.id.button2id);
         button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String value = editText.getText().toString();
                 Intent intent = new Intent(SecondActivity.this,MainActivity.class);
                 intent.putExtra("key",value);
                 setResult(1,intent);
                 finish();
             }
         });
    }
}
