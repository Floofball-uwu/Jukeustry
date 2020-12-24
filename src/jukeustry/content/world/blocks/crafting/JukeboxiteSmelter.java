package jukeustry.content.world.blocks.crafting;

import arc.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.Mathf;
import arc.util.*;
import mindustry.gen.Sounds;
import mindustry.graphics.Drawf;
import mindustry.world.blocks.production.GenericSmelter;

public class JukeboxiteSmelter extends GenericSmelter {
    public TextureRegion colorRegion;
    public TextureRegion baseSprite;

    public JukeboxiteSmelter(String name) {
        super(name);
        this.ambientSound = Sounds.smelter;
        this.ambientSoundVolume = 0.07F;
    }

    @Override
    public void load() {
        super.load();
        colorRegion = Core.atlas.find(name + "-color");
        baseSprite = Core.atlas.find(name);
    }

    public class JukeboxiteSmelterBuild extends SmelterBuild {

        @Override
        public void draw() {
            if (this.warmup > 0.0F && JukeboxiteSmelter.this.flameColor.a > 0.001F) {
                float g = 0.3F;
                float r = 0.06F;
                float cr = Mathf.random(0.1F);
                Draw.alpha((1.0F - g + Mathf.absin(Time.time, 8.0F, g) + Mathf.random(r) - r) * this.warmup);
                Draw.tint(JukeboxiteSmelter.this.flameColor);
                Fill.circle(this.x, this.y, 3.0F + Mathf.absin(Time.time, 5.0F, 2.0F) + cr);
                Draw.color(1.0F, 1.0F, 1.0F, this.warmup);
                Draw.rect(JukeboxiteSmelter.this.topRegion, this.x, this.y);
                Fill.circle(this.x, this.y, 1.9F + Mathf.absin(Time.time, 5.0F, 1.0F) + cr);
                Draw.color();
            }
            Draw.rect(baseSprite, x, y);
            Draw.color(Color.valueOf("bb0000").shiftHue(Time.time));
            Draw.rect(colorRegion, x, y);
        }
        @Override
        public void drawLight() {
            Drawf.light(this.team, this.x, this.y, (60.0F + Mathf.absin(10.0F, 5.0F)) * this.warmup * (float)JukeboxiteSmelter.this.size, JukeboxiteSmelter.this.flameColor, 0.65F);
        }
    }
}