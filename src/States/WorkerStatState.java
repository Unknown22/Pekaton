package States;

import java.util.ArrayList;

import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import core.Window;
import model.Pracownik;
import model.Zadanie;
import database.DataBase;

public class WorkerStatState extends BasicGameState {

	DataBase db = new DataBase();
	int margin=30;
	int cellMargin=10;
	Pracownik pracownik=db.getPracownikByID(1);
	ArrayList<Zadanie> zadania = (ArrayList<Zadanie>) db.getZadaniaByPracownikId(1);
	Shape tableAll=new Rectangle(margin, margin, Window.width-margin*2, Window.height-margin*2);
	int cellWidth=(Window.width-margin*2)/3;
	int cellWidth2=(Window.width-margin*2)/4;
	Font font = new Font("Poster Bodoni", Font.PLAIN, 20);
	TrueTypeFont ttf = new TrueTypeFont(font, true);
	
	
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		g.setColor(Color.blue);
		g.draw(tableAll);
		
		g.setFont(ttf);
		g.setColor(Color.blue);
		g.drawString(pracownik.getLogin(), Window.width/2-margin, 50);
		g.setColor(Color.cyan);
		g.drawString("ID", margin+cellMargin, 100);
		g.drawString("Stanowisko", margin+cellMargin+cellWidth, 100);
		g.drawString("Doœwiadczenie", margin+cellMargin+cellWidth*2, 100);
		
		g.setColor(Color.darkGray);
		g.drawString(Integer.toString(pracownik.getId()), margin+cellMargin, 150);
		g.drawString(pracownik.getStanowisko(), margin+cellMargin+cellWidth, 150);
		g.drawString(Integer.toString(pracownik.getExp()), margin+cellMargin+cellWidth*2, 150);
		
		g.setColor(Color.blue);
		g.drawString("Zadania", Window.width/2-margin, 200);
		
		
		for(int i=0; i<zadania.size(); i++){
			g.setColor(Color.cyan);
			g.drawString(zadania.get(i).getOpis(), margin+cellMargin, 250+i*100);
			g.setColor(Color.darkGray);
			g.drawString(Integer.toString(zadania.get(i).getDoswiadczenie()), margin+cellMargin, 275+i*100);
			g.drawString(zadania.get(i).getZleceniodawca(), margin+cellMargin, 300+i*100);
			if(zadania.get(i).getStatus()==0)
			{
				g.setColor(Color.red);
				g.drawString("Niewykonane", margin+cellMargin, 325+i*100);
			}
				
			else
			{
				g.setColor(Color.green);
				g.drawString("Wykonane", margin+cellMargin, 325+i*100);
			}
				
			g.drawLine(margin, 350+i*100, Window.width-margin, 350+i*100);
		}
		
		
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
