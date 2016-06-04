package States;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.Input;

import core.Resources;

public class GameState extends BasicGameState {
	
	protected int worker1_x, worker1_y;
	protected int worker1_speed=20;
	
	protected Shape player;

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		// TODO Auto-generated method stub
		worker1_x=100;
		worker1_y=100;
		
		player = new Rectangle(worker1_x, worker1_y, 32, 32);

	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		
		//line to debug and bla bla other things
		drawDebugLines(g, 32);
		g.setColor(Color.cyan);
		g.draw(player);
		
		g.drawImage(Resources.getSpritesheet("worker").getSubImage(0, 0, 15, 40), worker1_x, worker1_y);
		
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int alpha) throws SlickException {
		// TODO Auto-generated method stub
		player.setLocation(worker1_x, worker1_y);
		
		if (gc.getInput().isKeyDown(Input.KEY_W) || gc.getInput().isKeyDown(Input.KEY_UP)) {
			worker1_y--;
			
		}
		
		if (gc.getInput().isKeyDown(Input.KEY_D) || gc.getInput().isKeyDown(Input.KEY_RIGHT)) {
			worker1_x++;
		
		}
		
		
		if (gc.getInput().isKeyDown(Input.KEY_S) || gc.getInput().isKeyDown(Input.KEY_DOWN)) {
			worker1_y++;
			
		}
		
		if (gc.getInput().isKeyDown(Input.KEY_A) || gc.getInput().isKeyDown(Input.KEY_LEFT)) {
			worker1_x--;
			
		}
		
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
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
