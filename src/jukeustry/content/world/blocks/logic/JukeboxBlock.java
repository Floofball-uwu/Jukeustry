package jukeustry.content.world.blocks.logic;

import arc.Core;
import arc.audio.Sound;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.TextureRegion;
import arc.math.Mathf;
import arc.util.io.Reads;
import arc.util.io.Writes;
import jukeustry.content.JukeSounds;
import mindustry.gen.Building;
import mindustry.logic.*;
import mindustry.world.*;
import mindustry.world.meta.*;

import static mindustry.logic.LAccess.*;

import java.util.HashMap;

public class JukeboxBlock extends Block {
    public TextureRegion baseSprite;
    public Sound[] tracks = {};

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

    HashMap<Integer, Sound> playlist = new HashMap<Integer, Sound>();

    public class JukeboxBuild extends Building {
        public double trackSelect = 0;
        public boolean trackLoop = false;


        @Override
        public void draw() {
            Draw.rect(baseSprite, x, y);
        }

        @Override
        public void control(LAccess type, double p1, double p2, double p3, double p4) {
            if (type == configure) {
                trackSelect = p1;
                trackLoop = !Mathf.zero(p2);

                if (trackSelect == -1) {
                    //switch loop
                } else if (trackSelect == 0) {
                    //stop music
                } else {
                    playlist.put(1, tracks[0]);
                    playlist.put(2, tracks[1]);
                    playlist.put(3, tracks[2]);
                    playlist.put(4, tracks[3]);
                    playlist.put(5, tracks[4]);
                    playlist.put(6, tracks[5]);
                    playlist.put(7, tracks[6]);
                    playlist.put(8, tracks[7]);
                    playlist.put(9, tracks[8]);
                    playlist.put(10, tracks[9]);
                    playlist.put(11, tracks[10]);
                    playlist.put(12, tracks[11]);
                    playlist.put(13, tracks[12]);
                    playlist.put(14, tracks[13]);
                    playlist.put(15, tracks[14]);
                    playlist.put(16, tracks[15]);
                }
                Sound toPlay = playlist.get(trackSelect);
                JukeSounds.load();
                JukeSounds.S1W1.at(this.x, this.y);
            }
        }
    }

    /*@Override
    public void write(Writes write) {
        super.write(write);

        write.double(trackSelect);
    }

    @Override
    public void read(Reads read) {
        super.read(read);

        trackSelect = read.i();
    } */
}

//Make cool jukeboxy UI here. Also finish class to allow for choosing what sound files to
//play based on an int array from 0 (stop sound) to 16. Should allow for easy customization.

//Assign "track1", "track2", "track3", etc. to a numerical array. The tracks will be names of
//soundfile tracks (inputted in JukeBlocks.java), but calculated with integers for logic compatibility
//and flexibility.
