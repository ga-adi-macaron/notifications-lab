package com.korbkenny.kennynotificationlab;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
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

        ConnectivityManager conMan = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = conMan.getActiveNetworkInfo();

        if(netInfo != null && netInfo.isConnected()){
            setNetAvailableNotification();
        }else{
            setNetUnavailableNotification();
        }
    }

    private void setNetAvailableNotification(){
        Intent intent = new Intent(MainActivity.this,DismissActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this,(int)System.currentTimeMillis(),intent,0);

        NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
        bigPictureStyle.bigPicture(BitmapFactory.decodeResource(getResources(),R.drawable.wifion));

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(android.R.drawable.ic_dialog_info);
        builder.setContentTitle("Wifi Available");
        builder.setContentText("Click to dismiss");
        builder.setAutoCancel(true);
        builder.setStyle(bigPictureStyle);
        builder.setContentIntent(pi);

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1,builder.build());
    }

    private void setNetUnavailableNotification(){
        Intent intent = new Intent(MainActivity.this,DismissActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this,(int)System.currentTimeMillis(),intent,0);

        NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
        bigPictureStyle.bigPicture(BitmapFactory.decodeResource(getResources(),R.drawable.wifioff));

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(android.R.drawable.ic_dialog_info);
        builder.setContentTitle("Wifi Unavailable");
        builder.setContentText("Set up your network");
        builder.setAutoCancel(false);
        builder.setStyle(bigPictureStyle);
        builder.setContentIntent(pi);

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1,builder.build());
    }
}
