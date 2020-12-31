package jukeustry.content.world.blocks.logic;

import arc.Core;
import arc.audio.Music;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.TextureRegion;
import arc.math.Mathf;
import arc.util.Log;
import arc.util.Nullable;
import arc.util.io.Reads;
import arc.util.io.Writes;
import jukeustry.content.JukeMusic;
import mindustry.gen.Building;
import mindustry.logic.*;
import mindustry.world.*;
import mindustry.world.meta.*;

import static mindustry.logic.LAccess.*;

import java.util.HashMap;

public class JukeboxBlock extends Block {
    public TextureRegion baseSprite;
    public Music[] tracks = {};

    public JukeboxBlock(String name) {
        super(name);
        Log.info("Debug: Loading JukboxBlock 1");
        update = true;
        solid = true;
        configurable = true;
        group = BlockGroup.logic;
    }

    config(JukeMusic.class,(JukeboxBuild tile, Music music) ->tile.sortItem =item);

    @Override
    public void load() {
        Log.info("Debug: JukeboxBlock loaded 2");
        super.load();
        baseSprite = Core.atlas.find(name);
    }

    HashMap<Integer, Music> playlist = new HashMap<Integer, Music>();

    public class JukeboxBuild extends Building {
        public @Nullable
        double trackSelect = 0;
        public @Nullable
        boolean trackLoop = false;

        @Override
        public void draw() {
            Draw.rect(baseSprite, x, y);
        }

        @Override
        public double sense(LAccess sensor) {
            if (sensor == LAccess.configure) return trackSelect;
            return super.sense(sensor);
        }

        @Override
        public void control(LAccess type, double p1, double p2, double p3, double p4) {
            Log.info("Debug: control() loaded 3");
            if (type == configure) {
                trackSelect = p1;
                boolean trackLoop = false;

                if (trackSelect == -1) {
                    trackLoop = !Mathf.zero(p1);
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
                Music toPlay = playlist.get(trackSelect);
                JukeMusic.load();
                toPlay.play();
                Log.info("Debug: playlist loaded 4");
            }
        }

        @Override
        public Double config() {
            return trackSelect;
        }

        @Override
        public void write(Writes write) {
            super.write(write);

            write.d(trackSelect);
        }

        @Override
        public void read(Reads read, byte revision) {
            super.read(read, revision);

            trackSelect = read.f();
        }
    }
}
