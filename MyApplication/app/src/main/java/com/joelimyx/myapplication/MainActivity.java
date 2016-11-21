package com.joelimyx.myapplication;

import android.Manifest;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);

        ConnectivityManager manager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();

        if (networkInfo!=null && networkInfo.isConnected()){

            Intent intent = new Intent(this,ConnectionActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(),intent,0);

            NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
            bigPictureStyle.setBigContentTitle("Connection Available!")
                    .bigPicture(BitmapFactory.decodeResource(getResources(),R.mipmap.connected)).build();

            builder.setSmallIcon(R.drawable.ic_wifi_black_24dp)
                    .setContentTitle("Connection Alert")
                    .setContentText("You are Connected")
                    .setContentIntent(pendingIntent)
                    .setStyle(bigPictureStyle)
                    .setAutoCancel(true);
        }else{
            Intent intent = new Intent(this,ConnectionActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(),intent,0);

            NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
            bigPictureStyle.setBigContentTitle("No Connection!")
                    .bigPicture(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher)).build();

            builder.setSmallIcon(R.drawable.ic_do_not_disturb_black_24dp)
                    .setContentTitle("Connection Alert")
                    .setContentText("No Internet Connection")
                    .setContentIntent(pendingIntent)
                    .setStyle(bigPictureStyle);
        }
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1,builder.build());
    }
}
