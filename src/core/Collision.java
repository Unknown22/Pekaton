package core;

import org.newdawn.slick.tiled.TiledMap;

public class Collision {

	public static boolean isCollision(int x, int y, TiledMap mapa){
		
		int kolizje = mapa.getLayerIndex("elements");
		int kolizje2 = mapa.getLayerIndex("sciany");
		
//		System.out.println(kolizje);
//		System.out.println(kolizje2);
//		System.out.println(mapa.getTileId(x, y, kolizje));
//		System.out.println(mapa.getTileId(x, y, kolizje2));

		
		if (mapa.getTileId(x, y, kolizje) != 0){
//			System.out.println("Konflikt z elements");
			return true;
		}
		if(mapa.getTileId(x, y, kolizje2) != 0 ){
//			System.out.println("Konflikt z sciany");
			return true;
		}
		else{
			return false;
		}
	}
}
