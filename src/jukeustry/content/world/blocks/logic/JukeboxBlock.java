package jukeustry.content.world.blocks.logic;

import arc.Core;
import arc.audio.Music;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.TextureRegion;
import arc.scene.style.TextureRegionDrawable;
import arc.scene.ui.layout.Table;
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

import static mindustry.Vars.headless;
import static mindustry.Vars.renderer;
import static mindustry.logic.LAccess.*;

import java.util.HashMap;


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

    HashMap<Integer, Music> playlist = new HashMap<Integer, Music>();

    public class JukeboxBuild extends Building {
        public @Nullable
        double trackSelect = 1;
        public @Nullable
        int trackLoop = 0;
        boolean trackLoopB = false;
        int trackLoopCTRL = 0;
        boolean trackPaused = true;
        String loopIcon = "jukeustry-loop-off-icon";
        Music toPlay = tracks[(int) Math.round(trackSelect) - 1];

        @Override
        public void draw() {
            Draw.rect(baseSprite, x, y);
        }


        @Override
        public void configured(Unit player, Object value) {
            super.configured(player, value);

            if (!headless) {
                renderer.minimap.update(tile);
            }
        }

        @Override
        public void buildConfiguration(Table table) {
            this.rebuild(table);
        }

        public void rebuild(Table table) {
            table.clearChildren();
            table.button(new TextureRegionDrawable(Core.atlas.find("jukeustry-skip-backward-icon")),
                    Styles.clearTransi,
                    () -> {
                        toPlay.stop();
                        trackSelect--;
                        if (trackSelect < 1) {
                            trackSelect = 1;
                        } else {
                            toPlay = tracks[((int) Math.round(trackSelect) - 1)];
                        }
                        toPlay.play();
                    });
            table.button(new TextureRegionDrawable(trackPaused ? Core.atlas.find("jukeustry-pause-icon") : Core.atlas.find("jukeustry-play-icon")),
                    Styles.clearTransi,
                    () -> {
                        if (toPlay.isPlaying()) {
                            toPlay.pause(true);
                            trackPaused = true;
                        } else {
                            toPlay.setLooping(trackLoopB);
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
                        if (trackSelect > tracks.length) {
                            trackSelect = tracks.length;
                        } else {
                            toPlay = tracks[((int) Math.round(trackSelect) - 1)];
                        }
                        toPlay.play();
                    });
            table.button(new TextureRegionDrawable(Core.atlas.find(loopIcon)),
                    Styles.clearTransi,
                    () -> {
                        switch (trackLoopCTRL) {
                            case 0:
                                trackLoopB = false;
                                trackLoop = 0;
                                trackLoopCTRL = 1;
                                loopIcon = "jukeustry-loop-off-icon";
                                break;
                            case 1:
                                trackLoopB = false;
                                trackLoop = 1;
                                trackLoopCTRL = 2;
                                loopIcon = "jukeustry-loop-all-icon";
                                break;
                            case 2:
                                trackLoopB = true;
                                trackLoop = 2;
                                trackLoopCTRL = 0;
                                loopIcon = "jukeustry-loop-one-icon";
                                break;
                        }
                        if (!trackPaused && !toPlay.isPlaying()) {
                            for (int i = 0; i < tracks.length; i++) {
                                trackSelect++;
                                if (trackSelect > tracks.length - 1) {
                                    trackSelect = 0;
                                }
                                toPlay = tracks[((int) Math.round(trackSelect) - 1)];
                                toPlay.play();
                            }
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
            if (type == configure) {
                trackSelect = p1;
                boolean trackLoop = false;

                Music toPlay = tracks[((int) Math.round(trackSelect) - 1)];
                toPlay.play();
            }
        }
    }
}
