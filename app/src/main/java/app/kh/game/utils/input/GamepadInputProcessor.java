package app.kh.game.utils.input;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

public interface GamepadInputProcessor extends InputProcessor {
    final class GenericKeys {
        private GenericKeys() {}
    }

    final class PsKeys {
        private PsKeys() {}

        public static final int CROSS = Input.Keys.BUTTON_A;
        public static final int SQUARE = Input.Keys.BUTTON_X;
        public static final int TRIANGLE = Input.Keys.BUTTON_Y;
        public static final int CIRCLE = Input.Keys.BUTTON_CIRCLE;

    }

    final class XboxKeys {
        private XboxKeys() {}


    }

    final class NintendoKeys {
        private NintendoKeys() {}
    }

    @Override
    default boolean keyTyped(char character) { return false; }

    @Override
    default boolean touchDown(int screenX, int screenY, int pointer, int button) { return false; }

    @Override
    default boolean touchUp(int screenX, int screenY, int pointer, int button) { return false; }

    @Override
    default boolean touchCancelled(int screenX, int screenY, int pointer, int button) { return false; }

    @Override
    default boolean touchDragged(int screenX, int screenY, int pointer) { return false; }

    @Override
    default boolean mouseMoved(int screenX, int screenY) { return false; }

    @Override
    default boolean scrolled(float amountX, float amountY) { return false; }
}
