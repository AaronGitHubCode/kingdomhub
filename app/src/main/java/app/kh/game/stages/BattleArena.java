package app.kh.game.stages;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.scenes.scene2d.Stage;

import app.kh.game.actors.Battler;

public class BattleArena extends Stage {
    private TiledMap tiledMap;

    private final Battler firstBattler;
    private final Battler secondBattler;

    public BattleArena(final Battler firstBattler, final Battler secondBattler) {
        this.firstBattler = firstBattler;
        this.secondBattler = secondBattler;
    }

    @Override
    public void draw() {
        super.draw();



        firstBattler.draw(firstBattler.getSpriteBatch(), 0.0f);
        secondBattler.draw(secondBattler.getSpriteBatch(), 0.0f);


    }

    @Override
    public void dispose() {
        clear();
        firstBattler.clear();
        secondBattler.clear();
    }
}
