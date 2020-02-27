package com.bignerdranch.android.sms;

import androidx.appcompat.app.AppCompatActivity;
//import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //
    }/*
    //Открытие СМС скопировав текст и данные для отправки
    public void smsSend(View v) {
        EditText number=(EditText)findViewById(R.id.number);
        EditText message=(EditText)findViewById(R.id.message);
        String toSms="smsto:"+number.getText().toString();
        String messageText= message.getText().toString();
        Intent sms=new Intent(Intent.ACTION_SENDTO, Uri.parse(toSms));

        sms.putExtra("sms_body", messageText);
        startActivity(sms);
    }*/
    //Отправка СМС по номеру
    public void smsSend(View v) {

        EditText number=(EditText)findViewById(R.id.number);
        EditText message=(EditText)findViewById(R.id.message);

        String numberText = number.getText().toString();
        String messageText= message.getText().toString();

        SmsManager.getDefault()
                .sendTextMessage(numberText, null, messageText.toString(), null, null);
        Toast toast = Toast.makeText(this, "Отправлено!",Toast.LENGTH_LONG);
        toast.show();
    }
    //Использование пункта меню справа вверху
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        TextView headerView = (TextView) findViewById(R.id.header);
        if(!item.isChecked()) item.setChecked(true);
        switch(id){
            case R.id.action_settings :
                headerView.setText("Настройки");
                return true;
            case R.id.open_settings:
                headerView.setText("Открыть");
                return true;
            case R.id.save_settings:
                headerView.setText("Сохранить");
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}