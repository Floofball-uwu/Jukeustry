package jukeustry.content.world.blocks.logic;

import arc.Core;
import arc.audio.Music;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.TextureRegion;
import arc.math.Mathf;
import arc.scene.style.TextureRegionDrawable;
import arc.scene.ui.layout.Table;
import arc.util.Log;
import arc.util.Nullable;
import arc.util.io.Reads;
import arc.util.io.Writes;
import jukeustry.content.JukeMusic;
import mindustry.gen.Building;
import mindustry.gen.Unit;
import mindustry.logic.*;
import mindustry.ui.Styles;
import mindustry.world.*;
import mindustry.world.meta.*;

import static jukeustry.content.JukeMusic.S1W1;
import static mindustry.Vars.headless;
import static mindustry.Vars.renderer;
import static mindustry.logic.LAccess.*;

import java.util.HashMap;

//Make HASHMAP that adds new playlist.put() depending on tracks input count


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

    @Override
    public void load() {
        Log.info("Debug: JukeboxBlock loaded 2");
        super.load();
        baseSprite = Core.atlas.find(name);
    }

    HashMap<Integer, Music> playlist = new HashMap<Integer, Music>();

    public class JukeboxBuild extends Building {
        public @Nullable
        double trackSelect = 1;
        public @Nullable
        boolean trackLoop = false;
        boolean trackPaused = true;
        Music toPlay = tracks[(int)Math.round(trackSelect)-1];

        @Override
        public void draw() {
            Draw.rect(baseSprite, x, y);
        }


        @Override
        public void configured(Unit player, Object value){
            super.configured(player, value);

            if(!headless){
                renderer.minimap.update(tile);
            }
        }

        @Override
        public void buildConfiguration(Table table){
            this.rebuild(table);
        }
        public void rebuild(Table table){
            table.clearChildren();
            table.button(new TextureRegionDrawable(Core.atlas.find("jukeustry-skip-backward-icon")),
                    Styles.clearTransi,
                    () -> {
                        toPlay.stop();
                        trackSelect--;
                        if(trackSelect < 1){
                            trackSelect = 1;
                        } else {
                            toPlay = tracks[((int) Math.round(trackSelect) - 1)];
                        }
                        toPlay.play();
                    });
            table.button(new TextureRegionDrawable(trackPaused ? Core.atlas.find("jukeustry-pause-icon") : Core.atlas.find("jukeustry-play-icon")),
                    Styles.clearTransi,
                    () -> {
                        if (toPlay.isPlaying()){
                            toPlay.pause(true);
                            trackPaused = true;
                        } else {
                            toPlay.play();
                            trackPaused = false;
                        }
                        this.rebuild(table);
                    });
            table.button(new TextureRegionDrawable(Core.atlas.find("jukeustry-skip-forward-icon")),
                    Styles.clearTransi,
                    () -> {
                        toPlay.stop();
                        trackSelect++;
                        if(trackSelect > tracks.length){
                            trackSelect = tracks.length;
                        } else {
                            toPlay = tracks[((int) Math.round(trackSelect) - 1)];
                        }
                        toPlay.play();
                    });
            table.button(new TextureRegionDrawable(trackLoop ? Core.atlas.find("jukeustry-loop-on-icon") : Core.atlas.find("jukeustry-loop-off-icon")),
                    Styles.clearTransi,
                    () -> {
                        if (trackLoop == true) {
                            trackLoop = false;
                            toPlay.setLooping(true);
                        } else {
                            trackLoop = true;
                            toPlay.setLooping(false);
                        }
                        this.rebuild(table);
                    });
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
                    Music toPlay = playlist.get((int)Math.round(trackSelect));
                    JukeMusic.load();
                    toPlay.play();
                }
                Log.info("Debug: playlist loaded 4");
            }
        }
    }
}
