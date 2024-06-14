package app.kh.game.actors;

import static com.badlogic.gdx.Input.Keys.*;

import app.kh.game.utils.input.GamepadInputProcessor;

public final class Player extends Battler
implements GamepadInputProcessor {
    private static final float VELOCITY = 10.5f;

    public Player() {
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case PsKeys.SQUARE:
                break;
            case PsKeys.CIRCLE:
                break;
            case PsKeys.CROSS:
                break;
            case PsKeys.TRIANGLE:
                break;
        }

        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }
}
