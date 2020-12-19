package jukeustry.content.world.blocks.logic;

import mindustry.world.*;
import mindustry.world.meta.*;

import java.util.ArrayList;

public class JukeboxBlock extends Block {

    public int track1;
    public int track2;
    public int track3;

    public JukeboxBlock(String name) {

        super(name);
        update = true;
        solid = true;
        configurable = true;
        group = BlockGroup.logic;
    }
    //Make cool jukeboxy UI here. Also finish class to allow for choosing what sound files to
    //play based on an int array from 0 (stop sound) to 16. Should allow for easy customization.

    //Assign "track1", "track2", "track3", etc. to a numerical array. The tracks will be names of
    //soundfile tracks (inputted in JukeBlocks.java), but calculated with integers for logic compatibility
    //and flexibility.
}
