package jukeustry.content.world.blocks.crafting;

import arc.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.util.*;
import mindustry.world.blocks.production.GenericSmelter;

public class JukeboxiteSmelter extends GenericSmelter {
    public TextureRegion colorRegion;
    public TextureRegion baseSprite;

    public JukeboxiteSmelter(String name) {
        super(name);
    }

    @Override
    public void load() {
        super.load();
        colorRegion = Core.atlas.find(name + "-color");
        baseSprite = Core.atlas.find(name);
    }

    public class JukeboxBuild extends SmelterBuild {

        @Override
        public void draw() {

            Draw.rect(baseSprite, x, y);
            Draw.color(Color.valueOf("ff0000").shiftHue(Time.time()));
            Draw.rect(colorRegion, x, y);
        }
    }
}