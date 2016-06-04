package core;

import org.newdawn.slick.tiled.TiledMap;

public class Interaction {

	public static int isInteraction(int x, int y, TiledMap mapa){

			int interaction1 = mapa.getLayerIndex("interaction1");
			int interaction2 = mapa.getLayerIndex("interaction2");
			
			if (checkInteraction(x, y, mapa, interaction1) != 0){
				return 1;
			}
			else if(checkInteraction(x, y, mapa, interaction2) != 0){
				return 2;
			}
			else{
				return 0;
			}
	}
	
	public static int checkInteraction(int x, int y, TiledMap mapa, int interakcja){
		int inter = 0;
		
		if(mapa.getTileId(x+1, y, interakcja) != 0 ||
				mapa.getTileId(x-1, y, interakcja) != 0 ||
				mapa.getTileId(x, y+1, interakcja) != 0 ||
				mapa.getTileId(x, y-1, interakcja) != 0){
			inter = 1;
		}
		
		return inter;
	}
}
