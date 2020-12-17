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
            draw();

            //Draw.color(Color.valueOf("#ff000000ff").shiftHue(Time.time));
            Draw.color(Color.valueOf("#ffbbffbb").set(255f, 255f, 0f, 255f));
            Draw.rect(colorRegion, tile.drawx(), tile.drawy());
        }
    }
}