package jukeustry.content.world.blocks.logic;

import mindustry.world.*;
import mindustry.world.meta.*;

public class JukeboxBlock extends Block {
    public JukeboxBlock(String name) {

        super(name);
        update = true;
        solid = true;
        configurable = true;
        group = BlockGroup.logic;
    }
    //Make cool jukeboxy UI here. Also finish class to allow for choosing what sound files to
    //play based on an int array from 0 (stop sound) to 16. Should allow for easy customization.
}
