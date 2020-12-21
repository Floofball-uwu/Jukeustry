package jukeustry.content.world.blocks.logic;

import arc.Core;
import arc.audio.Music;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.TextureRegion;
import arc.struct.ObjectMap;
import arc.struct.Seq;
import mindustry.gen.Building;
import mindustry.gen.Musics;
import mindustry.world.*;
import mindustry.world.meta.*;

import java.util.HashMap;

public class JukeboxBlock extends Block {
    public TextureRegion baseSprite;

    public String tracks;

    String[] tracksCon = tracks.split(" ", 16);

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


    public HashMap<Integer, Track> trackList = new HashMap<Integer, Track>();
    Music t1 = new Track(track1);

    public class JukeboxBuild extends Building {

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
