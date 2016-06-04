package core;

import org.newdawn.slick.tiled.TiledMap;

public class Interaction {

	public static int isInteraction(int x, int y, TiledMap mapa){

			int komputer = mapa.getLayerIndex("Komputer");
			int zadania = mapa.getLayerIndex("Zadania");
			
			if (mapa.getTileId(x, y, komputer) != 0){
				return 1;
			}
			else if(mapa.getTileId(x, y, zadania) != 0){
				return 2;
			}
			else{
				return 0;
			}
	}
}
