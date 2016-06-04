package States;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import core.Window;
import model.Pracownik;
import database.DataBase;

public class WorkerStatState extends BasicGameState {

	DataBase db = new DataBase();
	int margin=30;
	int cellMargin=10;
	Pracownik pracownik=db.getPracownikByID(1);
	Shape tableAll=new Rectangle(margin, margin, Window.width-margin*2, Window.height-margin*2);
	int cellWidth=(Window.width-margin*2)/3;
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		// TODO Auto-generated method stub
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		// TODO Auto-generated method stub

		g.draw(tableAll);
		
		g.drawString(pracownik.getLogin(), Window.width/2-margin, 50);
		g.drawString("ID", margin+cellMargin, 100);
		g.drawString("Stanowisko", margin+cellMargin+cellWidth, 100);
		g.drawString("Doœwiadczenie", margin+cellMargin+cellWidth*2, 100);
		
		g.drawString(Integer.toString(pracownik.getId()), margin+cellMargin, 150);
		g.drawString(pracownik.getStanowisko(), margin+cellMargin+cellWidth, 150);
		g.drawString(Integer.toString(pracownik.getExp()), margin+cellMargin+cellWidth*2, 150);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int alpha) throws SlickException {
		// TODO Auto-generated method stub
		if(gc.getInput().isKeyPressed(Input.KEY_L) || gc.getInput().isKeyPressed(Input.KEY_ESCAPE)){
			sbg.enterState(StatesCodes.GAMESTATE);
		}
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return StatesCodes.WORKERSTATE;
	}

}
