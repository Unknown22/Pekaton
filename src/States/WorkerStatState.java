package States;

import java.util.ArrayList;

import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import GameElements.Worker;
import core.Resources;
import core.Window;
import model.Pracownik;
import model.Zadanie;
import database.DataBase;


public class WorkerStatState extends BasicGameState {

	DataBase db = new DataBase();
	int margin=40;
	int cellMargin=10;
	Pracownik pracownik;
	ArrayList<Zadanie> zadania;
	int cellWidth=(Window.width-margin*2)/3;
	int cellWidth2=(Window.width-margin*2)/4;
	UnicodeFont font = new UnicodeFont(new Font("Minecraftia", Font.PLAIN, 20));
	int i=0;
	
	int id=-1;
	
	
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		// TODO Auto-generated method stub
		font.addGlyphs("¹æ³óê¿Ÿñœ");
		font.getEffects().add(new ColorEffect(java.awt.Color.white));
		font.addGlyphs("¹æ³óê¿Ÿñœ"); // szczególnie wa¿na jest ta linijka bo
											// to ona dodaje polskie znaki
		font.addNeheGlyphs();
		font.loadGlyphs();
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		g.drawImage(Resources.getSpritesheet("monitor_window").getSubImage(0, 0, Window.width, Window.height), 0 ,0);
		
		g.setFont(font);
		g.setColor(Color.blue);
		g.drawString(pracownik.getLogin(), Window.width/2-margin, 100);
		g.setColor(Color.black);
		g.drawString("ID", margin+cellMargin, 150);
		g.drawString("Stanowisko", margin+cellMargin+cellWidth, 150);
		g.drawString("Doœwiadczenie", margin+cellMargin+cellWidth*2, 150);
		
		g.setColor(Color.darkGray);
		g.drawString(Integer.toString(pracownik.getId()), margin+cellMargin, 200);
		g.drawString(pracownik.getStanowisko(), margin+cellMargin+cellWidth, 200);
		g.drawString(Integer.toString(pracownik.getExp()), margin+cellMargin+cellWidth*2, 200);
		
		g.setColor(Color.blue);
		g.drawString("Zadania", Window.width/2-margin, 250);
		
		
		g.setColor(new Color(0x1E1B68));
		if(zadania.isEmpty()==false)
		{
			g.drawString(zadania.get(i).getOpis(), margin+cellMargin, 300);
			g.setColor(Color.darkGray);
			g.drawString(Integer.toString(zadania.get(i).getDoswiadczenie()), margin+cellMargin, 275);
			g.drawString(zadania.get(i).getZleceniodawca(), margin+cellMargin, 350);
			if(zadania.get(i).getStatus()==0)
			{
				g.setColor(Color.red);
				g.drawString("Niewykonane", margin+cellMargin, 375);
			}
				
			else
			{
				g.setColor(new Color(0x12902B));
				g.drawString("Wykonane", margin+cellMargin, 375);
			}
		}
		else
		{
			g.drawString("Brak zadañ", margin+cellMargin, 300);
		}
		
				

		
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int alpha) throws SlickException {
		// TODO Auto-generated method stub
		
		if(Worker.id>=0 && id!=Worker.id)
		{
			id=Worker.id;
			System.out.println("Id:"+id);
			pracownik=db.getPracownikByID(id);
			zadania = (ArrayList<Zadanie>) db.getZadaniaByPracownikId(id);
		}
			
		
		
		
		if(gc.getInput().isKeyPressed(Input.KEY_L) || gc.getInput().isKeyPressed(Input.KEY_ESCAPE)){
			sbg.enterState(StatesCodes.GAMESTATE);
		}
		if (gc.getInput().isKeyPressed(Input.KEY_W) || gc.getInput().isKeyPressed(Input.KEY_UP))
		{
			if(i+1<zadania.size())
				i++;
		}
		
		if (gc.getInput().isKeyPressed(Input.KEY_S) || gc.getInput().isKeyPressed(Input.KEY_DOWN))
		{
			if(i>0)
				i--;
				
		}
		
		int xpos = gc.getInput().getAbsoluteMouseX();
		int ypos = gc.getInput().getAbsoluteMouseY();
		
		if ((xpos > 739 && xpos < 739+18) && (ypos > 40 && ypos < 40+20)) {

			 if (gc.getInput().isMousePressed(0)) {
				 sbg.enterState(StatesCodes.GAMESTATE);
			 }
			 
		  }
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return StatesCodes.WORKERSTATE;
	}

}
