package States;
import org.newdawn.slick.Color;
import org.newdawn.slick.Animation;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
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
import database.DataBase;

import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class GameState extends BasicGameState {
	
	//Shape player= new Rectangle(Worker.x*32, Worker.y*32, 32, 32);
	TiledMap mapa=Resources.getMap("mapa");
	DataBase baza = new DataBase();

	int licznik = 0;
	
	float przesuw_x = 0.0f;
	float przesuw_y = 0.0f;
	
    Animation boss;
    Animation w_right;
    Animation w_left;
    Animation w_front;
    Animation w_back;
    Animation mark;
    
    SpriteSheet boss_s;
    SpriteSheet w_front_s;
    SpriteSheet w_back_s;
    SpriteSheet w_right_s;
    SpriteSheet w_left_s;
    SpriteSheet mark_s;
    
    private int direction;
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		// TODO Auto-generated method stub
//	      w_back.setAutoUpdate(true);
//	      w_front.setAutoUpdate(true);
//	      w_left.setAutoUpdate(true);
//	      w_right.setAutoUpdate(true);
		
	      
	      boss_s = new SpriteSheet(Resources.getSpritesheet("boss"), 35, 40);
	      boss = new Animation(boss_s,100);
	      
	      w_front_s = new SpriteSheet(Resources.getSpritesheet("w_front"), 35, 40);
	      w_front = new Animation(w_front_s,100);
	      
	      w_back_s = new SpriteSheet(Resources.getSpritesheet("w_back"), 35, 40);
	      w_back = new Animation(w_back_s,100);
	      
	      w_right_s = new SpriteSheet(Resources.getSpritesheet("w_right"), 35, 40);
	      w_right = new Animation(w_right_s,100);
	      
	      w_left_s = new SpriteSheet(Resources.getSpritesheet("w_left"), 35, 40);
	      w_left = new Animation(w_left_s,100);
	      
	      mark_s = new SpriteSheet(Resources.getSpritesheet("mark"), 32, 32);
	      mark = new Animation(mark_s,100);
	      
	      direction = 6;
	      
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		
		//line to debug and bla bla other things
//		drawDebugLines(g, 32);

//		g.setColor(Color.cyan);
//		g.draw(player);

		mapa.render(0,0);
		//g.drawImage(Resources.getSpritesheet("boss").getSubImage(0,0,35,40), Worker.pozycja_x, Worker.pozycja_y);

		
		if(!baza.getWolneZadania().isEmpty()){
			boss.draw(224, 535);
			mark.draw(224, 500);
		}
		else{
			g.drawImage(Resources.getSpritesheet("boss").getSubImage(35,0,35,40), 224, 535);

		}

		switch(direction){
		case 0:
			w_back.draw(Worker.pozycja_x,Worker.pozycja_y);
			break;
		case 1:
			w_right.draw(Worker.pozycja_x,Worker.pozycja_y);
			break;
		case 2:
			w_front.draw(Worker.pozycja_x,Worker.pozycja_y);
			break;
		case 3:
			w_left.draw(Worker.pozycja_x,Worker.pozycja_y);
			break;
		case 4:
			g.drawImage(Resources.getSpritesheet("w_back").getSubImage(35,0,35,40), Worker.pozycja_x, Worker.pozycja_y);
			break;
		case 5:
			g.drawImage(Resources.getSpritesheet("w_right").getSubImage(35,0,35,40), Worker.pozycja_x, Worker.pozycja_y);
			break;
		case 6:
			g.drawImage(Resources.getSpritesheet("w_front").getSubImage(35,0,35,40), Worker.pozycja_x, Worker.pozycja_y);
			break;
		case 7:
			g.drawImage(Resources.getSpritesheet("w_left").getSubImage(35,0,35,40), Worker.pozycja_x, Worker.pozycja_y);
			break;
			
			default:
				break;
		}

	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int alpha) throws SlickException {
		// TODO Auto-generated method stub
		if (licznik < 10){
			Worker.pozycja_x = Worker.pozycja_x + przesuw_x;
			Worker.pozycja_y = Worker.pozycja_y + przesuw_y;
			licznik++;
		} else {
			Worker.pozycja_x = Worker.x * 32;
			Worker.pozycja_y = Worker.y * 32;
//			System.out.println(Worker.pozycja_x);
//			System.out.println(Worker.pozycja_y);
			przesuw_x = 0.0f;
			przesuw_y = 0.0f;
			licznik = 0;

		//player.setLocation(Worker.x * 32, Worker.y * 32);
		
		if (gc.getInput().isKeyDown(Input.KEY_W) || gc.getInput().isKeyDown(Input.KEY_UP)) {

			if (!Collision.isCollision(Worker.x, Worker.y-1, mapa)){
				przesuw_y = -3.2f;
				Worker.y--;
				direction = 0;
			}	
		}
		
		if (gc.getInput().isKeyDown(Input.KEY_D) || gc.getInput().isKeyDown(Input.KEY_RIGHT)) {
			if (!Collision.isCollision(Worker.x+1, Worker.y, mapa)){
				przesuw_x = 3.2f;
				Worker.x++;
				direction = 1;
			}
		}
		
		
		if (gc.getInput().isKeyDown(Input.KEY_S) || gc.getInput().isKeyDown(Input.KEY_DOWN)) {
			if (!Collision.isCollision(Worker.x, Worker.y+1, mapa)){
				przesuw_y = 3.2f;
				Worker.y++;
				direction = 2;
			}
		}
		
		if (gc.getInput().isKeyDown(Input.KEY_A) || gc.getInput().isKeyDown(Input.KEY_LEFT)) {
			if (!Collision.isCollision(Worker.x-1, Worker.y, mapa)){
				przesuw_x = -3.2f;
				Worker.x--;
				direction = 3;
			}
		}
		
		if (gc.getInput().isKeyDown(Input.KEY_A) && gc.getInput().isKeyDown(Input.KEY_C)) {
				sbg.enterState(StatesCodes.CREDITSSTATE);
			
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

			if(interaction_id==1)
			{
				if(Worker.id!=-1)
					sbg.enterState(StatesCodes.WORKERSTATE);
				else
					sbg.enterState(StatesCodes.LOGINSTATE);
			}
			else if(interaction_id==2)
			{
				if(Worker.id!=-1)
					sbg.enterState(StatesCodes.NEWTASKSTATE);
				else
					sbg.enterState(StatesCodes.LOGINSTATE);
			}
				
			//System.out.println(interaction_id);
		}

		}
		

		if(gc.getInput().isKeyPressed(Input.KEY_L)){
			sbg.enterState(StatesCodes.WORKERSTATE);
		}
		
		if(gc.getInput().isKeyPressed(Input.KEY_K)){
			sbg.enterState(StatesCodes.LOGINSTATE);
		}
	if(przesuw_x == 0.0f && przesuw_y == 0.0f){
		checkStableDirection();
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
	
	private void checkStableDirection(){
		if(direction == 0){
			direction = 4;
		}
		else if(direction == 1){
			direction = 5;
		}
		else if(direction == 2){
			direction = 6;
		}
		else if(direction == 3){
			direction = 7;
		}
	}


}
