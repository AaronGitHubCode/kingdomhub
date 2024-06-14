package app.kh.game;

import com.badlogic.gdx.Gdx;

import app.kh.game.actors.Player;
import app.kh.game.actors.TestEnemy;
import app.kh.game.stages.BattleArena;

final class Game extends com.badlogic.gdx.Game {
    private Player testPlayer;

    private TestEnemy testEnemy;

    private BattleArena testArena;

    @Override
    public void create() {
        testPlayer = new Player();
        testEnemy = new TestEnemy();
        testArena = new BattleArena(testPlayer, testEnemy);
    }

    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public void render() {
        super.render();

        Gdx.gl.glFlush();

        testArena.draw();
    }
}
