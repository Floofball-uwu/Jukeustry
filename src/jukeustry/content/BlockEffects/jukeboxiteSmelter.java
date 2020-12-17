package jukeustry.content.BlockEffects;

import arc.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.util.*;
import mindustry.world.blocks.production.GenericSmelter;

public class jukeboxiteSmelter extends GenericSmelter {
    public TextureRegion colorRegion;

    public jukeboxiteSmelter(String name) {
        super(name);
    }

    @Override
    public void load(){
        super.load();
        colorRegion = Core.atlas.find(name + "-color");
    }

    public class JukeboxBuild extends SmelterBuild {

        @Override
        public void draw(){
            super.draw();

            Draw.color(Color.valueOf("ffff0000").shiftHue(Time.time));
            Draw.rect(colorRegion, tile.drawx(), tile.drawy());
        }
    }
}