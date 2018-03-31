package com.example.dan.simplesms;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.dan.simplesms.View.TulisSMSActivity;

public class MainActivity extends AppCompatActivity {

    Context mContext = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //intent button to start write a message
        Button startButton = (Button) findViewById(R.id.btn_start_writing);
        startButton.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intentWriteMessage = new Intent(view.getContext(), TulisSMSActivity.class);
                        startActivity(intentWriteMessage);
                    }
                }
        );


        //create button for calling
        Button callButton = (Button) findViewById(R.id.btn_call);
        callButton.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //get the phone number
                        EditText phoneNumberEditText = (EditText) findViewById(R.id.editText_phone_number);
                        String phoneNumber = phoneNumberEditText.getText().toString();

                        //intent call 081289071083
                        Intent callIntent = new Intent(Intent.ACTION_CALL);
                        callIntent.setData(Uri.parse("tel:"+phoneNumber));
                        if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                            return;
                        }
                        startActivity(callIntent);
                    }
                }
        );

    }
}
