package jukeustry.content.world.blocks.logic;

import arc.Core;
import arc.audio.Music;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.TextureRegion;
import arc.scene.ui.layout.Table;
import mindustry.gen.Building;
import mindustry.gen.Icon;
import mindustry.world.*;
import mindustry.world.meta.*;

public class JukeboxBlock extends Block {
    public TextureRegion baseSprite;

    public Music[] tracks = {};

    public JukeboxBlock(String name) {

        super(name);
        update = true;
        solid = true;
        configurable = true;
        group = BlockGroup.logic;
    }

    @Override
    public void load() {
        super.load();
        baseSprite = Core.atlas.find(name);
    }


    public class JukeboxBuild extends Building {

        @Override
        public void draw() {
            Draw.rect(baseSprite, x, y);

        }

        @Override
        public void buildConfiguration(Table table) {
            table.button(Icon.pencil, () -> {

                deselect();
            }).size(40f);
        }

    }

    //Make cool jukeboxy UI here. Also finish class to allow for choosing what sound files to
    //play based on an int array from 0 (stop sound) to 16. Should allow for easy customization.

    //Assign "track1", "track2", "track3", etc. to a numerical array. The tracks will be names of
    //soundfile tracks (inputted in JukeBlocks.java), but calculated with integers for logic compatibility
    //and flexibility.
}
