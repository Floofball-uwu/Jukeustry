package jukeustry.content.world.blocks.logic;

import arc.Core;
import arc.audio.Music;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.TextureRegion;
import arc.scene.ui.layout.Table;
import arc.util.io.Reads;
import arc.util.io.Writes;
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
        public int currentTrack = 0;

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

        @Override
        public Object config(){
            return currentTrack;
        }

        @Override
        public void readAll(Reads read, byte revision){
            super.readAll(read, revision);

            if(revision == 1){
                enabled = read.bool();
            }
        }

        @Override
        public void write(Writes write){
            super.write(write);

            write.i(1);
        }
    }

    //Make cool jukeboxy UI here. Also finish class to allow for choosing what sound files to
    //play based on an int array from 0 (stop sound) to 16. Should allow for easy customization.

    //Assign "track1", "track2", "track3", etc. to a numerical array. The tracks will be names of
    //soundfile tracks (inputted in JukeBlocks.java), but calculated with integers for logic compatibility
    //and flexibility.
}
