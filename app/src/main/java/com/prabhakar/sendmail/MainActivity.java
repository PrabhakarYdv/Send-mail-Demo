package com.prabhakar.sendmail;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button send_btn;
    private EditText toEmail;
    private EditText ccEmail;
    private EditText message;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toEmail = findViewById(R.id.to_email);
        ccEmail = findViewById(R.id.cc_email);
        message = findViewById(R.id.message);
        send_btn = findViewById(R.id.send_btn);
        send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(MainActivity.this, "message has been sent", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, message.getText().toString());
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{toEmail.getText().toString()});
                intent.putExtra(intent.EXTRA_CC, new String[]{ccEmail.getText().toString()});
                intent.setType("message/rcf822");
                startActivity(intent);

            }
        });
    }
}
