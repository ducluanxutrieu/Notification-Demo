package com.ducluanxutrieu.ducluan.notificationdemo;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    int notificationId = 113;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void createNotification(View view) {
        NotificationCompat.Builder notificationCompatBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.alarm)
                .setContentTitle(getString(R.string.have_new_notification))
                .setContentText(getString(R.string.cllick_here_to_update_new_version))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        Intent resultIntent = new Intent(this, UpdateActivity.class);
        PendingIntent resultPendingIntent = PendingIntent.getActivity(this, 0, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        notificationCompatBuilder.setContentIntent(resultPendingIntent);

        Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        notificationCompatBuilder.setSound(uri);


        NotificationManager nManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nManager.notify(notificationId, notificationCompatBuilder.build());
    }

    public void closeNotification(View view) {
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.cancel(notificationId);
    }
}
