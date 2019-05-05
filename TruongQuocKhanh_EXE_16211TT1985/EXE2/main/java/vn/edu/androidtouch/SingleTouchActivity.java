package vn.edu.androidtouch;

import android.app.Activity;
import android.os.Bundle;

public class SingleTouchActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new TouchEventView(this, null));
    }
}