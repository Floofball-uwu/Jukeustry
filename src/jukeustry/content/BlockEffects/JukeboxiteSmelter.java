package jukeustry.content.BlockEffects;

import arc.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.util.*;
import mindustry.world.blocks.production.GenericSmelter;

public class JukeboxiteSmelter extends GenericSmelter {
    public TextureRegion colorRegion;

    public JukeboxiteSmelter(String name) {
        super(name);
    }

    @Override
    public void load() {
        super.load();
        colorRegion = Core.atlas.find(name + "-color");
        Log.info("Jukeboxite colorRegion set and loaded");
    }

    public class JukeboxBuild extends SmelterBuild {

        @Override
        public void draw() {

            Draw.color(Color.valueOf("ff0000").shiftHue(Time.time));
            Draw.rect(colorRegion, tile.drawx(), tile.drawy());

            Log.info("RGB has loaded. Does it work?");
        }
    }
}