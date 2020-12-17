package jukeustry.content.JukeBlocksSpecial;

import arc.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.util.*;
import mindustry.world.*;
import mindustry.world.blocks.production.GenericSmelter;
import mindustry.world.blocks.production.GenericSmelter.SmelterBuild;

public class jukeboxiteSmelter extends GenericSmelter {
    public TextureRegion colorRegion;

    public jukeboxiteSmelter(String name) {
        super(name);
    }

    @Override
    public void load(){
        super.load();
        colorRegion = Core.atlas.find("jukeboxite-smelter-color");
    }

    public class JukeboxBuild extends SmelterBuild {

        @Override
        public void draw(){
            super.draw();

            Draw.color(Color.valueOf("ff0000").shiftHue(Time.time));
            Draw.rect(colorRegion, this.x, this.y);
            Draw.reset();
        }
    }
}
