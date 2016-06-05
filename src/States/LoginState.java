package States;

import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
//import org.newdawn.slick.gui.TextField;

import GameElements.TextField;

import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import GameElements.Worker;
import core.Resources;
import core.Window;
import database.DataBase;

public class LoginState extends BasicGameState {
	
	UnicodeFont font = new UnicodeFont(new Font("Minecraftia", Font.PLAIN, 20));
	TrueTypeFont fieldFont=new TrueTypeFont(new Font("Minecraftia", Font.PLAIN, 20), false);
	TextField login;
	TextField password;
	int margin=40;
	DataBase db = new DataBase();
	int isAlreadyLogged=0;


	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		// TODO Auto-generated method stub
		font.addGlyphs("¹æ³óê¿Ÿñœ");
		font.getEffects().add(new ColorEffect(java.awt.Color.white));
		font.addGlyphs("¹æ³óê¿Ÿñœ"); // szczególnie wa¿na jest ta linijka bo
										// to ona dodaje polskie znaki
		font.addNeheGlyphs();
		font.loadGlyphs();
		
		login=new TextField(gc, gc.getDefaultFont(), 150, 170, 450, 20, new ComponentListener() {
			public void componentActivated(AbstractComponent source) {
			}
			});
		
		password=new TextField(gc, gc.getDefaultFont(), 150, 240, 450, 20, new ComponentListener() {
			public void componentActivated(AbstractComponent source) {
			}
			});
		password.setMaskEnabled(true);
		password.setMaskCharacter('*');
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		// TODO Auto-generated method stub

		if(isAlreadyLogged==0 ||isAlreadyLogged==2)
		{
			g.drawImage(Resources.getSpritesheet("monitor_login").getSubImage(0, 0, Window.width, Window.height), 0 ,0);
			g.setFont(font);
			g.setColor(Color.black);
			g.drawString("Zaloguj siê½", Window.width/2-margin, 100);
			g.drawString("Login:", 150, 130);
			
			g.setColor(Color.black);
			login.setInput(gc.getInput());
			g.setColor(Color.white);
			login.render(gc, g);
			
			g.setColor(Color.black);
			g.drawString("Haslo:", 150, 200);
			
			g.setColor(Color.black);
			password.setInput(gc.getInput());
			g.setColor(Color.white);
			password.render(gc, g);
			
			if(isAlreadyLogged==2)
			{
				g.setFont(font);
				g.setColor(Color.black);
				g.drawString("Niepoprawny login lub haslo", Window.width/2-margin*4, 280);
			}

		}
		else
		{
			g.drawImage(Resources.getSpritesheet("monitor_window").getSubImage(0, 0, Window.width, Window.height), 0 ,0);
			g.setFont(font);
			g.setColor(Color.black);
			g.drawString("Zalogowano pomyœlnie", Window.width/2-margin*4, Window.height/2);
		}
		
		
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int alpha) throws SlickException {
		// TODO Auto-generated method stub
		
		if(gc.getInput().isKeyPressed(Input.KEY_ESCAPE))
		{
			sbg.enterState(StatesCodes.GAMESTATE);
		}
		
		 int xpos = gc.getInput().getAbsoluteMouseX();
		 int ypos = gc.getInput().getAbsoluteMouseY();

		 if ((xpos > 150 && xpos < 600) && (ypos > 190 && ypos < 210)) {

		     if (gc.getInput().isMousePressed(0)) {
		    	 password.setFocus(true);
		     }
		  }
		 if ((xpos > 150 && xpos < 600) && (ypos > 120 && ypos < 140)) {

		     if (gc.getInput().isMousePressed(0)) {
		    	 login.setFocus(true);
		     }
		 }
		 
		 if ((xpos > 340 && xpos < 462) && (ypos > 322 && ypos < 354)) {//tu zmienic na przycisk

			 if (gc.getInput().isMousePressed(0)) {
				 String log=login.getText();
			     String pass=password.getText();
			     int id=db.getIdBy(log, pass);
			     if(id>=0)
			     {
			    	 Worker.id=id;

			    	 isAlreadyLogged=1;
			     }
			     else
			     {
			    	 isAlreadyLogged=2;
			     }
			 } 
		 }
		 
		 if ((xpos > 739 && xpos < 739+18) && (ypos > 40 && ypos < 40+20)) {

			 if (gc.getInput().isMousePressed(0)) {
				 sbg.enterState(StatesCodes.GAMESTATE);
			 }
			 
		  }
		 
		 
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return StatesCodes.LOGINSTATE;
	}

}
