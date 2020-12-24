package jukeustry;

import arc.Events;
import arc.util.*;
import jukeustry.content.JukeSounds;
import mindustry.game.EventType;
import mindustry.mod.*;

import jukeustry.content.JukeBlocks;
import jukeustry.content.JukeItems;

public class Jukeustry extends Mod {
    public static final String jukeustryName = "jukeustry-";

    public Jukeustry() {
        JukeSounds.load();

        Events.on(EventType.DisposeEvent.class, e -> {
            JukeSounds.dispose();
        });
    }

    @Override
    public void loadContent() {
        Log.info("Loading Jukeustry content.");

        new JukeItems().load();
        new JukeBlocks().load();

        Log.info("Loaded Jukeustry content.");
    }
}
