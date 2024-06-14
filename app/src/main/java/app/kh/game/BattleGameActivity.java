package app.kh.game;

import static java.lang.System.loadLibrary;

import app.kh.utils.Provisional;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

/**
 * Esta clase debe ser cambiada por una clase nativa para mejor rendimiento.
 * Esta clase es únicamente provisional.
 * */
@Provisional(nativeActivityName = "native_game_activity")
public final class BattleGameActivity extends AndroidApplication {
    static {
        loadLibrary("kh");
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final AndroidApplicationConfiguration applicationConfiguration = new AndroidApplicationConfiguration();
        applicationConfiguration.useCompass = false;
        applicationConfiguration.useAccelerometer = false;
        initialize(new Game(), applicationConfiguration);
    }
}
