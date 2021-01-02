package jukeustry.content;

import jukeustry.content.world.blocks.crafting.JukeboxiteSmelter;
import jukeustry.content.world.blocks.logic.JukeboxBlock;
import mindustry.content.Items;
import mindustry.ctype.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.meta.*;

import static jukeustry.content.JukeItems.jukeboxite;
import static jukeustry.content.JukeMusic.*;
import static mindustry.content.Fx.*;
import static mindustry.type.ItemStack.*;


public class JukeBlocks implements ContentList {
    public static Block
            //production
            jukeboxiteSmelter,
    //logic
    jukeboxDoom, jukeboxOther;

    @Override
    public void load() {
        jukeboxiteSmelter = new JukeboxiteSmelter("jukeboxite-smelter") {{
            requirements(Category.crafting, BuildVisibility.shown, with(Items.lead, 165, Items.graphite, 65, Items.silicon, 45, Items.titanium, 110));
            size = 3;
            health = 360;
            hasPower = true;
            hasLiquids = false;
            hasItems = true;
            itemCapacity = 30;
            updateEffect = plasticburn;
            craftEffect = producesmoke;
            outputItem = new ItemStack(jukeboxite, 3);
            craftTime = 100f;

            consumes.power(1.7f);
            consumes.items(with(Items.copper, 4, Items.titanium, 1, Items.metaglass, 2));
        }};

        jukeboxDoom = new JukeboxBlock("jukebox-doom") {{
            requirements(Category.logic, BuildVisibility.shown, with(JukeItems.jukeboxite, 130, Items.copper, 200, Items.lead, 170, Items.silicon, 80, Items.graphite, 100));
            size = 2;
            health = 160;

            tracks = new arc.audio.Music[]{S1W1, S1W2, S1W3, S1W4, S1W5, S1W6, S1W7, S1W8, S1W9, S2W1, S2W2, S2W3, S2W4};
        }};

        jukeboxOther = new JukeboxBlock("jukebox-other") {{
            requirements(Category.logic, BuildVisibility.shown, with(JukeItems.jukeboxite, 130, Items.copper, 200, Items.lead, 170, Items.silicon, 80, Items.graphite, 100));
            size = 2;
            health = 160;

            tracks = new arc.audio.Music[]{TTDAW};
        }};
    }
}
