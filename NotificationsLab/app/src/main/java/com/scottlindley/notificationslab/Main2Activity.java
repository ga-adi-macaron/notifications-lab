package com.scottlindley.notificationslab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ImageView networkImage = (ImageView)findViewById(R.id.network_image);

        Intent receivedIntent = getIntent();
        String receivedExtra = receivedIntent.getStringExtra(MainActivity.INTENT_KEY);

        if(receivedExtra.equals(MainActivity.NETWORK_VALUE)){
            networkImage.setImageResource(R.drawable.connected);
        }else if(receivedExtra.equals(MainActivity.NO_NETWORK_VALUE)){
            networkImage.setImageResource(R.drawable.no_connection);
        }else{
            finish();
        }
    }
}
