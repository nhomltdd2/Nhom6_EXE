package com.example.huypd.calcultor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CalculatorActivity extends AppCompatActivity {

    float a, b;

    boolean funCong, funTru, funNhan, funChia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_calculator);

        //Get views from layout
       final EditText editKetQua = (EditText) findViewById(R.id.editResult);
        Button btnSo0 = (Button) findViewById(R.id.btnSo0);
        Button btnSo1 = (Button) findViewById(R.id.btnSo1);
        Button btnSo2 = (Button) findViewById(R.id.btnSo2);
        Button btnSo3 = (Button) findViewById(R.id.btnSo3);
        Button btnSo4 = (Button) findViewById(R.id.btnSo4);
        Button btnSo5 = (Button) findViewById(R.id.btnSo5);
        Button  btnSo6 = (Button) findViewById(R.id.btnSo6);
        Button btnSo7 = (Button) findViewById(R.id.btnSo7);
        Button btnSo9 = (Button) findViewById(R.id.btnSo9);
        Button btnSo8 = (Button) findViewById(R.id.btnSo8);
        Button btnCong = (Button) findViewById(R.id.btnCong);
        Button btnTru = (Button) findViewById(R.id.btnTru);
        Button btnNhan = (Button) findViewById(R.id.btnNhan);
        Button btnChia = (Button) findViewById(R.id.btnChia);
        Button btnKetQua = (Button) findViewById(R.id.btnKetQua);
        Button btnReset = (Button) findViewById(R.id.btnReset);


        //Event processing
        btnSo0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editKetQua.setText(editKetQua.getText() + "0");
            }
        });

        btnSo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editKetQua.setText(editKetQua.getText() + "1");
            }
        });

        btnSo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editKetQua.setText(editKetQua.getText() + "2");
            }
        });

        btnSo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editKetQua.setText(editKetQua.getText() + "3");
            }
        });

        btnSo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editKetQua.setText(editKetQua.getText() + "4");
            }
        });

        btnSo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editKetQua.setText(editKetQua.getText() + "5");
            }
        });

        btnSo6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editKetQua.setText(editKetQua.getText() + "6");
            }
        });

        btnSo7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editKetQua.setText(editKetQua.getText() + "7");
            }
        });

        btnSo8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editKetQua.setText(editKetQua.getText() + "8");
            }
        });

        btnSo9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editKetQua.setText(editKetQua.getText() + "9");
            }
        });

        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editKetQua == null) {
                    editKetQua.setText("");
                } else {
                    a = Float.parseFloat(editKetQua.getText() + "");
                    funCong = true;
                    editKetQua.setText(null);
                }
            }
        });

        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = Float.parseFloat(editKetQua.getText() + "");
                funTru = true;
                editKetQua.setText(null);
            }
        });

        btnNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = Float.parseFloat(editKetQua.getText() + "");
                funNhan = true;
                editKetQua.setText(null);
            }
        });

        btnChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = Float.parseFloat(editKetQua.getText() + "");
                funChia = true;
                editKetQua.setText(null);
            }
        });

        btnKetQua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b = Float.parseFloat(editKetQua.getText() + "");



                if (funCong == true)
                {
                    editKetQua.setText(a + b + "");
                    funCong = false;
                }

                if (funTru == true) {
                    editKetQua.setText(a - b + "");
                    funTru = false;
                }

                if (funNhan == true) {
                    editKetQua.setText(a * b + "");
                    funNhan = false;
                }

                if (funChia == true) {
                    editKetQua.setText(a / b + "");
                    funChia = false;
                }
            }
        });


        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editKetQua.setText("");
            }
        });










    }


}
