package net.serkanbal.notificationslab;

import android.app.Notification;
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

        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {

            Intent intent = new Intent(this, ResultActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(this,
                    (int) System.currentTimeMillis(), intent, 0);

            NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
            builder.setSmallIcon(android.R.drawable.ic_media_play);
            builder.setContentTitle("Network Connected");
            builder.setContentText("Your network is working fine!");
            builder.setPriority(Notification.PRIORITY_MAX);
            NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
            bigPictureStyle.setSummaryText("Your network is working fine!");
            bigPictureStyle.bigPicture(BitmapFactory.decodeResource(getResources(),
                    R.drawable.network_connected)).build();
            builder.setStyle(bigPictureStyle);
            builder.setContentIntent(pendingIntent);

            NotificationManager notificationManager =
                    (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.notify(1, builder.build());
        } else {
            Intent intent = new Intent(this, ResultActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(this,
                    (int) System.currentTimeMillis(), intent, 0);

            NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
            builder.setSmallIcon(android.R.drawable.ic_media_pause);
            builder.setContentTitle("Network is not connected");
            builder.setContentText("Problem with internet connection!");
            builder.setPriority(Notification.PRIORITY_MAX);
            NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
            bigPictureStyle.setSummaryText("Problem with internet connection!");
            bigPictureStyle.bigPicture(BitmapFactory.decodeResource(getResources(),
                    R.drawable.network_not_connected)).build();
            builder.setStyle(bigPictureStyle);
            builder.setContentIntent(pendingIntent);

            NotificationManager notificationManager =
                    (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.notify(1, builder.build());
        }


    }
}
