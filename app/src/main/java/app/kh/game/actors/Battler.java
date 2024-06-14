package app.kh.game.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class Battler extends Actor {
    private String name;

    private final SpriteBatch spriteBatch;

    private int health = 100;

    private Stats stats;

    public static final class Stats {
        private int strength;
    }

    protected Battler() {
        spriteBatch = new SpriteBatch();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }

    @Override
    public Actor hit(float x, float y, boolean touchable) {
        return super.hit(x, y, touchable);
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public int getHealth() {
        return health;
    }

    public void loseHealth(final Battler battler) {
        health -= battler.stats.strength;
    }

    public SpriteBatch getSpriteBatch() {
        return spriteBatch;
    }
}
