package core;

import java.io.File;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;


public class Engine extends StateBasedGame{

	public Engine() {
		super("Nadia Romanov");
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args)
	{
		File f = new File("natives");
		if(f.exists())System.setProperty("org.lwjgl.librarypath", f.getAbsolutePath());
		try {
			AppGameContainer app=new AppGameContainer(new Engine());
			app.setDisplayMode(Window.height, Window.width, false);
			app.start();
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {
		// TODO Auto-generated method stub
		
	}
}