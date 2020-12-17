package jukeustry.content.JukeBlocksSpecial;

import arc.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.util.*;
import mindustry.gen.*;
import mindustry.mod.*;
import mindustry.world.*;

public class jukeboxiteSmelter extends Block{
    public TextureRegion colorRegion;

    public jukeboxiteSmelter(String name) {
        super(name);
    }

    @Override
    public void load(){
        super.load();
        colorRegion = Core.atlas.find(name + "-color");
    }

    public class GenericSmelter extends Building{
        @Override
        public void draw(){
            super.draw();

            Draw.color(Color.valueOf("ff0000").shiftHue(Time.time));
            Draw.rect(colorRegion, this.x, this.y);
        }
    }
}