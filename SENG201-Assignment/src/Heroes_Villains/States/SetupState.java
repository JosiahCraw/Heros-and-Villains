package Heroes_Villains.States;

import Heroes_Villains.Game;
import Heroes_Villains.SystemUI.RadioButton;
import Heroes_Villains.SystemUI.RadioButtons;
import Heroes_Villains.SystemUI.TextField;
import Heroes_Villains.SystemUI.UIButton;
import Heroes_Villains.SystemUI.UIElement;
import Heroes_Villains.entities.Player;
import Heroes_Villains.graphics.Assets;
import com.sun.corba.se.spi.servicecontext.UEInfoServiceContext;

import javax.swing.*;
import java.awt.*;

public class SetupState extends State{

    private UIElement backButton;
    private RadioButtons citySelect;
    private RadioButtons heroSelect;
    private UIElement teamButton;
    private TextField entry;


    public SetupState(Game game) {
        super(game);
        backButton = new UIButton(540, 553, game, Assets.backButton, 200, 35);
        teamButton = new UIButton(540, 483, game, Assets.teamButton, 200, 35);
        citySelect = new RadioButtons(900, 268, game, Assets.testRadioButton, 4, 25, true, 32, 32);
        heroSelect = new RadioButtons(900, 368, game, Assets.testRadioButton, 3, 25, true, 32, 32);
        entry = new TextField(500, 175, 200, 25, game, Assets.textField, 10, 2);

    }

    @Override
    public void update() {
        backButton.update();
        citySelect.update();
        heroSelect.update();
        entry.update();
        teamButton.update();

        if(game.getMouseListener().isLeftClicked() && backButton.click()){
            game.getMouseListener().leftClicked = false;
            game.getStateHandler().setState(game.getMenuState());
        }

        if(game.getMouseListener().isLeftClicked() && teamButton.click()){
            game.getMouseListener().leftClicked = false;
            String teamname = entry.getInput();
            int numC = citySelect.currentlyClicked + 3;
            int numH = heroSelect.currentlyClicked + 1;
            System.out.println(teamname + " " + numC + " " + numH);
            game.setNoOfCities(numC);
            game.gameState = new GameState(game);
            game.player = ((GameState) game.gameState).player;
        }
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setFont(Assets.smallFont);
        graphics.drawString("Enter Team Name: " , 200, 200);
        graphics.drawString("Pick the number of cities:" , 200, 300);
        graphics.drawString("Pick the amount of heros on your team:", 200, 400);

        for(int i=0; i < citySelect.getButtons().length; i++) {
            graphics.drawString(""+(i+3), citySelect.getButtons()[i].x + citySelect.getButtons()[i].getWidth()/2, citySelect.getButtons()[i].y - citySelect.getButtons()[i].getHeight()/2);
        }

        for(int i=0; i < heroSelect.getButtons().length; i++) {
            graphics.drawString("" + (i + 1), heroSelect.getButtons()[i].x + heroSelect.getButtons()[i].getWidth() / 2, heroSelect.getButtons()[i].y - heroSelect.getButtons()[i].getHeight() / 2);
        }

        backButton.render(graphics);
        citySelect.render(graphics);
        heroSelect.render(graphics);
        teamButton.render(graphics);
        entry.render(graphics);
    }
    //pass
}
