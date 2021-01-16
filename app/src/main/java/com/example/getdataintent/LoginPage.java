package com.example.getdataintent;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginPage extends AppCompatActivity {
    private EditText usernameEdittext,passwordEdittext;
    private Button loginbutton;
    private TextView textView;
    private int counter= 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        textView=findViewById(R.id.textviewid);
        usernameEdittext=findViewById(R.id.usernameid);
        passwordEdittext=findViewById(R.id.passwordid);
        loginbutton=findViewById(R.id.loginbuttonid);
        textView.setText("attempts remaining: 3");

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=usernameEdittext.getText().toString();
                String password=passwordEdittext.getText().toString();

                if (username.equals("admin") && password.equals("1234"))
                {
                    Intent intent = new Intent(LoginPage.this,MainActivity.class);
                    startActivity(intent);
                }
                else{
                    counter--;
                    textView.setText("attempts remaining: "+counter);
                    if (counter==0){
                        loginbutton.setEnabled(false);
                    }
                }
            }
        });
    }
    @Override
    public void onBackPressed(){
        AlertDialog.Builder alertDialogBuilder;
        alertDialogBuilder = new AlertDialog.Builder(LoginPage.this);

        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setIcon(R.drawable.question);
        alertDialogBuilder.setMessage(R.string.messagetext);
        alertDialogBuilder.setTitle(R.string.titleitext);

        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        alertDialogBuilder.setNeutralButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
