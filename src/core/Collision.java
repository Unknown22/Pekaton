package core;

import org.newdawn.slick.tiled.TiledMap;

public class Collision {

	public static boolean isCollision(int x, int y, TiledMap mapa){
		
		int kolizje = mapa.getLayerIndex("collisions");
		System.out.println(kolizje);
		if (mapa.getTileId(x, y, kolizje) == 0){
			return false;
		}
		else{
			return true;
		}
	}
}
