package jukeustry.content;

import arc.Core;
import arc.assets.AssetDescriptor;
import arc.assets.loaders.MusicLoader;
import arc.audio.Music;
import mindustry.Vars;

public class JukeMusic {
    protected static Music loadMusic(String musicName) {
        if (!Vars.headless) {
            String name = "assets/music/" + musicName;
            String path = name + ".ogg";

            Music music = new Music();

            AssetDescriptor<?> desc = Core.assets.load(path, Music.class, new MusicLoader.MusicParameter(music));
            desc.errored = Throwable::printStackTrace;

            return music;
        } else {
            return new Music();
        }
    }

    protected static Music disposeMusic(String musicName) {
        if (!Vars.headless) {
            String name = "assets/music/" + musicName;
            String path = name + ".ogg";

            if (Core.assets.isLoaded(path, Music.class)) {
                Core.assets.unload(path);
            }
        }

        return null;
    }

    public static Music
            //DOOM Episode 1
            S1W1, S1W2, S1W3, S1W4, S1W5, S1W6, S1W7, S1W8, S1W9,
            //DOOM Episode 2
            S2W1, S2W2, S2W3, S2W4,
            //DOOM Episode 3
            //Other
            TTDAW;

    public static void load() {
        //DOOM Episode 1
        S1W1 = loadMusic("S1W1");
        S1W2 = loadMusic("S1W2");
        S1W3 = loadMusic("S1W3");
        S1W4 = loadMusic("S1W4");
        S1W5 = loadMusic("S1W5");
        S1W6 = loadMusic("S1W6");
        S1W7 = loadMusic("S1W7");
        S1W8 = loadMusic("S1W8");
        S1W9 = loadMusic("S1W9");
        //DOOM Episode 2
        S2W1 = loadMusic("S2W1");
        S2W2 = loadMusic("S2W2");
        S2W3 = loadMusic("S2W3");
        S2W4 = loadMusic("S2W4");
        //Doom Episode 3
        //Other
        TTDAW = loadMusic("TTDAW");
    }

    public static void dispose() {
        //DOOM Episode 1
        S1W1 = disposeMusic("S1W1");
        S1W2 = disposeMusic("S1W2");
        S1W3 = disposeMusic("S1W3");
        S1W4 = disposeMusic("S1W4");
        S1W5 = disposeMusic("S1W5");
        S1W6 = disposeMusic("S1W6");
        S1W7 = disposeMusic("S1W7");
        S1W8 = disposeMusic("S1W8");
        S1W9 = disposeMusic("S1W9");
        //DOOM Episode 2
        S2W1 = disposeMusic("S2W1");
        S2W2 = disposeMusic("S2W2");
        S2W3 = disposeMusic("S2W3");
        S2W4 = disposeMusic("S2W4");
        //DOOM Episode 3
        //Other
        TTDAW = disposeMusic("TTDAW");
    }
}
