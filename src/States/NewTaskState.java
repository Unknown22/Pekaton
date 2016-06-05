package States;

import java.util.ArrayList;
import java.util.List;
import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import GameElements.Worker;
import core.Resources;
import core.Window;
import model.Pracownik;
import model.Sprint;
import model.Zadanie;
import database.DataBase;


public class NewTaskState extends BasicGameState {

	DataBase db = new DataBase();
	int margin=40;
	int cellMargin=10;
	Pracownik pracownik;
	ArrayList<Zadanie> zadania;
	List<Sprint> sprinty=db.getAllSprints();
	int cellWidth=(Window.width-margin*2)/3;
	int cellWidth2=(Window.width-margin*2)/4;
	UnicodeFont font = new UnicodeFont(new Font("Minecraftia", Font.PLAIN, 20));
	int i=0; //nr zadania
	int id=-1;
	int takenTaskId[];
	
	 private Sound click;
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		// TODO Auto-generated method stub
		font.getEffects().add(new ColorEffect(java.awt.Color.white));
		font.addGlyphs("¹æ³óê¿Ÿñœ"); // szczegï¿½lnie waï¿½na jest ta linijka bo
		// to ona dodaje polskie znaki
		font.addNeheGlyphs();
		font.loadGlyphs();
		click = Resources.getSound("click");

		
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
		g.drawString("Zadania do wziêcia: ("+(i+1)+"/"+zadania.size()+")", Window.width/2-margin, 250);
		
		
		g.setColor(new Color(0x1E1B68));
		if(zadania.isEmpty()==false)
		{
			String opisTemp=zadania.get(i).getOpis();
			if(opisTemp.length()>46)
			{
				g.drawString(opisTemp.substring(0, 46), margin+cellMargin, 300);
				g.drawString(opisTemp.substring(46, opisTemp.length()), margin+cellMargin, 325);
			}
			else
				g.drawString(zadania.get(i).getOpis(), margin+cellMargin, 300);
			
			g.setColor(Color.darkGray);
			g.drawString(Integer.toString(zadania.get(i).getDoswiadczenie()), margin+cellMargin, 275);
			g.drawString(zadania.get(i).getZleceniodawca(), margin+cellMargin, 350);
			
			if(takenTaskId[i]==1)
				g.drawString("Zadanie wziête", margin+cellMargin, 400);
			else
				g.drawImage(Resources.getSpritesheet("wezzadanie").getSubImage(0, 0, 120, 32), margin+cellMargin, 400 );
			
			if(zadania.get(i).getIdSprintu()>0)
			{
				String pocz=sprinty.get(zadania.get(i).getIdSprintu()-1).getPoczatek();
				String koniec=sprinty.get(zadania.get(i).getIdSprintu()-1).getKoniec();
				
				g.setColor(Color.blue);
				g.drawString("Data rozpoczêcia sprintu:", margin+cellMargin, 450);
				g.setColor(Color.darkGray);
				g.drawString(pocz, margin+cellMargin+400, 450);
				g.setColor(Color.blue);
				g.drawString("Data zakoñczenia sprintu:", margin+cellMargin, 475);
				g.setColor(Color.darkGray);
				g.drawString(koniec, margin+cellMargin+400, 475);
			}
		}
		else
		{
			g.drawString("Brak zadañ½", margin+cellMargin, 300);
		}
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int alpha) throws SlickException {
		// TODO Auto-generated method stub
		
		if(Worker.id>=0 && id!=Worker.id)
		{
			id=Worker.id;
			pracownik=db.getPracownikByID(id);
			zadania = (ArrayList<Zadanie>) db.getWolneZadania();
			i=0;
			takenTaskId=new int[zadania.size()];
			for(int j=0; j<zadania.size(); j++)
			{
				takenTaskId[j]=0;
			}
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

			 if (
					 
					 gc.getInput().isMousePressed(0)) {
				 click.play(); 
				 sbg.enterState(StatesCodes.GAMESTATE);
				 id=Worker.id;
				pracownik=db.getPracownikByID(id);
				zadania = (ArrayList<Zadanie>) db.getWolneZadania();
				i=0;
				takenTaskId=new int[zadania.size()];
				for(int j=0; j<zadania.size(); j++)
				{
					takenTaskId[j]=0;
				}
			 }
		}
		if ((xpos > 50 && xpos < 50+120) && (ypos > 400 && ypos < 400+34)) {

			 if (gc.getInput().isMousePressed(0)) {
				 db.setPracownikToZadanie(pracownik.getId(), zadania.get(i).getId());
				 takenTaskId[i]=1;
			 }
		}
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return StatesCodes.NEWTASKSTATE ;
	}

}
