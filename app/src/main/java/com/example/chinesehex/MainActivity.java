package com.example.chinesehex;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;

import static com.example.chinesehex.Utils.toGBK;
import static com.example.chinesehex.Utils.writeToSdCard;

public class MainActivity extends AppCompatActivity {
    private EditText name;
    private EditText num;
    private Spinner money;
    private Button save;
    private Button zh;
    private static final String TAG = "MainActivity";
    public String qian, resule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.name);
        num = (EditText) findViewById(R.id.num);
        money = (Spinner) findViewById(R.id.money);
        save = (Button) findViewById(R.id.save);
        zh = (Button) findViewById(R.id.zh);


        final int REQUEST_WRITE = 1;//申请权限的请求码
        //Spinner点击事件
        money.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                resule = adapterView.getItemAtPosition(i).toString();
                switch (resule) {
                    case "112.7":
                        qian = "701201008363DF050316010000190080";
                        break;
                    case "115.7":
                        qian = "701301008462DA05011001000022007D";
                        break;
                    case "132.7":
                        qian = "70360100A747E20502230101010800AC";
                        break;
                    case "175.7":
                        qian = "70750100E604E50502230101010800EA";
                        break;
                    case "191.7":
                        qian = "7091010002E0E60502230101010800FF";
                        break;
                    case "200.7":
                        qian = "700002007272E7050223010101080072";
                        break;
                    case "209.7":
                        qian = "700902007B7BE805022301010108008E";
                        break;
                    case "241.7":
                        qian = "70410200B333EA0502230101010800B8";
                        break;
                    case "257.7":
                        qian = "70570200C925EB0502230101010800D7";
                        break;
                    case "273.7":
                        qian = "70730200E501EC0502230101010800EC";
                        break;
                    case "282.7":
                        qian = "70820200F4F0ED0502230101010800FA";
                        break;
                }
//                Log.d(TAG, "onItemSelected: " + qian);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //保存成文件
                //判断是否6.0以上的手机   不是就不用
                if (Build.VERSION.SDK_INT >= 23) {
                    //判断是否有这个权限
                    if (ContextCompat.checkSelfPermission(MainActivity.this,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                        //2、申请权限: 参数二：权限的数组；参数三：请求码
                        ActivityCompat.requestPermissions(MainActivity.this,
                                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_WRITE);
                    } else {

                        try {
                            writeToSdCard(MainActivity.this,
                                    toGBK(name.getText().toString()),
                                    toGBK(num.getText().toString()),
                                    qian,
                                    name.getText().toString() + resule);
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }
        });

        zh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    Toast.makeText(MainActivity.this, toGBK(name.getText().toString()), Toast.LENGTH_LONG).show();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
