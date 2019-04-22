package com.exe3.phamthihuynhthi.exe3_bt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class BellActivity extends AppCompatActivity {

    Animation animation;
    ImageView imgProduct_detail;
    TextView txtDescription_detail;
    Animation frombottom;
    Animation alpha;
    public Button btnBack;
    static Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bell_details);
        animation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        frombottom = AnimationUtils.loadAnimation(this, R.anim.frombottom);
        alpha = AnimationUtils.loadAnimation(this, R.anim.alpha);
        imgProduct_detail = (ImageView) findViewById(R.id.imgProduct_detail);
        txtDescription_detail = (TextView) findViewById(R.id.txtDescription_detail);
        btnBack = (Button) findViewById(R.id.btnBack);
        imgProduct_detail.startAnimation(alpha);
        txtDescription_detail.startAnimation(frombottom);
        btnBack.startAnimation(frombottom);

        btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(BellActivity.this ,MainActivity.class);
                intent.setFlags(intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
            }
        });
    }
}
