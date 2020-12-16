package jukeustry;

import arc.*;
import arc.scene.style.TextureRegionDrawable;
import arc.scene.ui.Dialog;
import arc.scene.ui.layout.Table;
import arc.util.*;
import mindustry.gen.*;
import mindustry.graphics.Pal;
import mindustry.mod.*;
import mindustry.ui.dialogs.*;

import jukeustry.content.JukeBlocks;
import jukeustry.content.JukeItems;

   public class Jukeustry extends Mod {
	   public static final String jukeustryName = "jukeustry-";

	   private void links(){
		   BaseDialog dialog = new BaseDialog("Links");
		   addLink(dialog.cont, Icon.github, "Github", "https://github.com/FarmerThanos/Jukeustry");
		   dialog.cont.button("Back", dialog::hide).size(120f, 60f);
		   dialog.show();
	   }

	   private void addLink(Table table, TextureRegionDrawable icon, String buttonName, String link){
		   table.button(buttonName, icon, () -> {
			   Dialog dialog = new Dialog("");
			   dialog.cont.pane(t -> {
				   t.add("[lightgray]Are you sure jump to this link: [accent]" + link + " [lightgray]?");
			   }).fillX().height(22f).row();
			   dialog.cont.image().fillX().pad(8).height(4f).color(Pal.accent).row();
			   dialog.cont.pane(t -> {
				   t.button("Yes", Icon.link, () -> Core.app.openURI(link)).size(220f, 60f);
				   t.button("No", Icon.cancel, dialog::hide).size(220f, 60f).pad(4);
			   }).fillX();
			   dialog.show();
		   }).size(180f, 60f).left().row();
	   }

	public Jukeustry() {
		Log.info("Loaded Jukeustry constructor.");
	}

	@Override
	public void loadContent() {
		Log.info("Loading Jukeustry content.");

		new JukeItems().load();
		new JukeBlocks().load();

		Log.info("Loaded Jukeustry content.");
	   }
}
