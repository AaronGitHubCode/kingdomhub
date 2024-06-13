package app.kh;

import static app.kh.utils.ApplicationConstants.NOTIFICATION_ID;
import static app.kh.utils.ApplicationConstants.NOTIFICATION_NAME;
import static app.kh.utils.ApplicationConstants.NOTIFICATION_UNIQUE_ID;

import app.kh.utils.IAudioService;
import app.kh.utils.INotificationService;

import app.kh.ui.HubFragment;

import android.content.res.Resources;

import android.media.MediaPlayer;

import android.os.Bundle;

import android.app.NotificationChannel;
import android.app.NotificationManager;

import androidx.core.app.NotificationCompat;

import androidx.annotation.Nullable;

import androidx.fragment.app.FragmentTransaction;

import androidx.appcompat.app.AppCompatActivity;

public final class HubActivity extends AppCompatActivity
implements INotificationService, IAudioService {
    private NotificationManager notificationManager;

    private MediaPlayer mediaPlayer = new MediaPlayer();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.hub_fragment_container, new HubFragment(), "hub");
        fragmentTransaction.commit();

        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.createNotificationChannel(new NotificationChannel(NOTIFICATION_ID, NOTIFICATION_NAME, NotificationManager.IMPORTANCE_DEFAULT));
    }

    @Override
    public void onNotify(String title, String content, int smallIcon, int largeIcon) {
        final Resources resources = getResources();
        final NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, NOTIFICATION_ID);

        notificationBuilder
                .setContentTitle(title)
                .setContentText(content)
                .setSmallIcon(smallIcon)
                .setLargeIcon(android.graphics.BitmapFactory.decodeResource(resources, largeIcon));

        notificationManager.notify(NOTIFICATION_UNIQUE_ID, notificationBuilder.build());
    }

    @Override
    public void onChangeAudioResource(int audioResource) {
        mediaPlayer = MediaPlayer.create(this, audioResource);
    }

    @Override
    public void onPauseAudioResource() {
        if (mediaPlayer.isPlaying())
            mediaPlayer.pause();
    }

    @Override
    public void onPlayAudioResource() {
        if (!mediaPlayer.isPlaying())
            mediaPlayer.start();
    }
}
