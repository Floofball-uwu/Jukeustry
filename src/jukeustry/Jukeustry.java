package jukeustry;

import arc.util.*;
import mindustry.mod.*;

import jukeustry.content.JukeBlocks;
import jukeustry.content.JukeItems;

public class Jukeustry extends Mod {
    public static final String jukeustryName = "jukeustry-";

    @Override
    public void loadContent() {
        Log.info("Loading Jukeustry content.");

        new JukeItems().load();
        new JukeBlocks().load();

        Log.info("Loaded Jukeustry content.");
    }
}
