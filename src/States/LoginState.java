package States;

import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import core.Resources;
import core.Window;

public class LoginState extends BasicGameState {
	
	UnicodeFont font = new UnicodeFont(new Font("Minecraftia", Font.PLAIN, 20));
	TextField login;
	int margin=40;

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		// TODO Auto-generated method stub
		font.addGlyphs("¹æ³óê¿Ÿñœ");
		font.getEffects().add(new ColorEffect(java.awt.Color.white));
		font.addGlyphs("¹æ³óê¿Ÿñœ"); // szczególnie wa¿na jest ta linijka bo
											// to ona dodaje polskie znaki
		font.addNeheGlyphs();
		font.loadGlyphs();
		
		login=new TextField(gc, font, 150, 100, Window.width/-margin*2, 120);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		g.drawImage(Resources.getSpritesheet("monitor").getSubImage(0, 0, Window.width, Window.height), 0 ,0);
		g.setFont(font);
		g.setColor(Color.blue);
		g.drawString("Zaloguj siê:", Window.width/2-margin, 50);
		login.render(gc, g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int alpha) throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return StatesCodes.LOGINSTATE;
	}

}
