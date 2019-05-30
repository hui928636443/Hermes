package com.tianyi.hermeseventbus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.tianyi.hermeseventbus.core.Hermes;


public class MainActivity extends AppCompatActivity {

    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Hermes.getDefault().init(this);
        Hermes.getDefault().register(UserManager.class);
        Hermes.getDefault().register(DownManager.class);
        DownManager.getInstance().setFileRecord(new FileRecord("/sdcard/0",12344));
    }

    public void change(View view)
    {
        startActivity(new Intent(this, SecondActivity.class));
    }
//主线程---子线程接受


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void getPerson(View view) {
        Toast.makeText(this,"----->  "+ UserManager.getInstance().getPerson(),Toast.LENGTH_SHORT).show();
    }
}
