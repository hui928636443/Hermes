package com.tianyi.hermeseventbus;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.tianyi.hermeseventbus.core.Hermes;
import com.tianyi.hermeseventbus.service.HermesService;


/**
 * Created by Administrator on 2019/3/22 0022.
 */

public class SecondActivity extends Activity {
    IUserManager userManager;
    IDownManager downManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Hermes.getDefault().connect(this, HermesService.class);
    }

    public void userManager(View view) {
//         userManager  进程A的副本
        userManager = Hermes.getDefault().getInstance(IUserManager.class);
        downManager=Hermes.getDefault().getInstance(IDownManager.class);
    }
    public void getUser(View view) {
        if (userManager!=null && downManager!=null){
            userManager.setPerson(new Person("yyh","789"));
            Toast.makeText(this,"-----> "+downManager.getFileRecord(),Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,"请先得到对象 ",Toast.LENGTH_SHORT).show();
        }

    }
}
