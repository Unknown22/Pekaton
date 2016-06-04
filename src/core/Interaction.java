package core;

import org.newdawn.slick.tiled.TiledMap;

public class Interaction {

	public static int isInteraction(int x, int y, TiledMap mapa){

			int komputer = mapa.getLayerIndex("interaction1");
			int zadania = mapa.getLayerIndex("interaction2");
			
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
	
	public int checkInteraction(int x, int y, TiledMap mapa, int interakcja){
		interakcja = 0;
		
		if(mapa.getTileId((x+1)/32, y, interakcja) != 0){
			
		}
		
		return interakcja;
	}
}
