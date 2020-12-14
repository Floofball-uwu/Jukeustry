package jukeustry;

import arc.*;
import arc.util.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import mindustry.mod.*;
import mindustry.ui.dialogs.*;

    private final ContentList[] contents = {
        new JukeBlocks()
    };
    public boolean isDebug = false;
    
    public Jukeustry(){
        Events.on(ClientLoadEvent.class, e -> {
            Time.runTask(5f, () -> {
                Log.info(Core.bundle.get("startup"));
            });
        });
    }
    
    @Override
    public void init(){
        Vars.enableConsole = true;
    }
    
    @Override
    public void loadContent(){
        for(ContentList content : contents){
            content.load();
            Log.info("Loaded content: @", content.getClass().getSimpleName());
        }
    }
}
