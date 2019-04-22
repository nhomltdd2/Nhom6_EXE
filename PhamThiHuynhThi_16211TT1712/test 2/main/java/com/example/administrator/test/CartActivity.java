package com.example.administrator.test;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity implements SensorEventListener {

TextView txtTitle, txtDescription, txtPrice;
ImageView imvProduct;
    private SensorManager sensorManager;
    private boolean isColor = false;
    private View view;
    private long lastUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_detail_layout );

        imvProduct = (ImageView)findViewById( R.id.imvProduct_detail );
        txtTitle = (TextView) findViewById( R.id.txtTitle_detail );
        txtDescription = (TextView) findViewById( R.id.txtDescription_detail );
        txtPrice = (TextView) findViewById( R.id.txtPrice_detail );

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        lastUpdate = System.currentTimeMillis();
    }

    @Override
    protected void onResume() {

        super.onResume();
        Product product = MyDB.product_list.get( MyDB.product_id );
        imvProduct.setImageResource( product.getImage() );
        txtTitle.setText("Tên sản phẩm: "+ product.getName() );
        txtDescription.setText( "Mô tả: "+product.getDescription() );
        txtPrice.setText("Giá: "+ product.getPrice()+"" );
        //Toast.makeText(this, "on resume", Toast.LENGTH_SHORT).show();
       // Toast.makeText(this, "product id: " + MyDB.product_id, Toast.LENGTH_SHORT).show();
        sensorManager.registerListener(this,sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            getAccelerometer(event);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
    private void getAccelerometer(SensorEvent event) {
        float[] values = event.values;
// Movement
        float x = values[0];
        float y = values[1];
        float z = values[2];
        float accelationSquareRoot = (x * x + y * y + z * z)
                / (SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);
        long actualTime = System.currentTimeMillis();
        Toast.makeText(getApplicationContext(),String.valueOf(accelationSquareRoot)+" "+
                SensorManager.GRAVITY_EARTH,Toast.LENGTH_SHORT).show();
        if (accelationSquareRoot >= 2) //it will be executed if you shuffle
        {
           this.finish();
        }
    }
    protected void onPause() {
// unregister listener
        super.onPause();
        sensorManager.unregisterListener(this);
    }
}
