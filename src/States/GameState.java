package States;
import org.newdawn.slick.Color;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import GameElements.Worker;

import org.newdawn.slick.Input;

import core.Collision;
import core.Engine;
import core.Interaction;
import core.Resources;
import core.Window;

import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class GameState extends BasicGameState {
	
	Shape player= new Rectangle(Worker.x*32, Worker.y*32, 32, 32);
	TiledMap mapa=Resources.getMap("mapa");
	int licznik = 0;
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		// TODO Auto-generated method stub
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		
		//line to debug and bla bla other things
		drawDebugLines(g, 32);
		g.setColor(Color.cyan);
		g.draw(player);
		mapa.render(0,0);
		g.drawImage(Resources.getSpritesheet("worker").getSubImage(0, 0, 15, 40), Worker.x*32, Worker.y*32);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int alpha) throws SlickException {
		// TODO Auto-generated method stub
		if (licznik < 10){
			licznik++;
		} else {
			licznik = 0;

		player.setLocation(Worker.x * 32, Worker.y * 32);
		
		if (gc.getInput().isKeyDown(Input.KEY_W) || gc.getInput().isKeyDown(Input.KEY_UP)) {

			if (!Collision.isCollision(Worker.x, Worker.y-1, mapa)){
				Worker.y--;
			}	
		}
		
		if (gc.getInput().isKeyDown(Input.KEY_D) || gc.getInput().isKeyDown(Input.KEY_RIGHT)) {
			if (!Collision.isCollision(Worker.x+1, Worker.y, mapa)){
				Worker.x++;
			}
		}
		
		
		if (gc.getInput().isKeyDown(Input.KEY_S) || gc.getInput().isKeyDown(Input.KEY_DOWN)) {
			if (!Collision.isCollision(Worker.x, Worker.y+1, mapa)){
				Worker.y++;
			}
		}
		
		if (gc.getInput().isKeyDown(Input.KEY_A) || gc.getInput().isKeyDown(Input.KEY_LEFT)) {
			if (!Collision.isCollision(Worker.x-1, Worker.y, mapa)){
				Worker.x--;
			}
		}
		
		if(gc.getInput().isKeyPressed(Input.KEY_SPACE)){
			int interaction_id = Interaction.isInteraction(Worker.x, Worker.y, mapa);
//			System.out.println(interaction_id);
			if(interaction_id!=0)
			{
				if(Worker.id!=-1)
					sbg.enterState(StatesCodes.WORKERSTATE);
				else
					sbg.enterState(StatesCodes.LOGINSTATE);
			}
				
			System.out.println(interaction_id);
		}

		}
		
		if(gc.getInput().isKeyPressed(Input.KEY_L)){
			sbg.enterState(StatesCodes.WORKERSTATE);
		}
		
		if(gc.getInput().isKeyPressed(Input.KEY_K)){
			sbg.enterState(StatesCodes.LOGINSTATE);
		}
		
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return StatesCodes.GAMESTATE;
	}
	
	protected void drawDebugLines(Graphics g, int i) {

		int resolution = 800;
		g.setColor(Color.red);
		for (int a = 0; a < resolution; a = a + i) {
			g.drawLine(a, 0, a, resolution);
			g.drawLine(0, a, resolution, a);
		}

	}


}
