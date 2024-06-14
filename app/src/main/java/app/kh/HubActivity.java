package app.kh;

import static app.kh.utils.ApplicationConstants.NOTIFICATION_ID;
import static app.kh.utils.ApplicationConstants.NOTIFICATION_NAME;
import static app.kh.utils.ApplicationConstants.NOTIFICATION_UNIQUE_ID;

import app.kh.utils.IAudioService;
import app.kh.utils.INotificationService;

import app.kh.ui.fragment.HubFragment;

import android.content.res.Resources;

import android.media.MediaPlayer;

import android.os.Bundle;

import android.app.NotificationChannel;
import android.app.NotificationManager;

import androidx.activity.OnBackPressedCallback;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.app.NotificationCompat;

import androidx.annotation.Nullable;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.fragment.app.FragmentTransaction;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author AaronGitHubCode
 * @version pre-alpha.0.0.1
 * */
public final class HubActivity extends AppCompatActivity
implements INotificationService, IAudioService {
    private NotificationManager notificationManager;

    private MediaPlayer mediaPlayer = new MediaPlayer();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setSupportActionBar(findViewById(R.id.materialToolbar));

        /**
         * Inhabilitar botón de regreso.
         * */
        getOnBackPressedDispatcher().addCallback(new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {}
        });

        final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.hub_fragment_container, new HubFragment(), "hub");
        fragmentTransaction.commit();

        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.createNotificationChannel(new NotificationChannel(NOTIFICATION_ID, NOTIFICATION_NAME, NotificationManager.IMPORTANCE_DEFAULT));
    }

    @Override
    protected void onStart() {
        super.onStart();

        final DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        final ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, findViewById(R.id.materialToolbar), R.string.open_toggle, R.string.close_toggle);
        toggle.syncState();
    }

    /*
    Implementar si la barra de tareas contiene botones.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        final MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        final int itemId = item.getItemId();

        return true;
    }
     */

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
