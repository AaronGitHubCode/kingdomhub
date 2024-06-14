package app.kh.services;

import static app.kh.utils.ApplicationConstants.NOTIFICATION_UNIQUE_ID;
import static app.kh.utils.ApplicationConstants.NOTIFICATION_ID;
import static app.kh.utils.ApplicationConstants.NOTIFICATION_NAME;

import android.app.Service;
import android.app.NotificationManager;
import android.app.NotificationChannel;

import android.content.Intent;

import android.content.res.Resources;

import android.os.IBinder;

import android.graphics.BitmapFactory;

import androidx.core.app.NotificationCompat;

import androidx.annotation.Nullable;

import java.util.Calendar;

/**
 * @author AaronGitHubCode
 * @version pre-alpha.0.0.1
 * */
public final class AliveNotification extends Service {
    /* Valor vacío hasta encontrar logo para la aplicación. */ private static final int TEST_INT = 0x0000;

    private NotificationManager notificationManager;

    @Override
    public void onCreate() {
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.createNotificationChannel(new NotificationChannel(NOTIFICATION_ID, NOTIFICATION_NAME, NotificationManager.IMPORTANCE_DEFAULT));
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        final Resources resources = getResources();
        final Calendar time = Calendar.getInstance();

        final String title = intent.getStringExtra("title");
        final String content = intent.getStringExtra("content");

        final int hour = intent.getIntExtra("hour", 0);
        final int minutes = intent.getIntExtra("minutes", 0);

        if (time.get(Calendar.MINUTE) == minutes && time.get(Calendar.HOUR) == hour) {
            final NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, NOTIFICATION_ID);

            notificationBuilder
                    .setContentTitle(title)
                    .setContentText(content)
                    .setSmallIcon(TEST_INT)
                    .setLargeIcon(BitmapFactory.decodeResource(resources, TEST_INT));

            notificationManager.notify(NOTIFICATION_UNIQUE_ID, notificationBuilder.build());
        }

        return START_NOT_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
