package com.colinbradley.notificationlab;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo info = connectivityManager.getActiveNetworkInfo();

        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, (int)System.currentTimeMillis(), intent, 0);


        if (info != null && info.isConnected()){
            NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
            bigPictureStyle.bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.connected));


            NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
            builder.setStyle(bigPictureStyle);
            builder.setSmallIcon(android.R.drawable.ic_dialog_alert);
            builder.setContentText("You Are Connected To The Internet");
            builder.setContentTitle("CONNECTED");
            builder.setContentIntent(pendingIntent);
            builder.setAutoCancel(true);

            NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
            manager.notify(1,builder.build());
        }
        else{
            NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
            bigPictureStyle.bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.notconnected));

            NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
            builder.setSmallIcon(android.R.drawable.ic_dialog_alert);
            builder.setStyle(bigPictureStyle);
            builder.setContentText("You Are Not Connected To The Internet");
            builder.setContentTitle("NOT CONNECTED");
            builder.setContentIntent(pendingIntent);

            NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
            manager.notify(2,builder.build());
        }


    }
}
