package States;

import java.awt.Font;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import core.Window;

public class CreditsState extends BasicGameState{

	UnicodeFont font = new UnicodeFont(new Font("Minecraftia", Font.PLAIN, 50));
	TrueTypeFont fieldFont=new TrueTypeFont(new Font("Minecraftia", Font.PLAIN, 50), false);
	
	private Integer dominik = -100;
	private Integer krzychu = -200;
	private Integer marcin = -300;
	private Integer mateosz = -400;

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		// TODO Auto-generated method stub
		font.addGlyphs("���꿟�");
		font.getEffects().add(new ColorEffect(java.awt.Color.white));
		font.addGlyphs("���꿟�"); // szczeg�lnie wa�na jest ta linijka bo
										// to ona dodaje polskie znaki
		font.addNeheGlyphs();
		font.loadGlyphs();
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		
		g.setFont(font);
		g.drawString("Dominik Nowak", 200, dominik);
		g.drawString("Krzysztof Peziol", 200, krzychu);
		g.drawString("Marcin Migda", 200, marcin);
		g.drawString("Mateusz Skocz", 200, mateosz);

	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		// TODO Auto-generated method stub
		dominik++;
		krzychu++;
		marcin++;
		mateosz++;
		
		if (gc.getInput().isKeyPressed(Input.KEY_ENTER)||gc.getInput().isKeyPressed(Input.KEY_ESCAPE)) {
			dominik = -100;
			krzychu = -200;
			marcin = -300;
			mateosz = -400;
			sbg.enterState(StatesCodes.GAMESTATE);
		}
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 4;
	}

}
