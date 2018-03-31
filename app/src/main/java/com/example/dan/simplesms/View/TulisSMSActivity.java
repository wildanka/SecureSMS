package com.example.dan.simplesms.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.dan.simplesms.R;

public class TulisSMSActivity extends AppCompatActivity {
    //Initialize the layout
    EditText eMessage, eContactNumber;
    Button eBtnSendSMS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tulis_sms);
        eMessage = (EditText) findViewById(R.id.edit_message);
        eContactNumber = (EditText) findViewById(R.id.edit_contact_number);
        eBtnSendSMS = (Button) findViewById(R.id.btn_sendSMS);
        eBtnSendSMS.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        sendSMS();
                    }
                }
        );
    }

    private void sendSMS(){
        SmsManager smsMgr = SmsManager.getDefault();
        String sendTo = eContactNumber.getText().toString();
        String msg = eMessage.getText().toString();
        smsMgr.sendTextMessage(sendTo,null,msg,null,null);
    }
}
