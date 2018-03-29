package org.kasapbasi.a2018week0703;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity  implements SensorEventListener{
 SensorManager sm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
// en üstteki Minnak ikonlar (saat, GSM operator, data vb) kaldırma kodu
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
// manifeste bunu da ekleyebilirsiniz. android:theme="@style/Theme.AppCompat.NoActionBar">

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
