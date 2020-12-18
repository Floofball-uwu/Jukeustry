package jukeustry.content;

import jukeustry.content.world.blocks.crafting.JukeboxiteSmelter;
import mindustry.content.Items;
import mindustry.ctype.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.meta.*;

import static jukeustry.content.JukeItems.jukeboxite;
import static mindustry.content.Fx.*;
import static mindustry.type.ItemStack.*;


public class JukeBlocks implements ContentList {
    public static Block
            //production
            jukeboxiteSmelter;

    @Override
    public void load() {
        jukeboxiteSmelter = new JukeboxiteSmelter("jukeboxite-smelter") {{
            requirements(Category.crafting, BuildVisibility.shown, with(Items.lead, 165, Items.graphite, 65, Items.silicon, 45, Items.titanium, 110));
            size = 3;
            health = 300;
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
    }
}
