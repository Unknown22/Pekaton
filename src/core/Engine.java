package core;

import java.io.File;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
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
			app.setDisplayMode(Window.width, Window.height,  false);
			app.start();
			
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		// TODO Auto-generated method stub
		gc.setAlwaysRender(true);
		gc.setTargetFrameRate(60);
		gc.setVSync(true);
		new Resources();
		
		ClassesInstances.gameState=new States.GameState();
		ClassesInstances.workerStatState=new States.WorkerStatState();
		ClassesInstances.loginState=new States.LoginState();

		ClassesInstances.newTaskState=new States.NewTaskState();
		ClassesInstances.creditsState=new States.CreditsState();



			
		this.addState(ClassesInstances.gameState);
		this.addState(ClassesInstances.workerStatState);
		this.addState(ClassesInstances.loginState);
		this.addState(ClassesInstances.newTaskState);
		this.addState(ClassesInstances.creditsState);

		

		
		
	}
}