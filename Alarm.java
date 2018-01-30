package com.example.alberthiggins.examplealarmapp1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.widget.Toast;

/**
 * Created by alberthiggins on 30/01/2018.
 */

public class Alarm extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
//        Toast.makeText(context, "This is my toast", Toast.LENGTH_LONG).show();

        Toast.makeText(context, "This is the toast", Toast.LENGTH_LONG).show();

        Vibrator v = (Vibrator)context.getSystemService(context.VIBRATOR_SERVICE);
        v.vibrate(500);

    }
}
