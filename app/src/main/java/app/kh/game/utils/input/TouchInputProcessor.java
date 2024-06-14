package app.kh.game.utils.input;

import com.badlogic.gdx.InputProcessor;

public interface TouchInputProcessor extends InputProcessor {
    @Override
    default boolean keyDown(int keycode) { return false; }

    @Override
    default boolean keyUp(int keycode) { return false; }

    @Override
    default boolean keyTyped(char character) { return false; }

    @Override
    default boolean mouseMoved(int screenX, int screenY) { return false; }

    @Override
    default boolean scrolled(float amountX, float amountY) { return false; }
}
