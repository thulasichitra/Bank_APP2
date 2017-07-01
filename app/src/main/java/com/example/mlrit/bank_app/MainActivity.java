package com.example.mlrit.bank_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText et1,et2;
    Button b1,b2,b3,b4,b5;
    TextView textView;
    long balance=200000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);

        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);
        b4=(Button)findViewById(R.id.b4);
        b5=(Button)findViewById(R.id.b5);

        textView=(TextView)findViewById(R.id.textView);

        et2.setVisibility(View.INVISIBLE);

        b2.setVisibility(View.INVISIBLE);
        b3.setVisibility(View.INVISIBLE);
        b4.setVisibility(View.INVISIBLE);
        b5.setVisibility(View.INVISIBLE);

        textView.setVisibility(View.INVISIBLE);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String Pin = et1.getText().toString();
                et1.setText("");

                if (Pin.isEmpty()) {
                    et1.setError("Empty");
                }
                else {
                    int pin = Integer.parseInt(Pin);
                    if (pin == 1234) {
                        et2.setVisibility(View.VISIBLE);

                        b2.setVisibility(View.VISIBLE);
                        b3.setVisibility(View.VISIBLE);
                        b4.setVisibility(View.VISIBLE);
                        b5.setVisibility(View.VISIBLE);

                        textView.setVisibility(View.VISIBLE);

                        et1.setVisibility(View.INVISIBLE);
                        b1.setVisibility(View.INVISIBLE);


                    } else {
                        et1.setError("Invalid pin");
                    }
                }
            }

        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                et2.setVisibility(View.INVISIBLE);
                b2.setVisibility(View.INVISIBLE);
                b3.setVisibility(View.INVISIBLE);
                b4.setVisibility(View.INVISIBLE);
                b5.setVisibility(View.INVISIBLE);

                b1.setVisibility(View.VISIBLE);
                et1.setVisibility(View.VISIBLE);

            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String s2=et2.getText().toString();

                if(s2.isEmpty())
                {
                    et2.setError("Empty");
                }

                else
                {
                    long amount=Long.parseLong(s2);
                    balance=balance+amount;
                    textView.setText(""+balance);
                   // SmsManager sms=SmsManager.getDefault();
                   // sms.sendTextMessage("9908274630",null,"you have deposited",+balance);
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String s3=et2.getText().toString();
                long amount=Long.parseLong(s3);
                if(amount>balance)
                {
                    textView.setText("NO funds available");
                }

                else if(amount%100==0)
                {
                    balance=balance-amount;
                    textView.setText(""+balance);
                }
                else
                {
                    textView.setText("Invalid entry");
                }

            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                textView.setText(""+balance);
            }
        });
    }
}
