package com.scottlindley.notificationslab;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static final String INTENT_KEY = "intent_key";
    public static final String NETWORK_VALUE = "connected";
    public static final String NO_NETWORK_VALUE = "not_connected";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.network_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConnectivityManager connectivityManager =
                        (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo info = connectivityManager.getActiveNetworkInfo();

                NotificationCompat.BigPictureStyle style = new NotificationCompat.BigPictureStyle();
                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this);

                if (info!=null && info.isConnected()){
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    intent.putExtra(INTENT_KEY, NETWORK_VALUE);
                    PendingIntent pendingIntent =
                            PendingIntent.getActivity(MainActivity.this,(int)System.currentTimeMillis(),intent,0);

                    style.bigPicture(BitmapFactory.decodeResource(getResources(),R.drawable.connected))
                            .setBigContentTitle("Connected to network")
                            .setSummaryText("Click me!")
                            .build();
                    builder.setSmallIcon(R.drawable.ic_signal_wifi_4_bar_black_24dp)
                            .setContentText("Click me!")
                            .setContentTitle("Connected to network")
                            .setContentIntent(pendingIntent)
                            .setAutoCancel(true)
                            .setStyle(style);
                }else{
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    intent.putExtra(INTENT_KEY, NO_NETWORK_VALUE);
                    PendingIntent pendingIntent =
                            PendingIntent.getActivity(MainActivity.this,(int)System.currentTimeMillis(),intent,0);

                    style.bigPicture(BitmapFactory.decodeResource(getResources(),R.drawable.no_connection))
                            .setBigContentTitle("Connected to network")
                            .setSummaryText("Click me!")
                            .build();

                    builder.setSmallIcon(R.drawable.ic_signal_wifi_off_black_24dp)
                            .setContentText("Click me!")
                            .setContentTitle("No network connection found")
                            .setContentIntent(pendingIntent)
                            .setStyle(style);
                }
                NotificationManager notificationManager =
                        (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(1, builder.build());
            }
        });


    }
}
