package jukeustry.content;


import arc.graphics.*;
import mindustry.ctype.*;
import mindustry.type.*;

public class JukeItems implements ContentList{
    public static Item jukeboxite;

    @Override
    public void load(){
        jukeboxite = new Item("jukeboxite", Color.valueOf("854b04")){{
           //hardness = 1;
            // radioactivity = 0f;
            //flammability = 0f;
            //explosiveness = 0f;
            //alwaysUnlocked = false;
           cost = 2.25f;
        }};
    }
}
