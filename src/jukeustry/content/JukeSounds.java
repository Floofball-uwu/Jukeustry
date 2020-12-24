package jukeustry.content;

import arc.Core;
import arc.assets.AssetDescriptor;
import arc.assets.loaders.SoundLoader;
import arc.audio.Sound;
import mindustry.Vars;

public class JukeSounds {
    protected static Sound loadSound(String soundName) {
        if (!Vars.headless) {
            String name = "assets/music/" + soundName;
            String path = name + ".ogg";

            Sound sound = new Sound();

            AssetDescriptor<?> desc = Core.assets.load(path, Sound.class, new SoundLoader.SoundParameter(sound));
            desc.errored = Throwable::printStackTrace;

            return sound;
        } else {
            return new Sound();
        }
    }

    protected static Sound disposeSound(String soundName) {
        if (!Vars.headless) {
            String name = "assets/music/" + soundName;
            String path = name + ".ogg";

            if (Core.assets.isLoaded(path, Sound.class)) {
                Core.assets.unload(path);
            }
        }

        return null;
    }

    public static Sound
            //DOOM Episode 1
            S1W1, S1W2, S1W3, S1W4, S1W5, S1W6, S1W7, S1W8, S1W9,
            //DOOM Episode 2
            S2W1, S2W2, S2W3, S2W4,
            //DOOM Episode 3
            //Other
            TTDAW;

    public static void load() {
        //DOOM Episode 1
        S1W1 = loadSound("S1W1");
        S1W2 = loadSound("S1W2");
        S1W3 = loadSound("S1W3");
        S1W4 = loadSound("S1W4");
        S1W5 = loadSound("S1W5");
        S1W6 = loadSound("S1W6");
        S1W7 = loadSound("S1W7");
        S1W8 = loadSound("S1W8");
        S1W9 = loadSound("S1W9");
        //DOOM Episode 2
        S2W1 = loadSound("S2W1");
        S2W2 = loadSound("S2W2");
        S2W3 = loadSound("S2W3");
        S2W4 = loadSound("S2W4");
        //Doom Episode 3
        //Other
        TTDAW = loadSound("TTDAW");
    }

    public static void dispose() {
        //DOOM Episode 1
        S1W1 = disposeSound("S1W1");
        S1W2 = disposeSound("S1W2");
        S1W3 = disposeSound("S1W3");
        S1W4 = disposeSound("S1W4");
        S1W5 = disposeSound("S1W5");
        S1W6 = disposeSound("S1W6");
        S1W7 = disposeSound("S1W7");
        S1W8 = disposeSound("S1W8");
        S1W9 = disposeSound("S1W9");
        //DOOM Episode 2
        S2W1 = disposeSound("S2W1");
        S2W2 = disposeSound("S2W2");
        S2W3 = disposeSound("S2W3");
        S2W4 = disposeSound("S2W4");
        //DOOM Episode 3
        //Other
        TTDAW = disposeSound("TTDAW");
    }
}
