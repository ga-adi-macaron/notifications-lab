package shuvalov.nikita.notificationslab;

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

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);


        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        Intent intent = new Intent(this, SecondActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,(int) System.currentTimeMillis(),intent, 0);
        if(networkInfo!=null && networkInfo.isConnected()){
            makeBigPicNotification(R.drawable.successful_connection,"Connected", pendingIntent,"Successful Internet Connection", true);
        }
        else{
            makeBigPicNotification(R.drawable.no_connection, "No connection", pendingIntent, "No connection detected", false);

        }
    }

    public void makeBigPicNotification(int imageRef, String contentTitle, PendingIntent intent, String bigContentTitle, boolean autoCancel){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
        bigPictureStyle.setBigContentTitle(bigContentTitle);
        bigPictureStyle.bigPicture(BitmapFactory.decodeResource(getResources(),imageRef)).build();

        builder.setStyle(bigPictureStyle)
                .setAutoCancel(autoCancel)
                .setContentTitle(contentTitle)
                .setContentIntent(intent)
                .setSmallIcon(android.R.drawable.ic_dialog_alert);

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1492, builder.build());
    }
}
