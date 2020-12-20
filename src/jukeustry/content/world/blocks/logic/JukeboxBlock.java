package jukeustry.content.world.blocks.logic;

import arc.Core;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.TextureRegion;
import arc.util.Nullable;
import mindustry.gen.Building;
import mindustry.world.*;
import mindustry.world.meta.*;

import java.util.ArrayList;

public class JukeboxBlock extends Block {

    public int track1;
    public int track2;
    public int track3;
    public int track4;
    public int track5;
    public int track6;
    public int track7;
    public int track8;
    public int track9;
    public int track10;
    public int track11;
    public int track12;
    public int track13;
    public int track14;
    public int track15;
    public int track16;

    public TextureRegion baseSprite;

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
        //Change item to track. Probably need to create a track class
        public @Nullable Item sortItem;

        @Override
        public void draw() {
            Draw.rect(baseSprite, x, y);
        }
    }

    //Make cool jukeboxy UI here. Also finish class to allow for choosing what sound files to
    //play based on an int array from 0 (stop sound) to 16. Should allow for easy customization.

    //Assign "track1", "track2", "track3", etc. to a numerical array. The tracks will be names of
    //soundfile tracks (inputted in JukeBlocks.java), but calculated with integers for logic compatibility
    //and flexibility.
}
