package core;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.Image;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.util.ResourceLoader;
import org.newdawn.slick.Sound;


public class Resources {
	private static Map<String, Image> images;
	private static Map<String, SpriteSheet> spritesheets;
	private static Map<String, Music> music;
	private static Map<String, Sound> sound;
	private static Map<String, TiledMap> maps;
	
	public Resources()
	{
		images = new HashMap<String, Image>();
		maps=new HashMap<String,TiledMap>();
		spritesheets = new HashMap<String, SpriteSheet>();
		music= new HashMap<String,Music>();
		sound = new HashMap<String,Sound>();
		
		
		try {

			//spritesheets.put("dead", new SpriteSheet(loadImage("/dead.png"), 32, 32 ));
			spritesheets.put("worker", new SpriteSheet(loadImage("data/img/worker.png"), 15, 40 ));
			maps.put("mapa", new TiledMap("/data/map/office_1.tmx"));
			spritesheets.put("monitor", new SpriteSheet(loadImage("data/img/monitor.png"), Window.width, Window.height));
			spritesheets.put("monitor_window", new SpriteSheet(loadImage("data/img/monitor_window.png"), Window.width, Window.height));
			spritesheets.put("monitor_login", new SpriteSheet(loadImage("data/img/monitor_login.png"), Window.width, Window.height));

		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	private Image loadImage(String path) throws SlickException {
		// TODO Auto-generated method stub
		return new Image(path,false,Image.FILTER_NEAREST);
	}
	public static Image getImage(String type)
	{
		return images.get(type);
	}
	public static SpriteSheet getSpritesheet(String type)
	{
		return spritesheets.get(type);
	}
	public static Music getAudio(String name)
	{
		return music.get(name);
	}
	public static Sound getSound(String name)
	{
		return sound.get(name);
	}
	public static TiledMap getMap(String name)
	{
		return maps.get(name);
	}
	
}