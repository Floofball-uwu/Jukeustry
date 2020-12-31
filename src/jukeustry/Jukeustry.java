package jukeustry;

import arc.Events;
import arc.util.*;
import jukeustry.content.JukeMusic;
import mindustry.game.EventType;
import mindustry.mod.*;

import jukeustry.content.JukeBlocks;
import jukeustry.content.JukeItems;

public class Jukeustry extends Mod {
    public static final String jukeustryName = "jukeustry-";

    public Jukeustry() {
        JukeMusic.load();

        Events.on(EventType.DisposeEvent.class, e -> {
            JukeMusic.dispose();
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
