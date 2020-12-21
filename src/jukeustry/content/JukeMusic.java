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
            S1W1,
            S1W2;

    public static void load() {
        S1W1 = loadMusic("S1W1");
        S1W2 = loadMusic("S1W2");
    }

    public static void dispose() {
        S1W1 = disposeMusic("S1W1");
        S1W2 = disposeMusic("S1W2");
    }
}
