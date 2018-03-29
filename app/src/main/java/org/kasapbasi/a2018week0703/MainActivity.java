package org.kasapbasi.a2018week0703;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.graphics.Color.*;
import android.widget.Toast;

import static android.graphics.Color.GREEN;

public class MainActivity extends AppCompatActivity  implements SensorEventListener{
 SensorManager sm;
 TextView tv;
    private boolean color = false;
long lastUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
// en üstteki Minnak ikonlar (saat, GSM operator, data vb) kaldırma kodu
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
// manifeste bunu da ekleyebilirsiniz. android:theme="@style/Theme.AppCompat.NoActionBar">

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    tv= (TextView) findViewById(R.id.textView);
    tv.setBackgroundColor(GREEN);

    sm= (SensorManager) getSystemService(SENSOR_SERVICE);
    lastUpdate=System.currentTimeMillis();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            getAccelerometer(event);
        }
    }
    private void getAccelerometer(SensorEvent event) {
        float[] values = event.values;
        // Movement
        float x = values[0];
        float y = values[1];
        float z = values[2];

        float accelationSquareRoot = (x * x + y * y + z * z)
                / (SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);
        long actualTime = event.timestamp;

        if (accelationSquareRoot >= 2) //
        {
            if (actualTime - lastUpdate < 200) {
                return;
            }
            lastUpdate = actualTime;
            Toast.makeText(this, "Device was shuffed", Toast.LENGTH_SHORT)
                    .show();
            if (color) {
                tv.setBackgroundColor(Color.GREEN);
            } else {
                tv.setBackgroundColor(Color.RED);
            }
            color = !color;
        }
    }

    /**
     * Dispatch onPause() to fragments.
     */
    @Override
    protected void onPause() {
        super.onPause();
        sm.unregisterListener(this);
    }

    /**
     * Dispatch onResume() to fragments.  Note that for better inter-operation
     * with older versions of the platform, at the point of this call the
     * fragments attached to the activity are <em>not</em> resumed.  This means
     * that in some cases the previous state may still be saved, not allowing
     * fragment transactions that modify the state.  To correctly interact
     * with fragments in their proper state, you should instead override
     * {@link #onResumeFragments()}.
     */
    @Override
    protected void onResume() {
        sm.registerListener(this,
                sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);


        super.onResume();


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
class mylistener implements SensorEventListener{


    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}