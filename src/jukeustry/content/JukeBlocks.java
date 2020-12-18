package jukeustry.content;

import arc.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.struct.*;
import arc.util.Log;
import arc.util.Time;
import mindustry.*;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.ctype.*;
import mindustry.entities.bullet.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.*;
import mindustry.world.blocks.campaign.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.legacy.*;
import mindustry.world.blocks.liquid.*;
import mindustry.world.blocks.logic.*;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.sandbox.*;
import mindustry.world.blocks.storage.*;
import mindustry.world.blocks.units.*;
import mindustry.world.consumers.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;

import static jukeustry.content.JukeItems.jukeboxite;
import static mindustry.content.Fx.*;
import static mindustry.type.ItemStack.*;


public class JukeBlocks implements ContentList{
    public static Block
    //production
    jukeboxiteSmelter;

    @Override
    public void load(){
        Log.info("Jukeboxite Smelter here.");
        jukeboxiteSmelter = new GenericSmelter("jukeboxite-smelter"){{
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
