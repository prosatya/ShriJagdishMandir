package com.matictechnology.shrijagdishmandir;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by maticd1 on 2/4/16.
 */
public class BroadcastBootReceiver extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent)
    {
        if(intent.getAction().equalsIgnoreCase(Intent.ACTION_BOOT_COMPLETED))
        {
            Intent myIntent = new Intent(context, AlarmService.class);
            context.startService(myIntent);
            //context.startService(new Intent(context(), AlarmService.class));
        }

    }
}
